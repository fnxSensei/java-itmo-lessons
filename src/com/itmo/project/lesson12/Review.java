package com.itmo.project.lesson12;

import java.time.LocalDateTime;
// Review - название
//(long id, String text, LocalDateTime createAt) - заголовок (header)
// со списком компонентов
public record Review(long id, String text, LocalDateTime createAt) {
    //нельзя объявлять не static поля

    //можно написать реализацию канонического конструктора
    //или написать реализацию компактного (compact) конструктора
    //их модификатор не может быть мниже модификатора самой записи
    public Review/*по умолчанию принимате компаненты записи*/{
        //можно создать инструкции или проверки if и т.д
        if (id<0 || text.trim().length() <5|| createAt==null)
            throw  new IllegalArgumentException("Переданы невалидные данные");
        //по умолчанию инициализирует значения всех свойтсв
    }
    //можно перегрузить конструкторы
    // но в них необходимо вызвать один из объявленных
    public Review(String text){
        this(0, text);
    }
    public Review(long id, String text){
        this(1,text, LocalDateTime.now());
    }
    //можно объявлять собственные методы(статические и нет)
    //можно написать собственную логику геттеров, equals, hashCode и toString
}
// не могут наследоваться
// не могут иметь наследников(final)
//могут имплементировать интерфейсы, включая sealed
//могут быть вложенными и могут иметь вложенные записи

// 1. private final поля - названия и типы, как у компонентов
// 2. канонический (canonocal) конструктор - принимает и инициализирует
//значения всех свойст
// 3. одноименные (с компонентами) геттеры
//4. equals, hashCode, toString