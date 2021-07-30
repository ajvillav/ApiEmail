package com.emailapi.EmailApi.service.Impl;

import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.repository.PersonRepository;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(UUID personId) {
        return personRepository.findById(personId).orElse(null);
    }

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public void deletePersonById(UUID personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public Person updatePerson(Person person, UUID personId) {
        Person person1 = personRepository.findById(personId).orElse(null);
        if (person1 != null) {
            person.setPersonId(personId);
            person1 = personRepository.save(person);
        }

        return person1;
    }

    @Override
    public Person findFirstByIdentificationNumber(int identificationNumber) {
        return personRepository.findAllByIdentificationNumber(identificationNumber);
    }

}
