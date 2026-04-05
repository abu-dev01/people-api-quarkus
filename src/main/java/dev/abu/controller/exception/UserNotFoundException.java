package dev.abu.controller.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
