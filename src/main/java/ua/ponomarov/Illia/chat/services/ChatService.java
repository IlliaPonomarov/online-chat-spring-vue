package ua.ponomarov.Illia.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Message;
import ua.ponomarov.Illia.chat.repository.ChatRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
@Transactional(readOnly = true)
public class ChatService {

    private final ChatRepository chatRepository;
    private final MessageService messageService;

    @Autowired
    public ChatService(ChatRepository chatRepository, MessageService messageService) {
        this.messageService = messageService;
        this.chatRepository = chatRepository;
    }

    public List<Chat> findAll(){
        return chatRepository.findAll();
    }

    @Transactional // for the test
    public List<Message> findAllMessagesFromTheChatById(int id){
        Chat chat = null;
        if (chatRepository.findById(id).isPresent())
           chat = chatRepository.findById(id).get();
        chat.getMessages().forEach(p -> System.out.println(p.getMessage()));

        return chat.getMessages();
    }

    @Transactional
    public Chat save(Chat chat){

        return chatRepository.save(chat);
    }

    @Transactional
    public Chat update(Chat chat){
        // check if this object already exist

        return chatRepository.save(chat);
    }

    // 1. Получаю имя отправителя сообщения и его сообщение
    // 2. Создаем Объект сообщения.
    //    2.1 Добавляем : Имя отпрaвителя (sender),  Сообщение, Текущее время отправки
    // 3.Чат
    //   3.1 Создаем объект
    //   3.2 Меняем последнее сообщенме на новое.
    //   3.3 Инкрементируем новое значение.
    //   3.4 Обновляем время отправки последнего сообщения.
    //   3.5 Инициализируем имя чата и сообщение

    @Transactional
    public Chat testChat(){


        Message message = new Message("Test Messge", "Test 1");
        message.setSendAt(new Date());

        Chat chat = new Chat();
        chat.setLastMessage(message.getMessage());
        chat.getMessages().add(message);
        chat.setMessageTime(message.getSendAt());
        chat.setMessageCount(chat.getMessages().size() - 1);
        chat.setTitle("Chat1");
        save(chat);



        return null;
    }


    public Optional<Chat> findById(int id) {
        return chatRepository.findById(id);
    }
}
