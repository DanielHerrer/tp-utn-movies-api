package com.utn.demo.exceptions;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException(String msg) {
        super(msg);
    }
}
