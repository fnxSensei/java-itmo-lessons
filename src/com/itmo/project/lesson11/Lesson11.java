package com.itmo.project.lesson11;

import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args) {
        Country france = Country.FRANCE;
        Article article = new Article(Country.ITALY);
        //сравнивать перечисления можно через ==
        System.out.println(france==article.getCountry());
        Country[] countries=Country.values();
        System.out.println(Arrays.toString(countries));
        System.out.println(Country.USA.ordinal());//вернет индекс эл-та в массиве
        Country.ITALY.setName("Италия");
        Country.FRANCE.setName("Франция");
        System.out.println(france.getName());
        france.sout();

    }
}
