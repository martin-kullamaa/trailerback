package ee.valiit.trailerback.controller.equipment;

import ee.valiit.trailerback.persistance.equipment.Equipment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Equipment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements Serializable {
    @NotNull
    @Size(max = 255)
    private String name;
}