package com.github.grishasht.docdropper.controller.exception;

public class InvalidUserDataException extends RuntimeException
{

    public InvalidUserDataException() {
    }

    public InvalidUserDataException(String message) {
        super(message);
    }

    public InvalidUserDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
