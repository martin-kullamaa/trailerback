package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.location.LocationStopDto;
import ee.valiit.trailerback.controller.trail.NewTrailDto;
import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;
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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static ee.valiit.trailerback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

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

    @Transactional
    public Integer addTrailWithLocations(NewTrailDto newTrailDto) {

        // LocationStart tabeli rea loomine ja salvestamine
        LocationStart locationStart = locationStartMapper.newTrailDtoToLocationStart(newTrailDto);
        locationStartRepository.save(locationStart);
        // todo: delete later
        System.out.println("Saved LocationStart ID: " + locationStart.getId());

        // Trail tabeli rea loomine ja salvestamine
        Trail trail = trailMapper.newTrailDtoToTrail(newTrailDto);
        Profile profile = profileRepository.findById(newTrailDto.getProfileId())
                .orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        trail.setProfile(profile);
        trail.setLocationStart(locationStart);
        trailRepository.save(trail);

        // LocationStop tabeli ridade loomine ja salvestamine
        List<LocationStopDto> locationStopDtos = newTrailDto.getLocationStopDtos();
        for (LocationStopDto locationStopDto : locationStopDtos) {
            LocationStop locationStop = locationStopMapper.locationStopDtoToLocationStop(locationStopDto);
            locationStop.setLocation(locationStart);
            locationStopRepository.save(locationStop);
        }

        return trail.getId();
    }
}
