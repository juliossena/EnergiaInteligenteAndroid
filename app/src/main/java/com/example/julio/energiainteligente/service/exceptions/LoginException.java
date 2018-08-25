package com.example.julio.energiainteligente.service.exceptions;

public class LoginException extends Exception {

    public LoginException(String msg) {
        super(msg);
    }

    public LoginException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
