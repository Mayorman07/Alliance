package com.project.alliance.Exceptions;

public class BadRequestException extends  AllianceException {
    public BadRequestException(String message){super(message);}
    public BadRequestException(String message, Throwable cause) {super(message, cause);}
}
