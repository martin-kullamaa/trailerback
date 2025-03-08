package ee.valiit.trailerback.persistance.equipment;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
import ee.valiit.trailerback.controller.equipment.NewEquipmentDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface EquipmentMapper {

    @Mapping(source = "id", target = "equipmentId")
    @Mapping(source = "name", target = "name")
    EquipmentDto equipmentToEquipmentDto(Equipment equipment);

    List<EquipmentDto> equipmentToEquipmentDtos(List<Equipment> equipment);

    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    Equipment equipmentDtoToEquipment(NewEquipmentDto newEquipmentDto);
}