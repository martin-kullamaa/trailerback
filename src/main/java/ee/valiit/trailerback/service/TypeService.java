package ee.valiit.trailerback.service;

import ee.valiit.trailerback.controller.type.TypeDto;
import ee.valiit.trailerback.persistance.type.Type;
import ee.valiit.trailerback.persistance.type.TypeMapper;
import ee.valiit.trailerback.persistance.type.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public List<TypeDto> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return typeMapper.typeToTypeDtos(types);
    }
}
