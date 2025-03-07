package ru.app.shiba.authservice.service;


import general.kafka.dto.UserDTO;
import ru.app.shiba.authservice.dto.LoginDTO;

public interface UserService {

    void registerUser(UserDTO user);

    UserDTO loginUser(LoginDTO user);

}
