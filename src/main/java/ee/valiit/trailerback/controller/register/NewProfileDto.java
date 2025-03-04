package ee.valiit.trailerback.controller.register;

import ee.valiit.trailerback.persistance.profile.Profile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Profile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProfileDto implements Serializable {
    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    @NotNull
    @Size(max = 255)
    private String email;
}