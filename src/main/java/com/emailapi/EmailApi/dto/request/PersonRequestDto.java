package com.emailapi.EmailApi.dto.request;

import lombok.Data;

@Data
public class PersonRequestDto {

    private int identificationNumber;
    private String personName;
    private String personLastName;
    private String residenceCity;
}
