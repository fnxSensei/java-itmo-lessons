package com.itmo.project.lesson08;

//Задача #2
//Дополнить иерархию транспортных средств классом Самокат:
//
//Самокат наследуется от Велосипеда и расширяет его свойством boolean isElectric.
//Значения isElectric и максимальная скорость всегда устанавливается через конструктор.
//Количество колёс самоката всегда равно 2, а тип - "Городской".
//Реализация метода repair: если самокат электрический, уровень износа уменьшается на 2, в противном случае на 3, но не меньше 0
public class Scooter extends Bicycle implements SetColor{
    private boolean isElectric;
    private String color;

    public Scooter(String number, int maxSpeed, boolean isElectric) {
        super(number, maxSpeed);
        this.isElectric=isElectric;
        System.out.println(getNumberOfWheels()+ " " + getType());
    }

    @Override
    public void repair() {
        if (wear > 0) {
            if (isElectric == true) wear -= 2;
            else wear-=3;

        }
    }

    @Override
    public void changeColor(String color) {

    }

    @Override
    public void defColor() {

    }
}
