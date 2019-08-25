package com.library.library.exception;

public class BookIsNotOrderedException extends RuntimeException {

    public BookIsNotOrderedException(String message){
        super(message);
    }

}
