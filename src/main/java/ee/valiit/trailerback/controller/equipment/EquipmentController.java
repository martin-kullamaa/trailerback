package ee.valiit.trailerback.controller.equipment;

import ee.valiit.trailerback.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping("/equipment")
    public void addEquipment(@RequestParam String equipmentName){
        equipmentService.addEquipment(equipmentName);
    }

    @GetMapping("/equipment")
    public List<EquipmentDto> getAllEquipment(){
        return equipmentService.getAllEquipment();
    }

}
