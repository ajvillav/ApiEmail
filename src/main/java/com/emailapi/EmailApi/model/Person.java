package com.emailapi.EmailApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID personId;

    private int identificationNumber;

    private String personName;

    private String personLastName;

    private String residenceCity;

}
