package by.bntu.chp.chp.monitoring.controller;

import by.bntu.chp.chp.monitoring.controller.dto.TurbineDTO;
import by.bntu.chp.chp.monitoring.controller.dto.TurbinePressureMetricDTO;
import by.bntu.chp.chp.monitoring.controller.mapper.TurbineMapper;
import by.bntu.chp.chp.monitoring.controller.mapper.TurbinePressureMetricMapper;
import by.bntu.chp.chp.monitoring.service.TurbineService;
import by.bntu.chp.chp.monitoring.service.model.TurbinePressureMetric;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turbines")
@RequiredArgsConstructor
public class TurbineController {

    private final TurbineService turbineService;

    private final TurbineMapper turbineMapper;

    private final TurbinePressureMetricMapper turbinePressureMetricMapper;

    @GetMapping
    public List<TurbineDTO> findAll(){
        return turbineMapper.mapToApiResponse(turbineService.findAll());
    }

    @GetMapping("/{id}")
    public TurbineDTO findById(@PathVariable("id") Long id){
        return turbineMapper.mapToApiResponse(turbineService.findById(id));
    }

    @GetMapping("/{id}/metrics")
    public List<TurbinePressureMetricDTO> findMetricByTurbineId(@PathVariable("id") Long turbineId){
        return turbinePressureMetricMapper.mapToApiResponse(turbineService.findMetricByTurbineId(turbineId));
    }

    @PostMapping("/{id}/metrics")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTurbineMetric(@PathVariable("id") Long turbineId, @RequestBody Double pressure){
        turbineService.saveMetric(turbineId, pressure);
    }
}
