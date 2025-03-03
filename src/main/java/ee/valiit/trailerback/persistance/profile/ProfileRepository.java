package ee.valiit.trailerback.persistance.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query("select p from Profile p where p.username = ?1 and p.password = ?2")
    Optional<Profile> findUserBy(String username, String password);

}