package com.itmo.project.lesson18;

import java.util.function.Predicate;

import java.util.function.Predicate;
@FunctionalInterface
public interface Notification {

    void send(String message);

    default Notification add(Notification other, Predicate<String> predicate){
        return (message) -> {
            if (predicate.test(message)) other.send(message);
            send(message);
        };
    }
}
