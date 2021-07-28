package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.service.EmailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/EmailUser")
public class EmailUserController {

    @Autowired
    public EmailUserService emailUserService;

    @PostMapping(value = "/createEmailUser")
    public EmailUser createEmailUser(@RequestBody EmailUser emailUser) {
        return emailUserService.createEmailUser(emailUser);
    }

    @GetMapping(value = "/getEmailUserById/{id}")
    public EmailUser getEmailUserById(@PathVariable("id") Long userId) {
        return emailUserService.getEmailUserById(userId);
    }

    @GetMapping(value = "/getEmailUserList")
    public List<EmailUser> getEmailUserList() {
        return emailUserService.getEmailUserList();
    }

    @DeleteMapping(value = "/deleteEmailUserById/{id}")
    public void deleteEmailUserById(@PathVariable("id") Long userId) {
        emailUserService.deleteEmailUserById(userId);
    }

    @PutMapping(value = "/updateEmailUser/{id}")
    public EmailUser updateEmailUser(@RequestBody EmailUser emailUser, @PathVariable("id") Long userId) {
        return emailUserService.updateEmailUser(emailUser, userId);
    }


}
