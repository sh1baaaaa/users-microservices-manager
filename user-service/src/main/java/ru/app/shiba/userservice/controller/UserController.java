package ru.app.shiba.userservice.controller;

import general.kafka.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.shiba.userservice.dto.ResponseMessage;
import ru.app.shiba.userservice.service.UserService;


@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseMessage> update(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(ResponseMessage.builder()
                .success(true)
                .message("User successfully updated")
                .build()
                , HttpStatus.OK);
    }

}
