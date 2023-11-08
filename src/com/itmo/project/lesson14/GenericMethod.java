package com.itmo.project.lesson14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class GenericMethod {

    //generic типы существуют только на этапе компиляции
    //во время выполнения программы их не существует
    //generic компилируется в определенные типы

    //Стирание типов:
    //1.Generic без ограничениями компилируется в Object
    //2.Generic c ограничениями компилируется в тип ограничения

    //типизированные (generic) методы
    //могут принимать на вход и возвращать generic типы
    public static <T> boolean intArray(T[] array, T element){
        if (array==null || element==null) return false;
        for (T elem: array){
            if(elem.equals(element)) return true;
        }
        return false;
    }


    //generic с ограничениями (bounded)
    //T-компилируется в Number
    //K-компилируется в Temporal
    public static <T extends Number, K extends Temporal> int compareHashCodes(T first, K second){
        //у first можно вызвать методы Number и его супертипов
        //у second можно вызвать методы Temporal и его супертипов
        System.out.println(first.longValue());
        System.out.println(second.plus(3, ChronoUnit.HOURS));
        return Integer.compare(first.hashCode(), second.hashCode());
    }

    public static void main(String[] args) {
        String[] strings={"red", "blue", "pink"};
        String string = "yellow";


        // <String> указывает на то, что в метод можно передать
        //указанный тип и его подтипы
        boolean res = GenericMethod.<String>intArray(strings, string);

        // <Number> указывает на то, что в метод можно передать
        //указанный тип и его подтипы
        Integer[] integers={45,89,0,34,-1};
        Integer integer = 3;

        res=GenericMethod.<Number>intArray(integers,integer);

        int result = GenericMethod.<Number, LocalDate>compareHashCodes(integer, LocalDate.now());

        User<String> stringUser = new User<>("12qw");
        stringUser.setId(stringUser.getId().toLowerCase());

        User<Integer> integerUser = new User<>(1);
        integerUser.setId(integerUser.getId()+1);

        //необработанный / сырой / raw Тип
        User rawUser = new User<>("12");
        rawUser.setId(12);
        rawUser.setId(stringUser);
        System.out.println(rawUser.getId().toString());

    }
}
