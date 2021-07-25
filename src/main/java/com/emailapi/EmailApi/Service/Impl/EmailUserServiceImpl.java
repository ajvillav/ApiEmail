package com.emailapi.EmailApi.Service.Impl;

import com.emailapi.EmailApi.Model.EmailUser;
import com.emailapi.EmailApi.Repository.EmailUserRepository;
import com.emailapi.EmailApi.Service.EmailUserService;
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
