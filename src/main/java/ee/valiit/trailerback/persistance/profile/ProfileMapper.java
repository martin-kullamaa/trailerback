package ee.valiit.trailerback.persistance.profile;

import ee.valiit.trailerback.controller.login.LoginResponseDto;
import ee.valiit.trailerback.controller.register.NewProfileDto;
import ee.valiit.trailerback.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface ProfileMapper {

    @Mapping(source = "id", target = "profileId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponseDto toLoginResponseDto(Profile profile);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    Profile toProfile(NewProfileDto newProfileDto);

}
