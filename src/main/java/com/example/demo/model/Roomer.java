package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Roomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secondName;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String numberOfPassport;
    private int passportIssuedBy;
    private String phoneNumber;
    private String placeOfArrival;
    private int roomNumber;
    @Temporal(TemporalType.DATE)
    private Date settlementDate;
    @Temporal(TemporalType.DATE)
    private Date moveOutDate;
}
