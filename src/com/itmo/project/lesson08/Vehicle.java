package com.itmo.project.lesson08;

public class Vehicle {
   protected String number;
   protected int wear;
   protected int maxSpeed=120;

    public Vehicle(String number) {
        this.number = number;
    }

    public Vehicle(String number, int maxSpeed) {
        this(number);
        this.maxSpeed=maxSpeed;
    }

    public String getNumber() {
        return number;
    }

    public int getWear() {
        return wear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void increasedWear (int value){
        if (value<0) return;
        wear+=value;
    }
    public void repair (){
        if (wear>0) wear--;
    }
}
