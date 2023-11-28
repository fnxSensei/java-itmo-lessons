package com.itmo.project.lesson2223;

public class RunFast implements IAction<Unit>{
    @Override
    public void execute(Unit unit) {
        System.out.println("unit RunFast");
    }
}
