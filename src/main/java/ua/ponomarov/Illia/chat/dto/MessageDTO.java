package ua.ponomarov.Illia.chat.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
*  {
                    'id' : this.selected_chat.messages[this.selected_chat.messages.length - 1].id++,
                    'message' :  JSON.parse(tick.body).content,
                    'person_id' : person.person_id,
                    'sendAt' : Date.now(),
                    'sender' : this.auth_user['username']
                  }
* */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    @NotNull
    private Integer person_id;

    private String message;

    private String sender;


}
