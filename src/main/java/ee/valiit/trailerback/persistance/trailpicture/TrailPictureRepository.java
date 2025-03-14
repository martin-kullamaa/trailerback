package ee.valiit.trailerback.persistance.trailpicture;

import ee.valiit.trailerback.persistance.trail.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrailPictureRepository extends JpaRepository<TrailPicture, Integer> {

    @Query("select t from TrailPicture t where t.trail.id = ?1")
    List<TrailPicture> findTrailPictureBy(Integer id);

    @Transactional
    @Modifying
    @Query("delete from TrailPicture t where t.trail = ?1 and t.name = ?2")
    int deleteByTrailAndPictureName(Trail trail, String name);

    @Transactional
    @Modifying
    @Query("delete from TrailPicture t where t.trail = ?1")
    int deleteByTrail(Trail trail);


}