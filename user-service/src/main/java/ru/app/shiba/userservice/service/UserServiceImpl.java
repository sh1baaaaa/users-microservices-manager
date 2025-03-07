package ru.app.shiba.userservice.service;

import general.kafka.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.app.shiba.userservice.exception.EntityProcessingException;
import ru.app.shiba.userservice.mapper.UserMapper;
import ru.app.shiba.userservice.repository.UserRepository;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper
            , KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "user-topic", groupId = "user-save-group")
    public void saveUser(@Payload UserDTO user) {
        log.info("Attempt to save user: {}", user.getUsername());
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public void updateUser(UserDTO user) {
        log.info("Attempt to update user: {}", user.getUsername());

        if (!userRepository.existsById(user.getId())) {
            log.error("User {} not found", user.getId());
            throw new EntityProcessingException("User " + user.getId() + " not found");
        }

        userRepository.save(userMapper.toEntity(user));
        kafkaTemplate.send("update-user-topic", user);
    }
}
