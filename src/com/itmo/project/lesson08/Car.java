package com.itmo.project.lesson08;

//Задача #1
//Дополнить иерархию транспортных средств классом Машина:
//
//Машина наследуется от Транспортного средства и расширяет его свойством String color со значением по умолчанию - белый.
//В классе добавить возможность изменения цвета.
//Необходимо реализовать класс таким образом, чтобы значение по умолчанию для максимальной скорости было рано 240.
//Реализация метода repair: уменьшение уровня износа на 1, но не меньше 0
public class Car extends Vehicle implements SetColor{
    private String color = "белый";

    public Car(String number) {
        super(number);
        this.maxSpeed=240;
        System.out.println("Создан автомобиль с максимальной скоростью: "+maxSpeed);
    }

    public Car(String number, int maxSpeed) {
        super(number, maxSpeed);
    }

    public Car(String number, int maxSpeed, String color) {
        super(number, maxSpeed);
        this.color=color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public void changeColor(String color) {

    }

    @Override
    public void defColor() {

    }
}
