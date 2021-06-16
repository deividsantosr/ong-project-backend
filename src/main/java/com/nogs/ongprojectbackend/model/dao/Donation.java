package com.nogs.ongprojectbackend.model.dao;

import com.google.api.client.util.DateTime;
import com.nogs.ongprojectbackend.model.enums.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation implements Serializable {
    private String id;
    private String ongId;
    private String ongName;
    private String userId;
    private String userName;
    private PaymentMethodEnum paymentMethod;
    private Double value;
    private String observations;
    private String createdDate = new Timestamp(System.currentTimeMillis()).toString();
}
