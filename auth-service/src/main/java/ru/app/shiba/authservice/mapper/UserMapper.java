package ru.app.shiba.authservice.mapper;

import general.kafka.dto.UserDTO;
import org.mapstruct.Mapper;
import ru.app.shiba.authservice.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(UserDTO userDTO);

    UserDTO toUserDTO(UserEntity userEntity);

}
