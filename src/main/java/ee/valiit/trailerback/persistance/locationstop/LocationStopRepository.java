package ee.valiit.trailerback.persistance.locationstop;

import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationStopRepository extends JpaRepository<LocationStop, Integer> {
    @Query("select l from LocationStop l where l.location.id = ?1")
    List<LocationStop> findByLocationId(Integer id);

    Integer location(@NotNull LocationStart location);

    @Transactional
    @Modifying
    @Query("delete from LocationStop l where l.location = ?1")
    void deleteByLocationStart(LocationStart location);


}