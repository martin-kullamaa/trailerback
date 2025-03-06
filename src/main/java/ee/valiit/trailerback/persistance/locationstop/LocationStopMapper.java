package ee.valiit.trailerback.persistance.locationstop;

import ee.valiit.trailerback.controller.location.LocationStopDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface LocationStopMapper {


    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "sequence", target = "sequence")
    LocationStop locationStopDtoToLocationStop(LocationStopDto locationStopDto);

}