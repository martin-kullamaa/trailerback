package ee.valiit.trailerback.controller.trailcontroller;

import ee.valiit.trailerback.service.TrailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrailController {

    private final TrailService trailService;

    @PostMapping("/newtrail")
    public void addTrailWithLocations(@RequestBody NewTrailDto newTrailDto) {
        trailService.addTrailWithLocations(newTrailDto);
    }

}
