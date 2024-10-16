package by.bntu.chp.chp.monitoring.controller.mapper;

import by.bntu.chp.chp.monitoring.controller.dto.TurbinePressureMetricDTO;
import by.bntu.chp.chp.monitoring.service.model.TurbinePressureMetric;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TurbinePressureMetricMapper {

    List<TurbinePressureMetricDTO> mapToApiResponse(List<TurbinePressureMetric> turbinePressureMetrics);

    @Mapping(source = "turbine.id", target = "turbineId")
    TurbinePressureMetricDTO mapToApiResponse(TurbinePressureMetric turbinePressureMetric);
}
