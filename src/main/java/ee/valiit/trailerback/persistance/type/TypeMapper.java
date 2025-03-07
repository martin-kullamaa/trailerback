package ee.valiit.trailerback.persistance.type;

import ee.valiit.trailerback.controller.type.TypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {

    @Mapping(source = "name", target = "name")
    TypeDto typeToTypeDto(Type type);

    List<TypeDto> typeToTypeDtos(List<Type> type);

}