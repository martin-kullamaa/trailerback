package ee.valiit.trailerback.controller.location;

import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link LocationStart}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationStartDto implements Serializable {
    @NotNull
    private Integer startId;
    @Size(max = 255)
    private String name;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}