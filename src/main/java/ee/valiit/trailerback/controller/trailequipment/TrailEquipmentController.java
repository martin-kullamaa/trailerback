package ee.valiit.trailerback.controller.trailequipment;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
import ee.valiit.trailerback.service.TrailEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrailEquipmentController {

    private final TrailEquipmentService trailEquipmentService;

    @GetMapping("/trailequipment")
    public List<EquipmentDto> getTrailEquipmentBy(@RequestParam Integer trailId){
        return trailEquipmentService.getTrailEquipmentBy(trailId);
    }

}
