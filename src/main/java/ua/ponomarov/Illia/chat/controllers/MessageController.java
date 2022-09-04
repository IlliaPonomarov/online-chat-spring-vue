package ua.ponomarov.Illia.chat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.services.ChatService;
import ua.ponomarov.Illia.chat.services.MessageService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final MessageService messageService;
    private final ChatService chatService;

    @Autowired
    public MessageController(MessageService messageService, ChatService chatService) {
        this.messageService = messageService;
        this.chatService = chatService;
    }

    @GetMapping
    public Optional<Message> findMessageInChatById(@RequestBody int messageId, @RequestBody int chatId){


        return null;
    }


    @PostMapping
    public ResponseEntity<?> saveMessagesFromChat(@RequestBody int chatId, @RequestBody List<Message> messages){

        Optional<Chat> currentChat = chatService.findById(chatId);


        messageService.saveMessages(currentChat, messages);


        return ResponseEntity.ok(HttpStatus.OK);
    }

}
