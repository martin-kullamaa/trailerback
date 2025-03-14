package ee.valiit.trailerback.persistance.trailequipment;

import ee.valiit.trailerback.persistance.equipment.Equipment;
import ee.valiit.trailerback.persistance.trail.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrailEquipmentRepository extends JpaRepository<TrailEquipment, Integer> {
    @Transactional
    @Modifying
    @Query("delete from TrailEquipment t where t.trail = ?1")
    int deleteByTrail(Trail trail);

    @Transactional
    @Modifying
    @Query("delete from TrailEquipment t where t.trail = ?1 and t.equipment = ?2")
    int deleteByTrailAndEquipment(Trail trail, Equipment equipment);

    @Query("select t from TrailEquipment t where t.trail.id = ?1")
    List<TrailEquipment> findByTrailId(Integer id);

}