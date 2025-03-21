package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.equipment.EquipmentDto;
import ee.valiit.trailerback.controller.location.LocationStopDto;
import ee.valiit.trailerback.controller.trail.NewTrailDto;
import ee.valiit.trailerback.controller.trail.TrailDto;
import ee.valiit.trailerback.controller.type.TypeDto;
import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;
import ee.valiit.trailerback.persistance.equipment.Equipment;
import ee.valiit.trailerback.persistance.equipment.EquipmentMapper;
import ee.valiit.trailerback.persistance.equipment.EquipmentRepository;
import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import ee.valiit.trailerback.persistance.locationstart.LocationStartMapper;
import ee.valiit.trailerback.persistance.locationstart.LocationStartRepository;
import ee.valiit.trailerback.persistance.locationstop.LocationStop;
import ee.valiit.trailerback.persistance.locationstop.LocationStopMapper;
import ee.valiit.trailerback.persistance.locationstop.LocationStopRepository;
import ee.valiit.trailerback.persistance.profile.Profile;
import ee.valiit.trailerback.persistance.profile.ProfileRepository;
import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.trail.TrailMapper;
import ee.valiit.trailerback.persistance.trail.TrailRepository;
import ee.valiit.trailerback.persistance.trailequipment.TrailEquipment;
import ee.valiit.trailerback.persistance.trailequipment.TrailEquipmentRepository;
import ee.valiit.trailerback.persistance.trailpicture.TrailPictureRepository;
import ee.valiit.trailerback.persistance.trailtype.TrailType;
import ee.valiit.trailerback.persistance.trailtype.TrailTypeRepository;
import ee.valiit.trailerback.persistance.type.Type;
import ee.valiit.trailerback.persistance.type.TypeMapper;
import ee.valiit.trailerback.persistance.type.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static ee.valiit.trailerback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;
import static ee.valiit.trailerback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TrailService {

    private final LocationStartMapper locationStartMapper;
    private final LocationStartRepository locationStartRepository;
    private final TrailMapper trailMapper;
    private final TrailRepository trailRepository;
    private final ProfileRepository profileRepository;
    private final LocationStopMapper locationStopMapper;
    private final LocationStopRepository locationStopRepository;
    private final TrailTypeRepository trailTypeRepository;
    private final TypeMapper typeMapper;
    private final TypeRepository typeRepository;
    private final TrailEquipmentRepository trailEquipmentRepository;
    private final EquipmentMapper equipmentMapper;
    private final EquipmentRepository equipmentRepository;
    private final TrailPictureRepository trailPictureRepository;

    @Transactional
    public Integer addTrailWithLocations(NewTrailDto newTrailDto) {

        // LocationStart table row mapping and saving
        LocationStart locationStart = locationStartMapper.newTrailDtoToLocationStart(newTrailDto);
        locationStartRepository.save(locationStart);

        // Trail table row creating and saving
        Trail trail = trailMapper.newTrailDtoToTrail(newTrailDto);
        Profile profile = profileRepository.findById(newTrailDto.getProfileId())
                .orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        trail.setProfile(profile);
        trail.setLocationStart(locationStart);
        trailRepository.save(trail);

        // LocationStop table row creating and saving
        List<LocationStopDto> locationStopDtos = newTrailDto.getLocationStopDtos();
        for (LocationStopDto locationStopDto : locationStopDtos) {
            LocationStop locationStop = locationStopMapper.locationStopDtoToLocationStop(locationStopDto);
            locationStop.setLocation(locationStart);
            locationStopRepository.save(locationStop);
        }

        return trail.getId();
    }

    public TrailDto getTrailWithLocations(Integer locationStartId) {

        Trail trail = trailRepository.findByLocationStartId(locationStartId)
                .orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        LocationStart locationStart = locationStartRepository
                .findById(locationStartId).orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        List<LocationStop> locationStops = locationStopRepository.findByLocationId(locationStartId);

        return trailMapper.trailWithLocationsToTrailDto(trail, locationStart, locationStops);

    }

    @Transactional
    public Integer updateTrailWithLocations(TrailDto trailDto) {

        Trail trail = trailRepository.findById(trailDto.getTrailId()).orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        LocationStart locationStart = trail.getLocationStart();
        locationStartMapper.updateLocationStartFromTrailDto(trailDto, locationStart);
        locationStartRepository.save(locationStart);

        trailMapper.updateTrailFromTrailDto(trailDto, trail);
        trailRepository.save(trail);

        locationStopRepository.deleteByLocationStart(locationStart);

        List<LocationStopDto> locationStopDtos = trailDto.getLocationStopDtos();
        for (LocationStopDto locationStopDto : locationStopDtos) {
            LocationStop locationStop = locationStopMapper.locationStopDtoToLocationStop(locationStopDto);
            locationStop.setLocation(locationStart);
            locationStopRepository.save(locationStop);
        }

        return trailDto.getTrailId();
    }

    @Transactional
    public void deleteTrail(Integer startId) {
        LocationStart locationStart = locationStartRepository.getReferenceById(startId);
        List<LocationStop> locationStops = locationStopRepository.findByLocationId(startId);
        for (LocationStop locationStop : locationStops) {
            locationStopRepository.delete(locationStop);
        }
        Trail trail = trailRepository.findByLocationStartId(startId)
                .orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));

        trailTypeRepository.deleteByTrail(trail);
        trailPictureRepository.deleteByTrail(trail);
        trailEquipmentRepository.deleteByTrail(trail);
        trailRepository.delete(trail);
        locationStartRepository.delete(locationStart);
    }

    public List<TypeDto> getTrailType(Integer trailId) {
        List<TrailType> trailTypes = trailTypeRepository.findByTrailId(trailId);
        List<TypeDto> typeDtos = new ArrayList<>();
        for (TrailType trailType : trailTypes){
            Type type = trailType.getType();
            typeDtos.add(typeMapper.typeToTypeDto(type));
        }
        return typeDtos;
    }

    public void addTrailType(Integer trailId, Integer typeId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        Type type = typeRepository.findById(typeId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        TrailType trailType = new TrailType();
        trailType.setTrail(trail);
        trailType.setType(type);
        trailTypeRepository.save(trailType);
    }

    public void deleteTrailType(Integer trailId, Integer typeId) {
        Trail trail = trailRepository.getReferenceById(trailId);
        Type type = typeRepository.getReferenceById(typeId);
        trailTypeRepository.deleteByTrailAndType(trail, type);
    }

    public List<EquipmentDto> getTrailEquipment(Integer trailId) {
        List<TrailEquipment> trailEquipments = trailEquipmentRepository.findByTrailId(trailId);
        List<EquipmentDto> equipmentDtos = new ArrayList<>();
        for (TrailEquipment trailEquipment : trailEquipments){
            Equipment equipment = trailEquipment.getEquipment();
            EquipmentDto equipmentDto = equipmentMapper.equipmentToEquipmentDto(equipment);
            equipmentDtos.add(equipmentDto);
        }
        return equipmentDtos;
    }

    public void addTrailEquipment(Integer trailId, Integer equipmentId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        TrailEquipment trailEquipment = new TrailEquipment();
        trailEquipment.setTrail(trail);
        trailEquipment.setEquipment(equipment);
        trailEquipmentRepository.save(trailEquipment);
    }

    public void deleteTrailEquipment(Integer trailId, Integer equipmentId) {
        Trail trail = trailRepository.getReferenceById(trailId);
        Equipment equipment = equipmentRepository.getReferenceById(equipmentId);
        trailEquipmentRepository.deleteByTrailAndEquipment(trail, equipment);
    }

}
