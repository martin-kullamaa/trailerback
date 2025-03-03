package ee.valiit.trailerback.persistance.trailequipment;

import ee.valiit.trailerback.persistance.equipment.Equipment;
import ee.valiit.trailerback.persistance.trail.Trail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trail_equipment", schema = "trailer")
public class TrailEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trail_equipment_id_gen")
    @SequenceGenerator(name = "trail_equipment_id_gen", sequenceName = "trail_equipment_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trail;

}