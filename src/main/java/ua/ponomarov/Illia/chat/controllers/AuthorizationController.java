package ua.ponomarov.Illia.chat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.dto.PersonDTO;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.security.JWTUtil;
import ua.ponomarov.Illia.chat.services.PeopleDetailService;
import ua.ponomarov.Illia.chat.services.RegistrationService;
import ua.ponomarov.Illia.chat.utils.PersonValidator;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {


    private final ModelMapper modelMapper;
    private final PeopleDetailService peopleDetailService;
    private final PersonValidator personValidator;
    private final JWTUtil jwtUtil;
    private final RegistrationService registrationService;

    @Autowired
    public AuthorizationController(ModelMapper modelMapper, PeopleDetailService peopleDetailService, PersonValidator personValidator, JWTUtil jwtUtil, RegistrationService registrationService) {
        this.modelMapper = modelMapper;
        this.peopleDetailService = peopleDetailService;
        this.personValidator = personValidator;
        this.jwtUtil = jwtUtil;
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult){

        Person person = convertToPerson(personDTO);
        personValidator.validate(person, bindingResult);

        // finish writing exception handler
        if (bindingResult.hasErrors())
            return Map.of("message", "error");


        registrationService.register(person);

        String token = jwtUtil.generateToken(person.getUsername());


        return Map.of("jwt-token", token);
    }





    private Person convertToPerson(PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }


}
