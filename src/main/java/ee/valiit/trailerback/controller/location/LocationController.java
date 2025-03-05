package ee.valiit.trailerback.controller.location;

import ee.valiit.trailerback.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/home")
    public List<LocationStartDto> findLocationStarts() {
        return locationService.findLocationStarts();
    }

}
