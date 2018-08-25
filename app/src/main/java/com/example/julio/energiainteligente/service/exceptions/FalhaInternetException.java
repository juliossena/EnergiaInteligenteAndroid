package com.example.julio.energiainteligente.service.exceptions;

public class FalhaInternetException extends Exception {

    public FalhaInternetException(String msg) {
        super(msg);
    }

    public FalhaInternetException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
