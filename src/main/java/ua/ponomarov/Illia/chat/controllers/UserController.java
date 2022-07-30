package ua.ponomarov.Illia.chat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class UserController {

    private PersonService personService;

    @Autowired
    public UserController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getAllUsers(){
        return personService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Person> getPersonById(@PathVariable int id){
        return personService.findById(id);
    }

}
