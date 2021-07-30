package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.dto.request.EmailUserPersonRequestDto;
import com.emailapi.EmailApi.dto.response.EmailUserPersonDataResponseDto;
import com.emailapi.EmailApi.dto.response.EmailUserResponseDto;
import com.emailapi.EmailApi.dto.response.PersonResponseDto;
import com.emailapi.EmailApi.exceptions.NotFoundException;
import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.service.EmailUserService;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/EmailUserPersonController")
public class EmailUserPersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private EmailUserService emailUserService;

    @Autowired
    NotFoundException notFoundException;

    @PostMapping(value = "/createEmailUserPerson")
    public ResponseEntity<?> createEmailUserPerson(@RequestBody EmailUserPersonRequestDto emailUserPersonRequestDto) {
        Person existPerson = personService.findFirstByIdentificationNumber(emailUserPersonRequestDto.getIdentificationNumber());
        if (existPerson == null) {
            Person personToSave = Person.builder()
                    .personName(emailUserPersonRequestDto.getPersonName())
                    .personLastName(emailUserPersonRequestDto.getPersonLastName())
                    .residenceCity(emailUserPersonRequestDto.getResidenceCity())
                    .identificationNumber(emailUserPersonRequestDto.getIdentificationNumber()).build();

            Person personResponse = personService.createPerson(personToSave);

            EmailUser emailUserToSave = EmailUser.builder()
                    .userEmail(emailUserPersonRequestDto.getUserEmail())
                    .userPassword(emailUserPersonRequestDto.getUserPassword())
                    .personId(personResponse).build();

            EmailUser emailUserResponse = emailUserService.createEmailUser(emailUserToSave);

            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto(personResponse, emailUserResponse));

        } else {
            return notFoundException.Exception("This person already exist.");
        }
    }


    private EmailUserPersonDataResponseDto responseDto(Person personResponse, EmailUser emailUserResponse) {
        PersonResponseDto personResponseDto = PersonResponseDto.builder().personId(personResponse.getPersonId())
                .personLastName(personResponse.getPersonLastName())
                .residenceCity(personResponse.getResidenceCity())
                .identificationNumber(personResponse.getIdentificationNumber())
                .personName(personResponse.getPersonName()).build();

        EmailUserResponseDto emailUserResponseDto = EmailUserResponseDto.builder().userId(emailUserResponse.getUserId())
                .userEmail(emailUserResponse.getUserEmail())
                .userPassword(emailUserResponse.getUserPassword())
                .build();

        return EmailUserPersonDataResponseDto.builder().person(personResponseDto)
                .userEmail(emailUserResponseDto).build();

    }

}

