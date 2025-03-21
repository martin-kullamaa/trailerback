package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.location.LocationStartDto;
import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import ee.valiit.trailerback.persistance.locationstart.LocationStartMapper;
import ee.valiit.trailerback.persistance.locationstart.LocationStartRepository;
import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.trail.TrailRepository;
import ee.valiit.trailerback.persistance.trailtype.TrailType;
import ee.valiit.trailerback.persistance.trailtype.TrailTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationStartRepository locationStartRepository;
    private final LocationStartMapper locationStartMapper;
    private final TrailTypeRepository trailTypeRepository;
    private final TrailRepository trailRepository;

    public List<LocationStartDto> findLocationStarts() {
        List<LocationStart> locationStarts = locationStartRepository.findAll();
        return locationStartMapper.locationStartToDtos(locationStarts);
    }

    public List<LocationStartDto> filterLocationStartByType(Integer typeId) {
        List<TrailType> trailTypes = trailTypeRepository.findByTypeId(typeId);

        List<LocationStart> locationStarts = new ArrayList<>();

        for (TrailType trailType : trailTypes) {
            Trail trail = trailType.getTrail();
            LocationStart locationStart = trail.getLocationStart();
            locationStarts.add(locationStart);
        }

        return locationStartMapper.locationStartToDtos(locationStarts);
    }

    public Integer getLocationStart(Integer trailId) {
        Trail trail = trailRepository.getReferenceById(trailId);
        LocationStart locationStart = trail.getLocationStart();
        return locationStart.getId();
    }
}


