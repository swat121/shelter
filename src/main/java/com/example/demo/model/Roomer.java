package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "{NotNull.Roomer}")
    private String passportIssuedBy;

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

    private String descriptions;
}
