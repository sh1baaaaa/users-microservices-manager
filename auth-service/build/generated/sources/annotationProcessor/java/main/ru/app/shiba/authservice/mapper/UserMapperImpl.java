package ru.app.shiba.authservice.mapper;

import general.kafka.dto.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.app.shiba.authservice.entity.UserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T22:40:16+1000",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setAge( userDTO.getAge() );
        userEntity.setCity( userDTO.getCity() );
        userEntity.setCountry( userDTO.getCountry() );

        return userEntity;
    }

    @Override
    public UserDTO toUserDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( userEntity.getUsername() );
        userDTO.password( userEntity.getPassword() );
        userDTO.age( userEntity.getAge() );
        userDTO.city( userEntity.getCity() );
        userDTO.country( userEntity.getCountry() );

        return userDTO.build();
    }
}
