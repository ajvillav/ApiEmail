package com.emailapi.EmailApi.service;

import com.emailapi.EmailApi.model.EmailUser;

import java.util.List;
import java.util.UUID;

public interface EmailUserService {

    EmailUser createEmailUser(EmailUser emailUser);

    EmailUser getEmailUserById(UUID userId);

    List<EmailUser> getEmailUserList();

    void deleteEmailUserById(UUID userId);

    EmailUser updateEmailUser(EmailUser emailUser, UUID userId);
}
