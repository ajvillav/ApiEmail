package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    public PersonService personService;

    @PostMapping(value = "/createPerson")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }


}
