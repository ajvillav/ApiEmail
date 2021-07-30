package com.emailapi.EmailApi.dto.request;

import lombok.Data;


@Data
public class EmailUserRequestDto {

    private String userEmail;
    private String userPassword;
}
