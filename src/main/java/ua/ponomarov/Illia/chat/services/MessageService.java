package ua.ponomarov.Illia.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.repository.ChatRepository;
import ua.ponomarov.Illia.chat.repository.MessageRepository;

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
    public void save(Message message){
        messageRepository.save(message);
    }

}
