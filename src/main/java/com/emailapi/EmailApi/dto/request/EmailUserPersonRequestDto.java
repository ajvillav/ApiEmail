package com.emailapi.EmailApi.dto.request;

import lombok.Data;

@Data
public class EmailUserPersonRequestDto {

    private int identificationNumber;
    private String personName;
    private String personLastName;
    private String residenceCity;
    private String userEmail;
    private String userPassword;

}
