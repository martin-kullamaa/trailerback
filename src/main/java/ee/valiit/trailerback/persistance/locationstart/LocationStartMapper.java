package ee.valiit.trailerback.persistance.locationstart;

import ee.valiit.trailerback.controller.location.LocationStartDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationStartMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    LocationStartDto locationStartToDto(LocationStart locationStart);


    List<LocationStartDto> locationStartToDtos(List<LocationStart> locationStarts);

}