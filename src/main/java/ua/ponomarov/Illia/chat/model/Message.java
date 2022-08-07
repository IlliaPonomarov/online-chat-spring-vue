package ua.ponomarov.Illia.chat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @NotNull
    @Column(name = "person_id")
    private Integer person_id;

    @Column(name = "message")
    private String message;

    @Column(name = "sender")
    private String sender;

    @Column(name = "send_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendAt;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;


    public Message(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }
}
