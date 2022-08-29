package ua.ponomarov.Illia.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ponomarov.Illia.chat.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
