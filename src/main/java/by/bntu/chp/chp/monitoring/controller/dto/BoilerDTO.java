package by.bntu.chp.chp.monitoring.controller.dto;

import java.sql.Date;

public record BoilerDTO(
        Long id,
        String registrationNumber,
        Date nextInspectionDate,
        Integer manufactureYear,
        Date installationDate,
        double maxPressure,
        String producer,
        String model
) {
}
