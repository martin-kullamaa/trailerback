package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
import ee.valiit.trailerback.persistance.equipment.Equipment;
import ee.valiit.trailerback.persistance.equipment.EquipmentMapper;
import ee.valiit.trailerback.persistance.trailequipment.TrailEquipment;
import ee.valiit.trailerback.persistance.trailequipment.TrailEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrailEquipmentService {

    private final TrailEquipmentRepository trailEquipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public List<EquipmentDto> getTrailEquipmentBy(Integer trailId) {
        List<TrailEquipment> trailEquipments = trailEquipmentRepository.findByTrailId(trailId);
        List<EquipmentDto> equipmentDtos = new ArrayList<>();
        for (TrailEquipment trailEquipment : trailEquipments){
            Equipment equipment = trailEquipment.getEquipment();
            EquipmentDto equipmentDto = equipmentMapper.equipmentToEquipmentDto(equipment);
            equipmentDtos.add(equipmentDto);
        }
        return equipmentDtos;
    }
}
