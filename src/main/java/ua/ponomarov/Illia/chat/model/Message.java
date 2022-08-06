package ua.ponomarov.Illia.chat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "sender")
    private String sender;

    @Column(name = "sendAt")
    @Temporal(TemporalType.TIMESTAMP)
    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;


    public Message(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }
}
