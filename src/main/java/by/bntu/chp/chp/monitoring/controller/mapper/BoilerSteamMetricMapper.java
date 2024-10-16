package by.bntu.chp.chp.monitoring.controller.mapper;

import by.bntu.chp.chp.monitoring.controller.dto.BoilerSteamMetricDTO;
import by.bntu.chp.chp.monitoring.service.model.BoilerSteamMetric;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface BoilerSteamMetricMapper {

    List<BoilerSteamMetricDTO> mapToApiResponse(List<BoilerSteamMetric> boilerSteamMetrics);

    @Mapping(source = "boiler.id", target = "boilerId")
    BoilerSteamMetricDTO mapToApiResponse(BoilerSteamMetric boilerSteamMetric);
}
