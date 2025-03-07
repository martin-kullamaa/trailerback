package ee.valiit.trailerback.controller.type;

import ee.valiit.trailerback.persistance.type.Type;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Type}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto implements Serializable {
    @NotNull
    @Size(max = 255)
    private String name;
}