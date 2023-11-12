package com.itmo.project.lesson14;

public class PairContainer<T> {
    private T key;
    private T value;

    public PairContainer(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

/*Задание 2:
1. Можно вызвать методы классов Cat, Animal и интерфейсов Eatable, Runnable, Serializable.
2. Можно вызвать методы классов Animal и интерфейсов Runnable, Serializable.
3. Можно вызвать методы интерфейсов Runnable, Serializable.
4.1. Можно указать Cat, Eatable и их супертипы, а передать можно Cat, Eatable и их подтипы.
4.2. Можно указать Animal, Serializable и их супертипы, а передать можно Animal, Serializable и их подтипы.
4.3. Передать можно Dog и его подтипы.
 */

