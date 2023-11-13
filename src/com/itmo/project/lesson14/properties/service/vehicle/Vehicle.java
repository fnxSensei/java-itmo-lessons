package com.itmo.project.lesson14.properties.service.vehicle;

import java.util.Objects;

public abstract class Vehicle implements Repairable{
    protected String number;
    protected int levelOfWare;

    public Vehicle(String number) {
        setNumber(number);
    }

    public String getNumber(){
        return number;
    }

    public int getLevelOfWare(){
        return levelOfWare;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void incLevelOfWare(int value){
        if (value < 0) return;
        levelOfWare += value;
    }
    public void repair(){
        if (levelOfWare > 0) levelOfWare--;
    }

    public abstract void breakDown();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (levelOfWare != vehicle.levelOfWare) return false;
        return Objects.equals(number, vehicle.number);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + levelOfWare;
        return result;
    }
}
