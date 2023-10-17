package com.itmo.project.lesson08;

public class Bicycle extends Vehicle{
    private int numberOfWheels = 2;
    private String type = "Городской";

    public Bicycle(String number, int maxSpeed, int numberOfWheels) {
        super(number, maxSpeed); // вызов конструктора родителя
        this.numberOfWheels = numberOfWheels;
    }

    public Bicycle(String number, int maxSpeed) {
        super(number, maxSpeed);
    }

    public Bicycle(int maxSpeed, int numberOfWheels, String type) {
        super("1", maxSpeed); // вызов конструктора родителя
        this.numberOfWheels = numberOfWheels;
        this.type = type;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }


    public String getType() {
        return type;
    }
}
