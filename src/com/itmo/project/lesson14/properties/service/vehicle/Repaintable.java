package com.itmo.project.lesson14.properties.service.vehicle;

public interface Repaintable {
    boolean changeColor(Color newColor);

    enum Color{
        RED("красный"), ORANGE("оранжевый"), BLACK("чёрный"), BLUE("синий"), GOLD("золотистый");
        private final String name;

        Color(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
    Color getColor ();
}
