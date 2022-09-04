package ua.ponomarov.Illia.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.repository.ChatRepository;
import ua.ponomarov.Illia.chat.repository.MessageRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MessageService {

    private final ChatRepository chatRepository;

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(ChatRepository chatRepository, MessageRepository messageRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void saveMessage(Message message){
        messageRepository.save(message);
    }

    @Transactional
    public void saveMessages(Optional<Chat>  chat, List<Message> messages){

        if (chat.isPresent()) {
           for (Message message : messages)
               chat.get().getMessages().add(message);
        }
    }
}