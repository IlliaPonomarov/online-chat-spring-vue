package ua.ponomarov.Illia.chat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.services.ChatService;
import ua.ponomarov.Illia.chat.services.PersonService;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonNotFoundException;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonsNotExistException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;
    private final ChatService chatService;

    @Autowired
    public PersonController(PersonService personService, ChatService chatService) {
        this.personService = personService;
        this.chatService = chatService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllUsers(){

        List<Person> personList = personService.findAll();

        if (personList.size() == 0)
            throw new PersonsNotExistException("DataBase is empty");

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){

        Optional<Person> person = personService.findById(id);

        Chat chat = chatService.findById(2).get();
        if (person.isEmpty())
            throw new PersonNotFoundException();

        person.get().getChats().add(chat);

        return new ResponseEntity<>(person.get(), HttpStatus.OK);
    }



}
