package com.nogs.ongprojectbackend.model.dao;

import com.nogs.ongprojectbackend.model.enums.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation implements Serializable {
    private String id;
    private String name;
    private String ongId;
    private String ongName;
    private String userName;
    private PaymentMethodEnum paymentMethod;
    private Double value;
    private String observations;
}
