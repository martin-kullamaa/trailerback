package ee.valiit.trailerback.service;

import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;
import ee.valiit.trailerback.infrastructure.exception.ForbiddenException;
import ee.valiit.trailerback.controller.LoginResponseDto;
import ee.valiit.trailerback.persistance.profile.Profile;


import ee.valiit.trailerback.persistance.profile.ProfileMapper;
import ee.valiit.trailerback.persistance.profile.ProfileRepository;
import ee.valiit.trailerback.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ee.valiit.trailerback.infrastructure.Error.ACCOUNT_DEACTIVATED;
import static ee.valiit.trailerback.infrastructure.Error.INCORRECT_CREDENTIALS;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public LoginResponseDto login(String username, String password) {
        System.out.println("olen siin");
        Profile profile = profileRepository.findUserBy(username, password)
                .orElseThrow(() -> new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));


        if (Status.ACTIVE.getCode().equals(profile.getStatus())) {
            return profileMapper.toLoginResponseDto(profile);
        } else {
            throw new ForbiddenException(ACCOUNT_DEACTIVATED.getMessage(), ACCOUNT_DEACTIVATED.getErrorCode());
        }

    }
}
