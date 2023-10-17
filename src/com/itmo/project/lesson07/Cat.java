package com.itmo.project.lesson07;

public class Cat {
    private String name = "Мурзик";
    private int weight;
    private int victoryCount;

    public Cat(){}

    public Cat(int weight) {
        setWeight(weight);
    }

    public Cat(String name, int weight) {
        setName(name);
        setWeight(weight);
    }

    public void setName(String name) {
        String filtered = name.trim().replaceAll(" ", "");
        if (filtered.length()<4) return;
        this.name = name;
    }

    public void setWeight(int weight) {
        if(weight<1||weight>8) return;
        this.weight = weight;
    }

    public int getVictoryCount() {
        return victoryCount;
    }
    public boolean attack (Cat attacking){
        if (attacking==null) return false;
        if (this.weight<attacking.weight){
            attacking.victoryCount++;
            return true;
        } else {
            this.victoryCount++;
            return false;
        }

        }

    }

