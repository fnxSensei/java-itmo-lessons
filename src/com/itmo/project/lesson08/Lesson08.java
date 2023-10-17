package com.itmo.project.lesson08;

public class Lesson08 {
    public static void main(String[] args) {
        Bicycle bicycle01= new Bicycle("1v", 60);
        bicycle01.increasedWear(3);
        bicycle01.repair();


        Train train01=new Train("123p", 130, 13, true );
        train01.increasedWear(3);
        train01.repair();


        // доступно объявление переменных через общий тип,
        // тогда доступ к методам и свойствам осуществляется согласно типу (слева)
        Vehicle vehicle = new Bicycle("1vh", 30);
        // возможно приведение типов
        Bicycle bVehicle02 = (Bicycle) vehicle;
        // приведение к неверному типу приведет к ClassCastException
        // Train bVehicle01 = (Train) vehicle; // ClassCastException

        Car car = new Car("3p");
        Scooter scooter=new Scooter("12g", 30, true);

    }
}
