package ru.app.shiba.authservice.service;

import general.kafka.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.app.shiba.authservice.dto.LoginDTO;
import ru.app.shiba.authservice.entity.UserEntity;
import ru.app.shiba.authservice.mapper.UserMapper;
import ru.app.shiba.authservice.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository
            , UserMapper userMapper, KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void registerUser(UserDTO user) {
        log.info("Attempt to register user: {}", user.getUsername());

        if (userRepository.existsByUsername(user.getUsername())) {
            return;
        }

        UserEntity userEntity = userMapper.toUserEntity(user);
        userRepository.save(userEntity);
        log.info("Registered user: {}", user.getUsername());

        kafkaTemplate.send("user-topic", user);
    }

    @Override
    public UserDTO loginUser(LoginDTO request) {
        UserDTO user = userMapper.toUserDTO(userRepository.findByUsername(request.getUsername()));

        return user != null && user.getPassword().equals(request.getPassword()) ? user : null;
    }

    @KafkaListener(topics = "update-user-topic", groupId = "user-update-group")
    public void updateUser(@Payload UserDTO user) {
        log.info("Attempt to update user from message: {}", user.getUsername());
        userRepository.deleteById(user.getUsername());
        userRepository.save(userMapper.toUserEntity(user));
    }


}
