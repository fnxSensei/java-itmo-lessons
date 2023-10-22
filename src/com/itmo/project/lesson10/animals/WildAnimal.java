package com.itmo.project.lesson10.animals;

public class WildAnimal extends Animal{
    private int strength;

    public WildAnimal(String name, double age, int strength) {
        super(name, age);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}