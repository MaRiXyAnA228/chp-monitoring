package by.bntu.chp.chp.monitoring.controller;

import by.bntu.chp.chp.monitoring.controller.dto.BoilerDTO;
import by.bntu.chp.chp.monitoring.controller.dto.BoilerSteamMetricDTO;
import by.bntu.chp.chp.monitoring.controller.mapper.BoilerMapper;
import by.bntu.chp.chp.monitoring.controller.mapper.BoilerSteamMetricMapper;
import by.bntu.chp.chp.monitoring.service.BoilerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boilers")
@RequiredArgsConstructor
public class BoilerController {
    private final BoilerService boilerService;
    private final BoilerMapper boilerMapper;
    private final BoilerSteamMetricMapper boilerSteamMetricMapper;

    @GetMapping
    public List<BoilerDTO> findAll(){
        return boilerMapper.mapToApiResponse(boilerService.findAll());
    }

    @GetMapping("/{id}")
    public BoilerDTO findById(@PathVariable("id") Long id){
        return boilerMapper.mapToApiResponse(boilerService.findById(id));
    }

    @GetMapping("/{id}/metrics")
    public List<BoilerSteamMetricDTO> findMetricByBoilerId(@PathVariable("id") Long boilerId){
        return boilerSteamMetricMapper.mapToApiResponse(boilerService.findMetricByBoilerId(boilerId));
    }

    @PostMapping("/{id}/metrics")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBoilerMetric(@PathVariable("id") Long boilerId, @RequestBody Double steamVolume){
        boilerService.saveMetric(boilerId, steamVolume);
    }
}
