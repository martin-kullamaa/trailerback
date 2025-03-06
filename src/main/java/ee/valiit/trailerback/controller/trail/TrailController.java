package ee.valiit.trailerback.controller.trail;

import ee.valiit.trailerback.service.TrailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrailController {

    private final TrailService trailService;

    @PostMapping("/trail")
    @Operation(summary = "Lisab matkaraja ja tagastad traiId")
    public Integer addTrailWithLocations(@RequestBody NewTrailDto newTrailDto) {
       return trailService.addTrailWithLocations(newTrailDto);
    }


}
