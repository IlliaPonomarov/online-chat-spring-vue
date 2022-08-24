package ua.ponomarov.Illia.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.services.ChatService;

import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/all")
    public List<Chat> getAllChats(){

        return chatService.findAll();
    }


    @GetMapping("/api/messages/{id}")
    public List<Message> findAllMessagesFromTheChat(@PathVariable int id){
        return chatService.findAllMessagesFromTheChatById(id);
    }
}
