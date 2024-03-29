package ua.ponomarov.Illia.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import ua.ponomarov.Illia.chat.dto.MessageDTO;
import ua.ponomarov.Illia.chat.model.*;
import ua.ponomarov.Illia.chat.services.ChatService;
import ua.ponomarov.Illia.chat.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chats")
@CrossOrigin
public class ChatController {

    private final ChatService chatService;
    private Optional<Person> authorizedPerson;
    private final PersonService personService;

    @Autowired
    public ChatController(ChatService chatService, PersonService personService) {
        this.chatService = chatService;
        this.personService = personService;
    }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageDTO currentChat(MessageDTO message) throws Exception{
        Thread.sleep(1000);

        System.out.println(message.toString());
        return new MessageDTO(message.getId(), message.getPerson_id(), message.getMessage(), message.getSender());
    }

    @GetMapping("/")
    public List<Chat> getAllChatsForAuthenticatedPerson(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nameOfAuthenticatedPerson = ((UserDetails) principal).getUsername();

        return personService.getAllChatsOfPerson(nameOfAuthenticatedPerson);
    }


    // Create new Message Controller for this method
    @GetMapping("/api/messages/{id}")
    public List<Message> findAllMessagesFromTheChat(@PathVariable int id){
        return chatService.findAllMessagesFromTheChatById(id);
    }
}