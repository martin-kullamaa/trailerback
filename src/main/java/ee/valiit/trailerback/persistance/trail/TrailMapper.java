package ee.valiit.trailerback.persistance.trail;

import ee.valiit.trailerback.controller.location.LocationStopDto;
import ee.valiit.trailerback.controller.trail.NewTrailDto;
import ee.valiit.trailerback.controller.trail.TrailDto;
import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import ee.valiit.trailerback.persistance.locationstop.LocationStop;
import ee.valiit.trailerback.status.Status;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface TrailMapper {

    @Mapping(source = "trailName", target = "name")
    @Mapping(source = "trailDescription", target = "description")
    @Mapping(source = "trailLength", target = "length")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    Trail newTrailDtoToTrail(NewTrailDto newTrailDto);

    @Mapping(source = "trail.id", target = "trailId")
    @Mapping(source = "trail.profile.id", target = "profileId")
    @Mapping(source = "trail.name", target = "trailName")
    @Mapping(source = "trail.description", target = "trailDescription")
    @Mapping(source = "trail.length", target = "trailLength")
    @Mapping(source = "locationStart.name", target = "startName")
    @Mapping(source = "locationStart.latitude", target = "startLatitude")
    @Mapping(source = "locationStart.longitude", target = "startLongitude")
    @Mapping(source = "locationStops", target = "locationStopDtos")
    TrailDto trailWithLocationsToTrailDto(Trail trail, LocationStart locationStart, List<LocationStop> locationStops);

    // Assuming you have a mapping method for a single LocationStop to its DTO:
    LocationStopDto locationStopToLocationStopDto(LocationStop locationStop);

    @Mapping(source = "trailName", target = "name")
    @Mapping(source = "trailDescription", target = "description")
    @Mapping(source = "trailLength", target = "length")
    void updateTrailFromTrailDto(TrailDto trailDto,@MappingTarget Trail trail);
}