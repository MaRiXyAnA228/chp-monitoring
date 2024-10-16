package by.bntu.chp.chp.monitoring.controller;

import by.bntu.chp.chp.monitoring.service.BoilerService;
import by.bntu.chp.chp.monitoring.service.TurbineService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ChartController {
    private final BoilerService boilerService;
    private final TurbineService turbineService;

    @GetMapping({"/charts"})
    public String index(@RequestParam(name = "startDate", defaultValue = "2023-11-01", required = false)
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                        @RequestParam(name = "endDate", defaultValue = "2023-12-01", required = false)
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                        Model model) {
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("steamMetrics", boilerService.getBoilerChartMetric(startDate, endDate));
        model.addAttribute("pressureMetrics", turbineService.getTurbineMetric(startDate.atStartOfDay(), endDate.atStartOfDay()));
        return "charts";
    }

    }


