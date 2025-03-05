package ee.valiit.trailerback.controller.trailcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrailController {

    @PostMapping("/newtrail")
    public void addTrailWithLocations(@RequestBody NewTrailDto newTrailDto) {

    }

}
