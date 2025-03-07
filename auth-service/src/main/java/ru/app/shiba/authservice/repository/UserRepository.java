package ru.app.shiba.authservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.app.shiba.authservice.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String > {

    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);

}
