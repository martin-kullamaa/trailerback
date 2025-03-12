package ee.valiit.trailerback.controller.trail;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
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
    @Operation(summary = "Gets trail, location_start, location_stop in a single DTO")
    public TrailDto getTrailWithLocations(@RequestParam Integer startId){
        return trailService.getTrailWithLocations(startId);
    }

    @GetMapping("/trail/type")
    @Operation(summary = "Gets all trail_types")
    public List<TypeDto> getTrailType(@RequestParam Integer trailId){
        return trailService.getTrailType(trailId);
    }

    @PostMapping("/trail/type")
    @Operation(summary = "Adds new trail_type")
    public void addTrailType(@RequestParam Integer trailId, @RequestParam Integer typeId){
        trailService.addTrailType(trailId, typeId);
    }

    @DeleteMapping("/trail/type")
    @Operation(summary = "Deletes trailType row")
    public void deleteTrailType(@RequestParam Integer trailId, @RequestParam Integer typeId){
        trailService.deleteTrailType(trailId, typeId);
    }

    @GetMapping("/trail/equipment")
    @Operation(summary = "Gets trail types for trailId")
    public List<EquipmentDto> getTrailEquipment(@RequestParam Integer trailId){
        return trailService.getTrailEquipment(trailId);
    }

    @PostMapping("/trail/equipment")
    @Operation(summary = "Adds new trail_equipment")
    public void addTrailEquipment(@RequestParam Integer trailId, @RequestParam Integer equipmentId){
        trailService.addTrailEquipment(trailId, equipmentId);
    }

    @DeleteMapping("/trail/equipment")
    @Operation(summary = "Deletes trail_equipment row")
    public void deleteTrailEquipment(@RequestParam Integer trailId, @RequestParam Integer equipmentId){
        trailService.deleteTrailEquipment(trailId, equipmentId);
    }
}
