package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.picture.TrailPictureDto;
import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;
import ee.valiit.trailerback.persistance.trail.Trail;
import ee.valiit.trailerback.persistance.trail.TrailRepository;
import ee.valiit.trailerback.persistance.trailpicture.TrailPicture;
import ee.valiit.trailerback.persistance.trailpicture.TrailPictureMapper;
import ee.valiit.trailerback.persistance.trailpicture.TrailPictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.valiit.trailerback.infrastructure.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.trailerback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final TrailPictureMapper trailPictureMapper;
    public final TrailPictureRepository trailPictureRepository;
    public final TrailRepository trailRepository;

    public void addTrailPicture(Integer trailId, TrailPictureDto trailPictureDto) {

        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));
        TrailPicture trailPicture = trailPictureMapper.trailPictureDtoToTrailPicture(trailPictureDto);
        //add trailId
        trailPicture.setTrail(trail);
        //save
        trailPictureRepository.save(trailPicture);
    }

    public List<TrailPictureDto> getTrailPictures(Integer trailId) {
        List<TrailPicture> trailPictures = trailPictureRepository.findTrailPictureBy(trailId);
        return trailPictureMapper.trailPictureToTrailPictureDtos(trailPictures);
    }

    public void deleteTrailPicture(Integer trailId, String pictureName) {
        Trail trail = trailRepository.getReferenceById(trailId);
        trailPictureRepository.deleteByTrailAndPictureName(trail, pictureName);
    }
}
