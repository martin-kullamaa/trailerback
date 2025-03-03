package ee.valiit.trailerback.persistance.trailtype;

import ee.valiit.trailerback.persistance.type.Type;
import ee.valiit.trailerback.persistance.trail.Trail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trail_type", schema = "trailer")
public class TrailType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trail_type_id_gen")
    @SequenceGenerator(name = "trail_type_id_gen", sequenceName = "trail_type_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trail;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

}