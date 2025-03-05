package ee.valiit.trailerback.controller.login;

import ee.valiit.trailerback.persistance.profile.Profile;
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
public class LoginResponseDto implements Serializable {
    private Integer profileId;
    private String roleName;
}