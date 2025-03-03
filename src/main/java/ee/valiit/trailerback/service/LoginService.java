package ee.valiit.trailerback.service;

import ee.valiit.trailerback.infrastructure.Error;
import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;
import ee.valiit.trailerback.persistance.profile.Profile;


import ee.valiit.trailerback.persistance.profile.ProfileRepository;
import ee.valiit.trailerback.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.valiit.trailerback.infrastructure.Error.INCORRECT_CREDENTIALS;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ProfileRepository profileRepository;

    public void login(String username, String password) {

        Profile profile = profileRepository.findUserBy(username, password)
                .orElseThrow(() -> new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));

        // todo: verify user status, throw forbidden exception if status is invalid
        if (Status.ACTIVE.getCode().equals(profile.getStatus())) {

        }

        // todo: create and return LoginResponseDto : userId roleId

    }
}
