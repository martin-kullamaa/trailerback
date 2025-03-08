package ee.valiit.trailerback.controller.trail;

import ee.valiit.trailerback.controller.type.TypeDto;
import ee.valiit.trailerback.service.TrailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrailController {

    private final TrailService trailService;

    @PostMapping("/trail")
    @Operation(summary = "Adds new trail, location_start, location_stop, returns trailId")
    public Integer addTrailWithLocations(@RequestBody NewTrailDto newTrailDto) {
       return trailService.addTrailWithLocations(newTrailDto);
    }

    @GetMapping("/trail")
    @Operation(summary = "Gets all trail_types")
    public List<TypeDto> getTrailType(@RequestParam Integer trailId){
        return trailService.getTrailType(trailId);
    }

    @PostMapping("/trail")
    @Operation(summary = "Adds new trail_type")
    public void addTrailType(@RequestParam Integer trailId, @RequestParam Integer typeId){
        trailService.addTrailType(trailId, typeId);
    }
}
