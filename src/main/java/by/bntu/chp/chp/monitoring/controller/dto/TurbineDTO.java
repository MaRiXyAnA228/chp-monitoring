package by.bntu.chp.chp.monitoring.controller.dto;

import java.sql.Date;

public record TurbineDTO(
        Long id,
        String registrationNumber,
        Date nextInspectionDate,
        Date installationDate
) {

}
