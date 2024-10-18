package org.example.halo.infra.persistent.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
