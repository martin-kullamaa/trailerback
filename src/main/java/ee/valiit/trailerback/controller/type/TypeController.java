package ee.valiit.trailerback.controller.type;

import ee.valiit.trailerback.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/type")
    public List<TypeDto> getAllTypes(){
        return typeService.getAllTypes();
    }

}
