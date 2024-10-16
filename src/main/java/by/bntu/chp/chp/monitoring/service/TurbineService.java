package by.bntu.chp.chp.monitoring.service;

import by.bntu.chp.chp.monitoring.exception.EntityNotFoundException;
import by.bntu.chp.chp.monitoring.repository.TurbinePressureMetricRepository;
import by.bntu.chp.chp.monitoring.repository.TurbineRepository;
import by.bntu.chp.chp.monitoring.service.model.Turbine;
import by.bntu.chp.chp.monitoring.service.model.TurbinePressureMetric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class TurbineService {
    private final TurbinePressureMetricRepository repository;

    private final TurbineRepository turbineRepository;

    public List<Turbine> findAll(){
        return turbineRepository.findAll();
    }

    public Turbine findById(Long id){
        return turbineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turbine is not found by Id - " + id));
    }

    public List<TurbinePressureMetric> findMetricByTurbineId(Long id){
        return repository.findByTurbineId(id);
    }

    public void saveMetric(Long turbineId, Double pressure){
        Turbine turbine = this.findById(turbineId);

        TurbinePressureMetric metric = new TurbinePressureMetric();
        metric.setTurbine(turbine);
        metric.setPressure(pressure);
        metric.setTimestamp(LocalDateTime.now());

        repository.save(metric);
    }

    public List<List<Object>> getTurbineMetric(LocalDateTime startDate, LocalDateTime endDate) {
        List<TurbinePressureMetric> metrics = repository.findByTimestampBetweenOrderByTimestampAsc(startDate, endDate);
        Map<String, List<TurbinePressureMetric>> groupedMetrics = metrics.stream()
                .collect(groupingBy(metric -> metric.getTurbine().getRegistrationNumber()));
        List<String> numbers = new ArrayList<>(groupedMetrics.keySet());
        List<Object> titles = new ArrayList<>(List.of("Время"));
        titles.addAll(numbers);
        List<List<Object>> result = new ArrayList<>();
        result.add(titles);

        for (int i = 0; i < groupedMetrics.get(numbers.get(0)).size(); i++) {
            List<Object> row = new ArrayList<>();
            row.add(groupedMetrics.get(numbers.get(0)).get(i).getTimestamp().toString());
            for (String number : numbers) {
                row.add(groupedMetrics.get(number).get(i).getPressure());
            }
            result.add(row);
        }
        return result;
    }
}
