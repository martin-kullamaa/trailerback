package ee.valiit.trailerback.persistance.trail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TrailRepository extends JpaRepository<Trail, Integer> {
    @Query("select t from Trail t where t.locationStart.id = ?1")
    Optional<Trail> findByLocationStartId(Integer id);
}