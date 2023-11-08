package com.itmo.project.lesson12.exception;

public class User {
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
