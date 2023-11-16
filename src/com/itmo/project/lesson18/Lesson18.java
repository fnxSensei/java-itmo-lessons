package com.itmo.project.lesson18;

import com.itmo.project.lesson08.Vehicle;
import com.itmo.project.lesson14.PairContainer;
import com.itmo.project.lesson15.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lesson18 {
    public static void main(String[] args) {
        Operation plus = (first, second) -> first+second;
        Operation sub = (first, second) -> first*second;
        Operation minus = (first, second) -> first-second;
        Operation div = (first, second) -> {if(second==0) throw new IllegalArgumentException("second не должнен быть 0");
           return first/second;
        };

        Operation min = (a, b) -> a<b?a:b;
        printResult(min, 12.3,9.9);
        printResult((a, b) -> a<b?a:b, 12.3, 9.9);

        Operation operation=plus
                .addOperation(minus)
                .addOperation(div)
                .addOperation(sub);
        System.out.println(operation.action(12.4, 5.7));

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(875, -78, 12, 56, 34, -89, 0, 344));
        //Predicate<T> : boolean test(T t)
        Predicate<Integer> negative = elem -> elem<0;
        integers.removeIf(negative);
        //или без переменной
        integers.removeIf(integer -> integer==1000);

        ArrayList<String> files = new ArrayList<>(Arrays.asList("01.txt", "02.json", "03.txt", "04.txt", "05.properties"));
        Predicate<String> str = name -> !(name.endsWith("json") || name.endsWith("properties"));
        files.removeIf(str);
        System.out.println(files.toString());


                ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));
        Predicate<Fruit> fruitPredicate= pr -> (pr.getType().equals(Fruit.FruitType.BANANA) && pr.getPrice()<100);
        fruits.removeIf(fruitPredicate);
        System.out.println(fruits.toString());
        fruits.forEach(n-> {
            if (n.getType() == Fruit.FruitType.BANANA || n.getType()== Fruit.FruitType.APPLE){
                System.out.println(n.getPrice());
            }
        });
        fruits.forEach(line -> line.setPrice(line.getPrice()*2));

        Predicate<Fruit> filter = fruit -> fruit.getPrice()>100;
        filter.test(new Fruit(Fruit.FruitType.BANANA, 233, 10));

        //Comparator<T> int compare(T o1, T o2);
        Comparator<Fruit> comparatorByPrice = ((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        Comparator<Fruit> compareByCount = (f1, f2) -> f2.getCount()-f1.getCount();
        fruits.sort(comparatorByPrice);
        fruits.sort(comparatorByPrice.thenComparing(compareByCount));

    }

    private static <T extends  Fruit> ArrayList<T> filterFruits (ArrayList<T> fruits, Predicate<? super T> filter) {
        ArrayList<T> fruitList = new ArrayList<>();
        for (T fruit:fruits) {
            if (filter.test(fruit)) fruitList.add(fruit);
        }
        return fruitList;
    }

    private static void printResult(Operation operation, double a, double b) {
        System.out.println(operation.action(a,b));
    }
}
