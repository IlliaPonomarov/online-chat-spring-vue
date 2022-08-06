package ua.ponomarov.Illia.chat.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "last_message")
    private String lastMessage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "message_time")
    private Date messageTime;

    @Column(name = "message_count")
    private int messageCount;

    @ManyToMany
    @JoinTable(name="chat_person",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> personList = new ArrayList<>();

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private List<Message> messages = new ArrayList<>();


    public Chat(String title, Message message) {
        this.title = title;
        this.messages.add(message);
    }
}
