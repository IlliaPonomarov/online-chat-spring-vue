package ua.ponomarov.Illia.chat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.services.PersonService;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonNotFoundException;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonsNotExistException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllUsers(){

        List<Person> personList = personService.findAll();

        if (personList.size() == 0)
            throw new PersonsNotExistException("DataBase is empty");

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){

        Optional<Person> person = personService.findById(id);

        if (person.isEmpty())
            throw new PersonNotFoundException();


        return new ResponseEntity<>(person.get(), HttpStatus.OK);
    }



}
