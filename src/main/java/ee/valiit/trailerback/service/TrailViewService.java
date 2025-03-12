package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.trailview.TrailViewDto;
import ee.valiit.trailerback.persistance.locationstart.LocationStartRepository;
import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.trail.TrailMapper;
import ee.valiit.trailerback.persistance.trail.TrailRepository;
import ee.valiit.trailerback.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrailViewService {

    private final TrailMapper trailMapper;
    private final TrailRepository trailRepository;
    private final LocationStartRepository locationStartRepository;


    public void findTrail(Integer trailId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("trailId", trailId));
        TrailViewDto trailViewDto = trailMapper.toTrailViewDto(trail);

        locationStartRepository.findById()

        // ei saa mappida
    }
}
