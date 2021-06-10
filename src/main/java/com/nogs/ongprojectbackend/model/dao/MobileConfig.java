package com.nogs.ongprojectbackend.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileConfig implements Serializable {
    private String id;
    private String title;
    private String description;
    private String image;
    private String info;
}
