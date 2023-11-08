package com.itmo.project.lesson11;

public enum Country {
    FRANCE("France", 136537) {
        @Override
        public void sout() {
            System.out.println("Реализация Франции");
        }
    },
    USA("USA", 46356) {
        @Override
        public void sout() {

        }
    },
    ITALY("ITALY", 76585) {
        @Override
        public void sout() {

        }
    };
    private String name;
    private long population;

    //конструктор перечислений всегда приват, даже по умолчанию

    /* privet */ Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
    abstract public  void sout(); /* в перечислении можно объявить абстрактный метод,
    но в каждом элементе ее надо будет реализовать*/
}
