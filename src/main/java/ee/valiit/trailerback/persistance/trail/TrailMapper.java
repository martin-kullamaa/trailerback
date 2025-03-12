package ee.valiit.trailerback.persistance.trail;

import ee.valiit.trailerback.controller.trail.NewTrailDto;
import ee.valiit.trailerback.controller.trailview.TrailViewDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface TrailMapper {

    @Mapping(source = "profile.id", target = "profileId")
    @Mapping(source = "name", target = "trailName")
    @Mapping(source = "description", target = "trailDescription")
    @Mapping(source = "length", target = "trailLength")
    @Mapping(source = "locationStart", target = "startName")
    TrailViewDto toTrailViewDto(Trail trail);


    @Mapping(source = "trailName", target = "name")
    @Mapping(source = "trailDescription", target = "description")
    @Mapping(source = "trailLength", target = "length")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    Trail newTrailDtoToTrail(NewTrailDto newTrailDto);

}