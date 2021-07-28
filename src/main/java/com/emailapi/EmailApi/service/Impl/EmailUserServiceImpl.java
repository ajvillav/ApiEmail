package com.emailapi.EmailApi.service.Impl;

import com.emailapi.EmailApi.model.EmailUser;
import com.emailapi.EmailApi.repository.EmailUserRepository;
import com.emailapi.EmailApi.service.EmailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailUserServiceImpl implements EmailUserService {

    @Autowired
    public EmailUserRepository emailUserRepository;

    @Override
    public EmailUser createEmailUser(EmailUser emailUser) {
        return emailUserRepository.save(emailUser);
    }

    @Override
    public EmailUser getEmailUserById(Long userId) {
        return emailUserRepository.findById(userId).orElse(null);
    }

    @Override
    public List<EmailUser> getEmailUserList() {
        return emailUserRepository.findAll();
    }

    @Override
    public void deleteEmailUserById(Long userId) {
        emailUserRepository.deleteById(userId);
    }

    @Override
    public EmailUser updateEmailUser(EmailUser emailUser, Long userId) {
        EmailUser emailUser1 = emailUserRepository.findById(userId).orElse(null);
        if (emailUser1 != null) {
            emailUser.setUserId(userId);
            emailUser1 = emailUserRepository.save(emailUser);
        }

        return emailUser1;
    }
}
