package com.emailapi.EmailApi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmailUserRequestDto {

    @NotNull(message = "Email is necessary.")
    private String userEmail;

    @NotNull(message = "Password is necessary.")
    private String userPassword;
}
