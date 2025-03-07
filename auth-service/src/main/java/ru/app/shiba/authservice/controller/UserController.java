package ru.app.shiba.authservice.controller;

import general.kafka.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.shiba.authservice.dto.LoginDTO;
import ru.app.shiba.authservice.dto.ResponseMessageDTO;
import ru.app.shiba.authservice.service.UserService;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseMessageDTO> register(@RequestBody UserDTO user) {
        userService.registerUser(user);
        return new ResponseEntity<>(ResponseMessageDTO.builder()
                .message("User successfully registered")
                .success(true)
                .build()
                ,  HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessageDTO> login(@RequestBody LoginDTO loginDTO) {
        userService.loginUser(loginDTO);
        return new ResponseEntity<>(ResponseMessageDTO.builder()
                .message("User successfully logged in")
                .success(true)
                .build()
                , HttpStatus.OK);
    }

}
