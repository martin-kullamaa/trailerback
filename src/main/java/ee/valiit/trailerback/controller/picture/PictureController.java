package ee.valiit.trailerback.controller.picture;

import ee.valiit.trailerback.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @PostMapping("/picture")
    public void addTrailPicture(@RequestParam Integer trailId, @RequestBody TrailPictureDto trailPictureDto){
        pictureService.addTrailPicture(trailId, trailPictureDto);
    }

    @GetMapping("/picture")
    public List<TrailPictureDto> getTrailPictures(@RequestParam Integer trailId){
        return pictureService.getTrailPictures(trailId);
    }

    @DeleteMapping("/picture")
    public void deleteTrailPicture(@RequestParam Integer pictureId){
        pictureService.deleteTrailPicture(pictureId);
    }

}
