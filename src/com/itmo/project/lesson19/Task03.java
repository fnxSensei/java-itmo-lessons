package com.itmo.project.lesson19;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class Task03 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task04
        // Перед выполнением посмотрите методы flatMap / flatMapToInt / map / mapToInt / allMatch / anyMatch / noneMatch
        // Некоторые из этих методов могут понадобиться при решении задач
    }

    public static Double task01(ArrayList<Article> articles){
        // Вернуть средний возраст авторов статей
        return articles.stream()
                .flatMapToInt(article -> article.getAuthors().values().stream()
                        .mapToInt(author -> {
                            LocalDate current = LocalDate.now();
                            LocalDate authorBirth = author.getBirth();
                            return Period.between(authorBirth, current).getYears();
                        })
                )
                .average().getAsDouble();
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category){
        // Вернуть список email авторов статей категории == category
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .flatMap(article -> article.getAuthors().values().stream()
                        .map(author -> author.getEmail()))
                .toList();
    }
    public static List<Article> task03(ArrayList<Article> articles, Article.Category category, int min, int max){
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> article.getAuthors().values().stream()
                .allMatch(autors -> {
                    int age = Period.between(autors.getBirth(), LocalDate.now()).getYears();
                    return age>min&& age<max;
                })
                )
                .toList();
    }
    public static List<Article> task04(ArrayList<Article> articles, Article.Category category){
        // Вернуть список статей категории == category, опубликованных сегодня
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> article.getPublished().toLocalDate().isEqual(LocalDate.now()))
                .toList();
    }
}