package ee.valiit.trailerback.persistance.locationstart;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location_start", schema = "trailer")
public class LocationStart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_start_id_gen")
    @SequenceGenerator(name = "location_start_id_gen", sequenceName = "location_start_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "latitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

}