package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.dto.request.EmailUserRequestDto;
import com.emailapi.EmailApi.dto.response.EmailUserResponseDto;
import com.emailapi.EmailApi.exceptions.NotFoundException;
import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.service.EmailUserService;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/EmailUser")
public class EmailUserController {

    @Autowired
    private EmailUserService emailUserService;

    @Autowired
    private PersonService personService;

    @Autowired
    NotFoundException notFoundException;


    @GetMapping(value = "/getEmailUserById/{id}")
    public ResponseEntity<?> getEmailUserById(@PathVariable("id") UUID userId) {
        EmailUser getEmailUser = emailUserService.getEmailUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(emailUserResponseDto(getEmailUser));   }

    @GetMapping(value = "/getEmailUserList")
    public List<EmailUser> getEmailUserList() {
        return emailUserService.getEmailUserList();
    }

    @PutMapping(value = "/updateEmailUser/{id}")
    public ResponseEntity<?> updateEmailUser(@RequestBody EmailUserRequestDto emailUserRequestDto,
                                             @PathVariable("id") UUID userId, @RequestParam("personId") UUID personId) {
        Person person = personService.getPerson(personId);
        if(person!=null){
            EmailUser emailUserUpdate = EmailUser.builder()
                    .userEmail(emailUserRequestDto.getUserEmail())
                    .userPassword(emailUserRequestDto.getUserPassword())
                    .personId(person).build();

            EmailUser updateEmailUser = emailUserService.updateEmailUser(emailUserUpdate, userId);
            return ResponseEntity.status(HttpStatus.OK).body(emailUserResponseDto(updateEmailUser));
        }else{
            return notFoundException.Exception("This person does not exist.");
        }

    }

    private EmailUserResponseDto emailUserResponseDto(EmailUser emailUserResponse) {
        return EmailUserResponseDto.builder().userId(emailUserResponse.getUserId())
                .userEmail(emailUserResponse.getUserEmail())
                .userPassword(emailUserResponse.getUserPassword())
                .personId(emailUserResponse.getPersonId().getPersonId()).build();
    }


}
