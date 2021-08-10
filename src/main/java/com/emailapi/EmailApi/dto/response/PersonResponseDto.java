package com.emailapi.EmailApi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PersonResponseDto {

    private UUID personId;
    private int identificationNumber;
    private String personName;
    private String personLastName;
    private String residenceCity;
}
