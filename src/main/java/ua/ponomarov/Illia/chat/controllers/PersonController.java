package ua.ponomarov.Illia.chat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.services.PersonService;
import ua.ponomarov.Illia.chat.utils.exceptions.PersonNotFoundException;

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
    public List<Person> getAllUsers(){



        return personService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Person> getPersonById(@PathVariable int id){

        Optional<Person> person = personService.findById(id);

        if (person.isEmpty())
            throw new PersonNotFoundException();


        return personService.findById(id);
    }



}
