package ee.valiit.trailerback.persistance.profile;

import ee.valiit.trailerback.persistance.role.Role;
import jakarta.validation.constraints.NotNull;
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
    private Integer userId;
    private String roleName;
}