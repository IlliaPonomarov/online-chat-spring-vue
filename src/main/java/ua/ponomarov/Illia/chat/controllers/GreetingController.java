package ua.ponomarov.Illia.chat.controllers;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import ua.ponomarov.Illia.chat.model.Greeting;
import ua.ponomarov.Illia.chat.model.HelloMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.security.PersonDetails;

import java.security.Principal;

@RestController
@CrossOrigin
public class GreetingController {



    @GetMapping("/show")
    @ResponseBody
    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getUsername();
    }


}
