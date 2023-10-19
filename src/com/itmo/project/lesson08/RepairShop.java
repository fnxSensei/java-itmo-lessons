package com.itmo.project.lesson08;

import java.util.Random;

//Задача #3
//Дописать класс RepairShop:
//
//реализовать добавление транспортных средств в массив
//добавить свойство private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};
//изменить реализацию метода repairAll:
//после ремонта машины менять её цвет на произвольный из массива colors
//после ремонта ссылку на транспортное средство необходимо обнулять
public class RepairShop {
    SetColor setColor;
    private Vehicle[] vehicles;
    private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};

    public RepairShop(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public void addToVehicles(Vehicle vehicle) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                return;
            }
        }

    }

    public int changeColor() {
        int n = (int) Math.floor(Math.random() * colors.length);
        return n;
    }


    public void repairAll() {
        for (int i = 0; i < vehicles.length; i++) {
            // для вызова доступны только методы супертипа, т.е. Vehicle
            // но будет использована реализация конкретного подтипа
            vehicles[i].repair();
            // оператор instanceof вернет true,
            // если экземпляр (слева) принадлежит указанному справа типу
            /*if (vehicle instanceof Train) {
                Train t = (Train) vehicle;
                t.changeClimateControl();
            }*/
            // проверка на принадлежность типу + приведение
            // аналогично предыдущей записи
            if (vehicles[i] instanceof Car car) {
                car.setColor(colors[changeColor()]);
            }

            Random random = new Random();
            if (vehicles[i] instanceof SetColor setColor) {
                setColor.changeColor(colors[random.nextInt(colors.length)]);
            }

            vehicles[i] = null;

        }
    }

}
