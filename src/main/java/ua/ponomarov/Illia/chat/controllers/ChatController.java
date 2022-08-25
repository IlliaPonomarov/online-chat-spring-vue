package ua.ponomarov.Illia.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Greeting;
import ua.ponomarov.Illia.chat.model.HelloMessage;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.services.ChatService;
import ua.ponomarov.Illia.chat.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatController {

    private final ChatService chatService;
    private final PersonService personService;

    @Autowired
    public ChatController(ChatService chatService, PersonService personService) {
        this.chatService = chatService;
        this.personService = personService;
    }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Greeting currentChat(HelloMessage helloMessage) throws Exception{
        Thread.sleep(1000);

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()));
    }




    @GetMapping("/all")
    public List<Chat> getAllChatsForAuthenticatedPerson(){

        String nameOfAuthenticatedPerson = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Chat> test = personService.getAllChatsOfPerson(nameOfAuthenticatedPerson);

        return test;
    }


    @GetMapping("/api/messages/{id}")
    public List<Message> findAllMessagesFromTheChat(@PathVariable int id){
        return chatService.findAllMessagesFromTheChatById(id);
    }
}
