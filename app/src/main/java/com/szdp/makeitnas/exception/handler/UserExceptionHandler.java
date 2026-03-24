package com.szdp.makeitnas.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.szdp.makeitnas.exception.InvalidUserDataException;
import com.szdp.makeitnas.exception.UserNotFoundException;
import com.szdp.makeitnas.exception.payload.UserExceptionPayload;

@ControllerAdvice
public class UserExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity <Object> handleUserNotFoundException(final UserNotFoundException exc) {
        return new ResponseEntity<>(new UserExceptionPayload(exc.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity <Object> handleInvalidUserDataException(final InvalidUserDataException exc) {
        return new ResponseEntity<>(new UserExceptionPayload(exc.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

}
