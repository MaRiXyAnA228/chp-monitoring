package by.bntu.chp.chp.monitoring.controller.mapper;

import by.bntu.chp.chp.monitoring.controller.dto.BoilerDTO;
import by.bntu.chp.chp.monitoring.service.model.Boiler;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface BoilerMapper {
    BoilerDTO mapToApiResponse(Boiler boiler);
    List<BoilerDTO> mapToApiResponse(List<Boiler> boilers);


}
