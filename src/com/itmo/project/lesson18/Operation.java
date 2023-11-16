package com.itmo.project.lesson18;
@FunctionalInterface
public interface Operation {
    double action(double a, double b);

    default Operation addOperation(Operation other){
        return (a, b) -> action(a, b) + other.action(a, b);
    }
}
