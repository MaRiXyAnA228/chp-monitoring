package by.bntu.chp.chp.monitoring.controller.dto;

import java.time.LocalDate;

public record BoilerSteamMetricDTO(
        Long id,
        Long boilerId,
        LocalDate timestamp,
        Double steamVolume
) {
}
