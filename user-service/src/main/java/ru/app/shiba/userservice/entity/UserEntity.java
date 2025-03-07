package ru.app.shiba.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "`user`")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;



}
