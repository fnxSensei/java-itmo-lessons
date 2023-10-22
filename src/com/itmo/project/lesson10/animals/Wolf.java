package com.itmo.project.lesson10.animals;

//Задание на метод equals (пакет animals)
//Реализовать метод equals класса Wolf. Экземпляры Wolf считаются равными по методу equals,
// если равны значения всех их свойств.

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;


    public Wolf(String name, double age, int strength, String[] likeToEat, String color) {
        super(name, age,strength);
        this.likeToEat = likeToEat;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wolf wolf = (Wolf) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equal
        if (!Arrays.equals(likeToEat, wolf.likeToEat)) return false;
        return Objects.equals(color, wolf.color) && Objects.equals(getStrength(), wolf.getStrength())
                && Objects.equals(getName(), wolf.getName()) && Objects.equals(getAge(), wolf.getAge());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(likeToEat);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}