package ee.valiit.trailerback.controller.register;

import ee.valiit.trailerback.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    public void addNewProfile(@RequestBody NewProfileDto newProfileDto){
        profileService.addNewProfile(newProfileDto);
    }

}
