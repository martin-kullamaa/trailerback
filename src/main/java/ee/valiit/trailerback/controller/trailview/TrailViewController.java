package ee.valiit.trailerback.controller.trailview;

import ee.valiit.trailerback.service.TrailViewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TrailViewController {

    private final TrailViewService trailViewService;

    @GetMapping("/home/trail")
    @Operation(summary = "Leiab trailId järgi olemasoleva pangaautomaadi asukoha info.")
    public void findTrail(@RequestParam Integer trailId) {
        trailViewService.findTrail(trailId);

    }
}
