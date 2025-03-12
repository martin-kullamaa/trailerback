package ee.valiit.trailerback.persistance.locationstart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationStartRepository extends JpaRepository<LocationStart, Integer> {


    @Override
    Optional<LocationStart> findById(Integer integer);
}