package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Roomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String secondName;

    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String firstName;

    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String surname;

    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String dateOfBirth;

    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String numberOfPassport;

    @NotNull(message = "{NotNull.Roomer}")
    private int passportIssuedBy;

    @NotNull(message = "{NotEmpty.Roomer}")
    private String phoneNumber;

    @NotEmpty(message = "{NotEmpty.Roomer}")
    private String placeOfArrival;

    @NotNull(message = "{NotNull.Roomer}")
    private int roomNumber;

    @Temporal(TemporalType.DATE)
    private Date settlementDate;

    @Temporal(TemporalType.DATE)
    private Date moveOutDate;
}
