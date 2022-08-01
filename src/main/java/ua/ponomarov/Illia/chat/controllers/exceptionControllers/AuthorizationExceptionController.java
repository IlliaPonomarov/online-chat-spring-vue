package ua.ponomarov.Illia.chat.controllers.exceptionControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.ponomarov.Illia.chat.utils.exceptions.ErrorResponse;
import ua.ponomarov.Illia.chat.utils.exceptions.PersonNotCreatedException;

@ControllerAdvice
public class AuthorizationExceptionController {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> personNotCreatedHandleException(PersonNotCreatedException exception){
        return  new ResponseEntity<>(new ErrorResponse(exception.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);

    }
}
