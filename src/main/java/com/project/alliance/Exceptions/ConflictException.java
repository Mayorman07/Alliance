package com.project.alliance.Exceptions;

public class ConflictException extends AllianceException {

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
