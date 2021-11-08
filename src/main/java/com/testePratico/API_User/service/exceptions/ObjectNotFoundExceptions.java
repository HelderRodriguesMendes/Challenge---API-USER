package com.testePratico.API_User.service.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{
    public ObjectNotFoundExceptions(String message) {
        super(message);
    }

    public ObjectNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
