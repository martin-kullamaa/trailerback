package ee.valiit.trailerback.controller.trailcontroller;


import ee.valiit.trailerback.controller.location.LocationStopDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTrailDto implements Serializable {

    @NotNull
    private Integer profileId;
    @NotNull
    private String trailName;
    @NotNull
    private String trailDescription;
    @NotNull
    private BigDecimal trailLength;

    @NotNull
    private String startName;
    @NotNull
    private BigDecimal startLatitude;
    @NotNull
    private BigDecimal startLongitude;

    @NotNull
    private List<LocationStopDto> locationStopDtos;

}
