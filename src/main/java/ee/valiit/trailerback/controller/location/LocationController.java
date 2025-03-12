package ee.valiit.trailerback.controller.location;

import ee.valiit.trailerback.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/location/type")
    @Operation(summary = "Gets locations starts by type")
    public List<LocationStartDto> filterLocationStartByType(@RequestParam Integer typeId) {
        return locationService.filterLocationStartByType(typeId);
    }

}
