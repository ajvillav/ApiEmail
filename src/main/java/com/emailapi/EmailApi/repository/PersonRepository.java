package com.emailapi.EmailApi.repository;

import com.emailapi.EmailApi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Person findAllByIdentificationNumber(int identificationNumber);
}
