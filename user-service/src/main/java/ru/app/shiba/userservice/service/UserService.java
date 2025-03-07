package ru.app.shiba.userservice.service;

import general.kafka.dto.UserDTO;

public interface UserService {

    void updateUser(UserDTO user);
}
