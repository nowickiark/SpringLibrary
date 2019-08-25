package com.library.library.controller;

import com.library.library.exception.BookDoesNotExistsException;
import com.library.library.exception.BookIsNotOrderedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(value = {BookDoesNotExistsException.class,BookIsNotOrderedException.class })
    public ResponseEntity<?> handleException(RuntimeException ex){
        return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

}
