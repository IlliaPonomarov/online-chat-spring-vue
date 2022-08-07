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

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Chat> findAll(){
        return chatRepository.findAll();
    }

    public List<Message> findAllMessagesFromTheChatById(int id){
        Chat chat = chatRepository.findById(1).get();

        return chat.getMessages();
    }

    @Transactional
    public Chat addChat(Chat chat){

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
        addChat(chat);



        return null;
    }


    public Optional<Chat> findById(int id) {
        return chatRepository.findById(id);
    }
}
