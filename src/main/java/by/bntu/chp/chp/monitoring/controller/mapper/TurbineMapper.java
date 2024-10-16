package by.bntu.chp.chp.monitoring.controller.mapper;

import by.bntu.chp.chp.monitoring.controller.dto.TurbineDTO;
import by.bntu.chp.chp.monitoring.service.model.Turbine;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TurbineMapper {

    TurbineDTO mapToApiResponse(Turbine turbine);

    List<TurbineDTO> mapToApiResponse(List<Turbine> turbines);
}
