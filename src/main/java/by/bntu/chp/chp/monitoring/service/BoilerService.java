package by.bntu.chp.chp.monitoring.service;

import by.bntu.chp.chp.monitoring.exception.EntityNotFoundException;
import by.bntu.chp.chp.monitoring.repository.BoilerRepository;
import by.bntu.chp.chp.monitoring.repository.BoilerSteamMetricRepository;
import by.bntu.chp.chp.monitoring.service.model.Boiler;
import by.bntu.chp.chp.monitoring.service.model.BoilerSteamMetric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class BoilerService {
    private final BoilerSteamMetricRepository repository;
    private final BoilerRepository boilerRepository;

    public List<Boiler> findAll(){
        return boilerRepository.findAll();
    }

    public Boiler findById(Long id){
        return boilerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Boiler is not found by Id - " + id));
    }

    public List<BoilerSteamMetric> findMetricByBoilerId(Long id){
        return repository.findByBoilerId(id);
    }

    public void saveMetric(Long boilerId, Double value){
        Boiler boiler = this.findById(boilerId);

        BoilerSteamMetric metric = new BoilerSteamMetric();
        metric.setBoiler(boiler);
        metric.setSteamVolume(value);
        metric.setTimestamp(LocalDate.now());

        repository.save(metric);
    }
    public List<List<Object>> getBoilerChartMetric(LocalDate startDate, LocalDate endDate) {
        List<BoilerSteamMetric> metrics = repository.findByTimestampBetweenOrderByTimestampAsc(startDate, endDate);
        Map<String, List<BoilerSteamMetric>> groupedMetrics = metrics.stream()
                .collect(groupingBy(metric -> metric.getBoiler().getRegistrationNumber()));
        List<String> numbers = new ArrayList<>(groupedMetrics.keySet());
        List<Object> titles = new ArrayList<>(List.of("Время"));
        titles.addAll(numbers);
        List<List<Object>> result = new ArrayList<>();
        result.add(titles);

        for (int j = 0; j < groupedMetrics.get(numbers.get(0)).size(); j++) {
            List<Object> row = new ArrayList<>();
            row.add(groupedMetrics.get(numbers.get(0)).get(j).getTimestamp().toString());
            for (String number : numbers) {
                row.add(groupedMetrics.get(number).get(j).getSteamVolume());
            }
            result.add(row);
        }
        return result;
    }
}
