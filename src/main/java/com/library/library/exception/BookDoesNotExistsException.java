package com.library.library.exception;

public class BookDoesNotExistsException extends RuntimeException {

    public BookDoesNotExistsException(String message){
        super(message);
    }
}
