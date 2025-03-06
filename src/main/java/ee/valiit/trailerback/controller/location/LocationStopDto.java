package ee.valiit.trailerback.controller.location;

import ee.valiit.trailerback.persistance.locationstop.LocationStop;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link LocationStop}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationStopDto implements Serializable {
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
    @NotNull
    private Integer sequence;
}