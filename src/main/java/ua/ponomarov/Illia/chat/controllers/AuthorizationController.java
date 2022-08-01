package ua.ponomarov.Illia.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.dto.AuthenticationDTO;
import ua.ponomarov.Illia.chat.dto.PersonDTO;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.security.JWTUtil;
import ua.ponomarov.Illia.chat.services.PersonService;
import ua.ponomarov.Illia.chat.services.RegistrationService;
import ua.ponomarov.Illia.chat.utils.PersonValidator;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonNotCreatedException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {


    private final PersonService personService;
    private final PersonValidator personValidator;
    private final JWTUtil jwtUtil;
    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationController(PersonService peopleDetailService, PersonValidator personValidator, JWTUtil jwtUtil, RegistrationService registrationService, AuthenticationManager authenticationManager) {
        this.personService = peopleDetailService;
        this.personValidator = personValidator;
        this.jwtUtil = jwtUtil;
        this.registrationService = registrationService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult){

        Person person = personService.convertToPerson(personDTO);
        personValidator.validate(person, bindingResult);


        if (bindingResult.hasErrors()) {

            StringBuilder messageErrors = new StringBuilder();
            List<FieldError>  fieldsErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldsErrors)
                messageErrors.append(fieldError.getField())
                        .append(" - ")
                        .append(fieldError.getDefaultMessage())
                        .append(";");


            throw new PersonNotCreatedException(messageErrors.toString());
        }

        registrationService.register(person);

        String token = jwtUtil.generateToken(person.getUsername());


        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8081/auth/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO authenticationDTO, BindingResult bindingResult) {

        System.out.println(authenticationDTO.toString());
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());



        try{
            authenticationManager.authenticate(authToken);
        }catch (BadCredentialsException exception){
            return new ResponseEntity<>("Incorrect Username or Password", HttpStatus.NOT_ACCEPTABLE);
        }

        String jwtToken = jwtUtil.generateToken(authenticationDTO.getUsername());

        return new ResponseEntity<>(jwtToken, HttpStatus.OK);

    }






}
