package ee.valiit.trailerback.persistance.trailpicture;

import ee.valiit.trailerback.persistance.trail.Trail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trail_picture", schema = "trailer")
public class TrailPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trail;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}