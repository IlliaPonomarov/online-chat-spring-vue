package ua.ponomarov.Illia.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ponomarov.Illia.chat.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
