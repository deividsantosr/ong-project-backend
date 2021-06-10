package com.nogs.ongprojectbackend.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;
    private String email;
    private String password;
    private String name;
    private String image;
    private int age;
    private String city;
}