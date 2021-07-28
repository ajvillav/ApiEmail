package com.emailapi.EmailApi.service;

import com.emailapi.EmailApi.model.EmailUser;

import java.util.List;

public interface EmailUserService {

    EmailUser createEmailUser(EmailUser emailUser);

    EmailUser getEmailUserById(Long userId);

    List<EmailUser> getEmailUserList();

    void deleteEmailUserById(Long userId);

    EmailUser updateEmailUser(EmailUser emailUser, Long userId);
}
