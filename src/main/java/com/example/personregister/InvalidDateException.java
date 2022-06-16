package com.example.personregister;

public class InvalidDateException extends IllegalArgumentException {

    public InvalidDateException(String msg) {
        super(msg);
    }
}
