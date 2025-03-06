package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.trailcontroller.NewTrailDto;
import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import ee.valiit.trailerback.persistance.locationstart.LocationStartMapper;
import ee.valiit.trailerback.persistance.locationstart.LocationStartRepository;
import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.trail.TrailMapper;
import ee.valiit.trailerback.persistance.trail.TrailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrailService {

    private final LocationStartMapper locationStartMapper;
    private final LocationStartRepository locationStartRepository;
    private final TrailMapper trailMapper;
    private final TrailRepository trailRepository;

    public void addTrailWithLocations(NewTrailDto newTrailDto) {
        // LocationStart tabeli rea loomine ja salvestamine
        LocationStart locationStart = locationStartMapper.newTrailDtoToLocationStart(newTrailDto);
        locationStartRepository.save(locationStart);
        // Trail tabeli rea loomine ja salvestamine
        Trail trail = trailMapper.newTrailDtoToTrail(newTrailDto);
        trail.setLocationStart(locationStart);
        trailRepository.save(trail);
        // LocationStop tabeli ridade loomine ja salvestamine
        


        // todo: set profile (foreign key)
    }
}
