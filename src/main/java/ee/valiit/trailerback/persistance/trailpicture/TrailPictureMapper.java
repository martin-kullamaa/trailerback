package ee.valiit.trailerback.persistance.trailpicture;

import ee.valiit.trailerback.controller.picture.TrailPictureDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class}
)
public interface TrailPictureMapper {

    // Mapping from entity to DTO:
    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data", qualifiedByName = "byteToBase64WithPrefix")
    TrailPictureDto trailPictureToTrailPictureDto(TrailPicture trailPicture);

    List<TrailPictureDto> trailPictureToTrailPictureDtos(List<TrailPicture> trailPictures);

    // Mapping from DTO to entity:
    @Mapping(source = "name", target = "name")
    @Mapping(source = "data", target = "data", qualifiedByName = "toData")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    TrailPicture trailPictureDtoToTrailPicture(TrailPictureDto trailPictureDto);

    // Convert byte[] to Base64 String
    @Named("byteToBase64WithPrefix")
    default String byteToBase64WithPrefix(byte[] data) {
        if (data == null) {
            return null;
        }
        // Here you assume JPEG; adjust if necessary (e.g., check file extension/type).
        return "data:image/jpeg;base64," + java.util.Base64.getEncoder().encodeToString(data);
    }

    @Named("toData")
    default byte[] toData(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Remove MIME prefix if present.
        if (value.startsWith("data:")) {
            value = value.substring(value.indexOf(",") + 1);
        }
        return java.util.Base64.getDecoder().decode(value);
    }
}
