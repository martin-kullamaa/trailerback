package ee.valiit.trailerback.persistance.trailpicture;

import ee.valiit.trailerback.controller.picture.TrailPictureDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;
import org.mapstruct.MappingConstants;
import java.util.Base64;
import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class}
)
public interface TrailPictureMapper {

    // Mapping from entity to DTO:
    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data", qualifiedByName = "byteToBase64")
    TrailPictureDto trailPictureToTrailPictureDto(TrailPicture trailPicture);

    List<TrailPictureDto> trailPictureToTrailPictureDtos(List<TrailPicture> trailPictures);

    // Mapping from DTO to entity:
    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data", qualifiedByName = "toData")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    TrailPicture trailPictureDtoToTrailPicture(TrailPictureDto trailPictureDto);

    // Convert byte[] to Base64 String
    @Named("byteToBase64")
    default String byteToBase64(byte[] value) {
        return (value != null) ? Base64.getEncoder().encodeToString(value) : null;
    }

    // Convert Base64 String to byte[]
    @Named("toData")
    default byte[] toData(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return Base64.getDecoder().decode(value);
    }
}
