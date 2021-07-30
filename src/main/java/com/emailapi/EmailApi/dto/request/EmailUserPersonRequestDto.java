package com.emailapi.EmailApi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmailUserPersonRequestDto {

    @NotNull(message = "Identification number is necessary.")
    private int identificationNumber;

    @NotNull(message = "Person's name is necessary.")
    private String personName;

    @NotNull(message = "Person's last name is necessary.")
    private String personLastName;

    @NotNull(message = "Residence city is necessary.")
    private String residenceCity;

    @NotNull(message = "Email is necessary.")
    private String userEmail;

    @NotNull(message = "Password is necessary.")
    private String userPassword;

}
