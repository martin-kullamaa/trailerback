package ee.valiit.trailerback.persistance.locationstop;

import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location_stop", schema = "trailer")
public class LocationStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationStart location;

    @NotNull
    @Column(name = "latitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @NotNull
    @Column(name = "sequence", nullable = false)
    private Integer sequence;

}