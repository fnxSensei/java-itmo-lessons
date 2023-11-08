package com.itmo.project.lesson15;

import java.time.LocalDate;
import java.util.Comparator;

public class User {
    private String name;
    private LocalDate birth;
    private int salary;

    public static class NameComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            // "-1" o1 меньше
            // "1" o1 больше
            return o1.name.compareTo(o2.name);
            //return o1.name.length()-o2.name.length();
        }
    }

    public static class SalaryComparator implements Comparator<User>{

        @Override
        public int compare(User o1, User o2) {
            return o1.salary-o2.salary;
        }
    }
}
