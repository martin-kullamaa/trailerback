package ee.valiit.trailerback.persistance.profile;

import ee.valiit.trailerback.controller.LoginResponseDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface ProfileMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponseDto toLoginResponseDto(Profile profile);

}