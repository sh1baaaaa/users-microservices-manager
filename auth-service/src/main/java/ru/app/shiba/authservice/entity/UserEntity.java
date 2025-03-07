package ru.app.shiba.authservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash(value = "user", timeToLive = 36000L)
public class UserEntity implements Serializable {

    @Id
    private String username;

    private String password;

    private Integer age;

    private String city;

    private String country;

}
