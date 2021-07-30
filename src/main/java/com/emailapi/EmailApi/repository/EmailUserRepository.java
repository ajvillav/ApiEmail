package com.emailapi.EmailApi.repository;

import com.emailapi.EmailApi.model.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailUserRepository extends JpaRepository<EmailUser, UUID> {
}
