package com.emailapi.EmailApi.service.Impl;

import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.repository.EmailUserRepository;
import com.emailapi.EmailApi.service.EmailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailUserServiceImpl implements EmailUserService {

    @Autowired
    public EmailUserRepository emailUserRepository;

    @Override
    public EmailUser createEmailUser(EmailUser emailUser) {
        return emailUserRepository.save(emailUser);
    }
}
