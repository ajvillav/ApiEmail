package com.emailapi.EmailApi.repository;

import com.emailapi.EmailApi.model.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailUserRepository extends JpaRepository<EmailUser, Long> {
}
