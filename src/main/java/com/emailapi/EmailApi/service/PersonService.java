package com.emailapi.EmailApi.service;

import com.emailapi.EmailApi.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    Person createPerson(Person person);

    Person getPerson(UUID personId);

    List<Person> getPersonList();

    void deletePersonById(UUID personId);

    Person updatePerson(Person person, UUID personId);

    Person findFirstByIdentificationNumber(int identificationNumber);
}
