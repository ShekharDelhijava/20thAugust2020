package com.iiht.ecoronakit.exceptions;


public class DuplicateElementException extends Exception {

    private String message;

    public DuplicateElementException(String message) {
        super(message);
        this.message = message;
    }
}
