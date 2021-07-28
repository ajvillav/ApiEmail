package com.emailapi.EmailApi.service;

import com.emailapi.EmailApi.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPerson(Long personId);

    List<Person> getPersonList();

    void deletePersonById(Long personId);

    Person updatePerson(Person person, Long personId);
}
