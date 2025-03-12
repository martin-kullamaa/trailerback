package ee.valiit.trailerback.persistance.trailtype;

import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrailTypeRepository extends JpaRepository<TrailType, Integer> {
    @Query("select t from TrailType t where t.trail.id = ?1")
    List<TrailType> findByTrailId(Integer id);

    @Transactional
    @Modifying
    @Query("delete from TrailType t where t.trail = ?1 and t.type = ?2")
    int deleteByTrailAndType(Trail trail, Type type);

    @Query("select t from TrailType t where t.type.id = ?1")
    List<TrailType> findByTypeId(Integer id);


}