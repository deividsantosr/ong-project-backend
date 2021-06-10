package com.nogs.ongprojectbackend.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private String id;
    private String name;
    private String description;
    private String image;
}
