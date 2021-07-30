package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/createPerson")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping(value = "/getPerson/{id}")
    public Person getPerson(@PathVariable("id") UUID personId) { return personService.getPerson(personId); }

    @GetMapping(value = "/getPersonList")
    public List<Person> getPersonList() {
        return personService.getPersonList();
    }

    @DeleteMapping(value = "/deletePersonById/{id}")
    public void deletePersonById(@PathVariable("id") UUID personId) {
        personService.deletePersonById(personId);
    }

    @PutMapping(value = "/updatePersonById/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("id") UUID personId){ return personService.updatePerson(person, personId); }
}
