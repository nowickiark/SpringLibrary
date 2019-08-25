package com.library.library.exception;

public class BookIsAlreadyTaken extends RuntimeException {

    public BookIsAlreadyTaken(String message){
        super(message);
    }

}
