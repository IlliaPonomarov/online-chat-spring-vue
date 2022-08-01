package ua.ponomarov.Illia.chat.controllers.exceptionControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.ponomarov.Illia.chat.utils.exceptions.ErrorResponse;
import ua.ponomarov.Illia.chat.utils.exceptions.person.PersonNotFoundException;

@ControllerAdvice
public class PersonExceptionController {



    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> personNotFoundHandleException(PersonNotFoundException exception){
        return new ResponseEntity<>(new ErrorResponse("Person not found", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }
}
