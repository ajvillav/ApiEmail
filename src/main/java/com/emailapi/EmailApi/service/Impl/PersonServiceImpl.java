package com.emailapi.EmailApi.service.Impl;

import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.repository.PersonRepository;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
