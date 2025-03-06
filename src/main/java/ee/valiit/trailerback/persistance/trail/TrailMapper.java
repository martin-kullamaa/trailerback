package ee.valiit.trailerback.persistance.trail;

import ee.valiit.trailerback.controller.trailcontroller.NewTrailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrailMapper {

    @Mapping(source = "profileId", target = "profile")
    @Mapping(source = "trailName", target = "name")
    @Mapping(source = "trailDescription", target = "description")
    @Mapping(source = "trailLength", target = "length")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    Trail newTrailDtoToTrail(NewTrailDto newTrailDto);

}