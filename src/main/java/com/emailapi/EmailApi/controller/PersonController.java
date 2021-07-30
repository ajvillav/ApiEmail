package com.emailapi.EmailApi.controller;

import com.emailapi.EmailApi.dto.response.PersonResponseDto;
import com.emailapi.EmailApi.model.Person;
import com.emailapi.EmailApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/getPerson/{id}")
    public ResponseEntity<PersonResponseDto> getPerson(@PathVariable("id") UUID personId) {
        Person getPerson = personService.getPerson(personId);
        return ResponseEntity.status(HttpStatus.OK).body(personResponseDto(getPerson));
    }

    @GetMapping(value = "/getPersonList")
    public List<Person> getPersonList() {
        return personService.getPersonList();
    }

    @PutMapping(value = "/updatePersonById/{id}")
    public ResponseEntity<PersonResponseDto> updatePerson(@RequestBody Person person, @PathVariable("id") UUID personId) {
        Person updatePerson = personService.updatePerson(person, personId);
        return ResponseEntity.status(HttpStatus.OK).body(personResponseDto(updatePerson));
    }

    private PersonResponseDto personResponseDto(Person personResponse) {
        return PersonResponseDto.builder().personId(personResponse.getPersonId())
                .personLastName(personResponse.getPersonLastName())
                .residenceCity(personResponse.getResidenceCity())
                .identificationNumber(personResponse.getIdentificationNumber())
                .personName(personResponse.getPersonName()).build();
    }

}
