package com.emailapi.EmailApi.Repository;

import com.emailapi.EmailApi.Model.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailUserRepository extends JpaRepository<EmailUser, Long> {
}
