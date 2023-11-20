package com.itmo.project.lesson19;

import com.itmo.project.lesson14.properties.service.vehicle.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Lesson19 {
    public static void main(String[] args) {
        Stream<Integer> temps = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        temps.filter(integer -> integer<0)
                .map(integer -> integer+"deg")
                .forEach(string -> System.out.println(string));


        Stream<Integer> values = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        values.distinct()
                .map(integer -> integer < 0 ? 0:integer)
                .sorted((i1, i2) -> i2 - i1)
                .forEach(i -> System.out.println(i));



        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        long count =Arrays.stream(colors)
                //boolean test(T t);
                .filter(s -> !s.contains("yellow"))
                .count();
        System.out.println(count);

        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007")
        );
        List<Repaintable.Color> uniqueColor= repaintables.stream()
                .map(s -> s.getColor())
                .distinct()
                .toList();

        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );

        //2.1
        List<String> sortedVehicles = vehicles.stream().
                sorted((o1, o2) -> o2.getLevelOfWare() - o1.getLevelOfWare())
                .map(vehicle -> vehicle.getNumber())
                .toList();

        //2/2

        int sumLevelOfWare = vehicles.stream()
                .mapToInt(vehicle -> vehicle.getLevelOfWare()).sum();

        //2.3

//        vehicles.stream()
//                .peek(vehicle -> vehicle.changeColor(Repaintable.Color.GOLD))
//                .forEach(System.out::println);





            // void accept(T t);
        vehicles.stream().peek(vehicle -> vehicle.repair());
        // R apply(T t);
        vehicles.stream().map(vehicle -> {
            vehicle.repair();
            return vehicle.getLevelOfWare();
        });

    }
}
