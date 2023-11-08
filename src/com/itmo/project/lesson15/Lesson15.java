package com.itmo.project.lesson15;

import com.itmo.project.lesson08.Vehicle;

import java.util.*;

/*public class LinkedList<E>
        implements List<E>, Deque<E>, Cloneable*/

public class Lesson15 {
    public static void main(String[] args) {


        Set<String> strings01 = new HashSet<>(
                Arrays.asList("Саратов", "Новгород")
        );
        strings01.add("Тверь");
        strings01.add("Москва");

        List<String> strings = new LinkedList<>(strings01);

        // int size = 3;
        // Node first = new Node("СПБ");
        // Node last = new Node("Москва");
        System.out.println(strings.size()); // ["Тверь", "Москва"]

        strings.add("СПБ");
        strings.add("Самара");
        strings.add(null);
        strings.add("Москва");
        strings.remove("Самара");
        strings.remove(3);

        // null<-new Node("СПБ"); <->
        // <-> new Node("Москва"); -> null

        ArrayList<String> stringArrayList = new ArrayList<>(40);
        // String[] i = new String[40];

        ArrayList<Integer> integers = new ArrayList<>();
        // integers.trimToSize();
        // Integer[] i = new Integer[10];
        System.out.println(integers.size()); // 2
        integers.add(3);
        integers.add(6);
        integers.add(90);
        integers.add(90);
        integers.add(90);

        // перебор коллекций
        // fori (только списки) /
        // foreach (любая коллекция) /
        // iterator (любая коллекция) /
        // вызов метода remove однопоточных коллекций
        // в циклах fori и foreach
        // приведет к исключению ConcurrentModificationException

        for (var integer : integers) {
            System.out.println(integer);
        }


        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element.toUpperCase());
            if ("самара".equalsIgnoreCase(element)) {
                iterator.remove();
            }
        }

        strings.removeIf(string -> string.equalsIgnoreCase("самара"));

        // ArrayList<Vehicle> vehicles = new ArrayList<>();
        // for (Vehicle vehicle : vehicles) {}

        // List: ArrayList, LinkedList
        //1. возможность работы с индексами
        //2.

        //Set:
        //1. не позволяет хранить дублирующиеся эл-ты
        //2. возможность добавить null и порядок хранения эл-в
        //   зависят от конкретной реализации
        //3. для добовляемых элементов обязательно
        // переопределять метод equals

        //ревализован на основе хеш-таблицы
        //для добовляемых элементов обязательно
        //переопределять метод HashCode
        HashSet<Integer> integerHashSet= new HashSet<>();
        //порядок хранения эл-в
        //может отличаться от порядка добавления
        integerHashSet.add(4);
        integerHashSet.add(6);
        integerHashSet.add(4); //false
        integerHashSet.add(7);
        integerHashSet.add(70);
        integerHashSet.add(145);
        //integerHashSet.add(null); позволяет добавлять null
        System.out.println(integerHashSet);

         // Для типов добавляемых в TreeSet обязательно
        // 1. implements Comparable<Integer>
        //либо
        // 2. экземпляр Comparator передать в конструктор TreeSet
        TreeSet<String> stringTreeSet= new TreeSet<>();
        stringTreeSet.add("1");
        stringTreeSet.add("145");
        stringTreeSet.add("45");
        stringTreeSet.add("4");
        stringTreeSet.add("0");
        //stringTreeSet.add("null"); не позволяет добавить null, выкинет exeption


        Comparator<User> byName =new  User.NameComparator();
        Comparator<User> bySalary = new User.SalaryComparator();

        Comparator<User> byNameThenSalary=byName.thenComparing(bySalary);

        TreeSet<User> users = new TreeSet<>(byNameThenSalary);
    }
}