package com.itmo.project.lesson2223.chain;

public class Animal {


    public void doAction(Action action) {
        action.executeNext(this);
    }
}