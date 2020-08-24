package com.iiht.ecoronakit.exceptions;


public class ConflictException extends  Exception{

    private String message;

    public ConflictException(String message) {
        super(message);
        this.message = message;
    }
}
