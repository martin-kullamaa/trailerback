package ee.valiit.trailerback.controller.picture;

import ee.valiit.trailerback.persistance.trailpicture.TrailPicture;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link TrailPicture}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrailPictureDto implements Serializable {
    @NotNull
    private String data;
    @Size(max = 255)
    private String name;
}