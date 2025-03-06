package ee.valiit.trailerback.persistance.trailequipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrailEquipmentRepository extends JpaRepository<TrailEquipment, Integer> {

    @Query("select t from TrailEquipment t where t.trail.id = ?1")
    List<TrailEquipment> findByTrailId(Integer id);

}