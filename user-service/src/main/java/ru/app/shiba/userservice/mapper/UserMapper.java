package ru.app.shiba.userservice.mapper;

import general.kafka.dto.UserDTO;
import org.mapstruct.Mapper;
import ru.app.shiba.userservice.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);

    UserEntity toEntity(UserDTO userDTO);

}
