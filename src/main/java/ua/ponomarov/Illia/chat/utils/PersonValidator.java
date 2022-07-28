package ua.ponomarov.Illia.chat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.ponomarov.Illia.chat.model.Person;

import ua.ponomarov.Illia.chat.services.PersonService;

public class PersonValidator implements Validator {

    private final PersonService personService;


    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Person person = (Person) target;

        if (personService.findByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username", "", "User with this username already exist");


    }
}
