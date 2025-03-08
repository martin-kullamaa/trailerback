package ee.valiit.trailerback.persistance.trailtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrailTypeRepository extends JpaRepository<TrailType, Integer> {
    @Query("select t from TrailType t where t.trail.id = ?1")
    List<TrailType> findByTrailId(Integer id);
}