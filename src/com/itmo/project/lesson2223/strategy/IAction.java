package com.itmo.project.lesson2223.strategy;

public interface IAction<T> {
    void execute(T t);
}