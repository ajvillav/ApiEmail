package com.emailapi.EmailApi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailUserPersonDataResponseDto {

    EmailUserResponseDto emailUserResponseDto;
    PersonResponseDto personResponseDto;

}
