package com.example.animals.model;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String type;
    private String size;
    private Long age;
    private String owner;
    private String email;
}
