package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Roomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{NotEmpty.Roomer}")
    private String secondName;

    @NotBlank(message = "{NotEmpty.Roomer}")
    private String firstName;

    @NotBlank(message = "{NotEmpty.Roomer}")
    private String surname;

    @NotBlank(message = "{NotEmpty.Roomer}")
    private String dateOfBirth;

    @NotBlank(message = "{NotEmpty.Roomer}")
    private String numberOfPassport;

    @NotNull(message = "{NotNull.Roomer}")
    private Integer passportIssuedBy;

    @NotNull(message = "{NotEmpty.Roomer}")
    private String phoneNumber;

    @NotBlank(message = "{NotEmpty.Roomer}")
    private String placeOfArrival;

    @NotNull(message = "{NotNull.Roomer}")
    private Integer roomNumber;

    @Temporal(TemporalType.DATE)
    private Date settlementDate;

    @Temporal(TemporalType.DATE)
    private Date moveOutDate;
}
