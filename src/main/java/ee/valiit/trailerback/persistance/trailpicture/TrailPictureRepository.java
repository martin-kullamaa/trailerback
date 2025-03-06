package ee.valiit.trailerback.persistance.trailpicture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrailPictureRepository extends JpaRepository<TrailPicture, Integer> {

    @Query("select t from TrailPicture t where t.trail.id = ?1")
    List<TrailPicture> findTrailPictureBy(Integer id);

}