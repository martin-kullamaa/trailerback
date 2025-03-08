package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
import ee.valiit.trailerback.controller.equipment.NewEquipmentDto;
import ee.valiit.trailerback.persistance.equipment.Equipment;
import ee.valiit.trailerback.persistance.equipment.EquipmentMapper;
import ee.valiit.trailerback.persistance.equipment.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public List<EquipmentDto> getAllEquipment() {
        List<Equipment> allEquipment = equipmentRepository.findAll();
        return equipmentMapper.equipmentToEquipmentDtos(allEquipment);
    }

    public void addEquipment(String equipmentName) {
        NewEquipmentDto newEquipmentDto = new NewEquipmentDto();
        newEquipmentDto.setName(equipmentName);
        Equipment equipment = equipmentMapper.equipmentDtoToEquipment(newEquipmentDto);
        equipmentRepository.save(equipment);
    }
}
