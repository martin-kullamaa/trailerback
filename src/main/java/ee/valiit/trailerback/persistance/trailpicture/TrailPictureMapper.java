package ee.valiit.trailerback.persistance.trailpicture;

import ee.valiit.trailerback.controller.picture.TrailPictureDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface TrailPictureMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data")
    TrailPictureDto trailPictureToTrailPictureDto(TrailPicture trailPicture);

    List<TrailPictureDto> trailPictureToTrailPictureDtos(List<TrailPicture> trailPictures);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    TrailPicture trailPictureDtoToTrailPicture(TrailPictureDto trailPictureDto);

}