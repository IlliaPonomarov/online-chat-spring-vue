package ua.ponomarov.Illia.chat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ponomarov.Illia.chat.dto.PersonDTO;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.services.PeopleDetailService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {


    private final ModelMapper modelMapper;
    private final PeopleDetailService peopleDetailService;

    @Autowired
    public AuthorizationController(ModelMapper modelMapper, PeopleDetailService peopleDetailService) {
        this.modelMapper = modelMapper;
        this.peopleDetailService = peopleDetailService;
    }

    @GetMapping("/user")
    public Map<String, String> getPersonUsername(){

    }





    private Person convertToPerson(PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }


}
