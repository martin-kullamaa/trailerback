package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.register.NewProfileDto;
import ee.valiit.trailerback.persistance.profile.Profile;
import ee.valiit.trailerback.persistance.profile.ProfileMapper;
import ee.valiit.trailerback.persistance.profile.ProfileRepository;
import ee.valiit.trailerback.persistance.role.Role;
import ee.valiit.trailerback.persistance.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    public static final int ROLE_USER = 2;
    private final ProfileRepository profileRepository;
    private final RoleRepository roleRepository;
    private final ProfileMapper profileMapper;

    public void addNewProfile(NewProfileDto newProfileDto) {
        Role role = roleRepository.getReferenceById(ROLE_USER);
        Profile profile = profileMapper.toProfile(newProfileDto);
        profile.setRole(role);
        profileRepository.save(profile);



    }
}
