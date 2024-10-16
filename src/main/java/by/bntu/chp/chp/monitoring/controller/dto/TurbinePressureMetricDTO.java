package by.bntu.chp.chp.monitoring.controller.dto;

import java.time.LocalDateTime;

public record TurbinePressureMetricDTO(
        Long id,
        Long turbineId,
        Double pressure,
        LocalDateTime timestamp
) {
}
