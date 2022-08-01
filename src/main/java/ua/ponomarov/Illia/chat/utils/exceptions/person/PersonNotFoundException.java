package ua.ponomarov.Illia.chat.utils.exceptions.person;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String message){
        super(message);
    }

}
