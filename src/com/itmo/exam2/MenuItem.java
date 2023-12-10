package com.itmo.exam2;

//пункты меню
public class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        System.out.println("Вы выбрали пункт меню: " + name);
    }
}
