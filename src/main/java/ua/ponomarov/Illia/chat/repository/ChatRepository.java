package ua.ponomarov.Illia.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.ponomarov.Illia.chat.model.Chat;
import java.util.*;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
