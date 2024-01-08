package com.kfp.bookstore.book.domain.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message){
        super(message);
    }
}
