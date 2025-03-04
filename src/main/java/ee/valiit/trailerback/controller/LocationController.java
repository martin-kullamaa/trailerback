package ee.valiit.trailerback.controller;

import ee.valiit.trailerback.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/")
    public List<LocationStartDto> findLocationStarts() {
        return locationService.findLocationStarts();
    }

}
