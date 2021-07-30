package com.emailapi.EmailApi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmailUserResponseDto {

    private UUID userId;

    private String userEmail;

    private String userPassword;
}
