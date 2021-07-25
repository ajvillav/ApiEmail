package com.emailapi.EmailApi.Service.Impl;

import com.emailapi.EmailApi.Model.Person;
import com.emailapi.EmailApi.Repository.PersonRepository;
import com.emailapi.EmailApi.Service.PersonService;
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
