package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.LocationStartDto;
import ee.valiit.trailerback.persistance.locationstart.LocationStart;
import ee.valiit.trailerback.persistance.locationstart.LocationStartMapper;
import ee.valiit.trailerback.persistance.locationstart.LocationStartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationStartRepository locationStartRepository;
    private final LocationStartMapper locationStartMapper;

    public List<LocationStartDto> findLocationStarts() {
        List<LocationStart> locationStarts = locationStartRepository.findAll();
        return locationStartMapper.locationStartToDtos(locationStarts);
    }
}
