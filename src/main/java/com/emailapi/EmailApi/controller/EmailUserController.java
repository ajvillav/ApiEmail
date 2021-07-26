package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.service.EmailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmailUser")
public class EmailUserController {

    @Autowired
    public EmailUserService emailUserService;

    @PostMapping(value = "/createEmailUser")
    public EmailUser createEmailUser(@RequestBody EmailUser emailUser) {
        return emailUserService.createEmailUser(emailUser);
    }


}
