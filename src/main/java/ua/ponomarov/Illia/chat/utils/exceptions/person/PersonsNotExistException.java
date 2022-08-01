package ua.ponomarov.Illia.chat.utils.exceptions.person;

public class PersonsNotExistException extends RuntimeException{

    public PersonsNotExistException(String message){
        super(message);
    }
}
