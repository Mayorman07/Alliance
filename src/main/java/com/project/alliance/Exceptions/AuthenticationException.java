package com.project.alliance.Exceptions;

public class AuthenticationException extends AllianceException {

    public AuthenticationException(String message){
        super(message);
    }

    public AuthenticationException(String message, Throwable cause){
        super(message, cause);
    }
}
