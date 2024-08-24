package com.project.alliance.Exceptions;


public class AllianceException extends RuntimeException{
    AllianceException(String message){super (message); }
    AllianceException(String message, Throwable cause){
        super(message, cause);
        if(this.getCause() == null && cause != null){
            this.initCause(cause);
        }
    }
}