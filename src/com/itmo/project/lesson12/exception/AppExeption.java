package com.itmo.project.lesson12.exception;

public class AppExeption extends Exception{
    public AppExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AppExeption(String message) {
        super(message);
    }
}
