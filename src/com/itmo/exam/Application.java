package com.itmo.exam;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness();


        // Создание абонемента и добавление в тренажерный зал
        Abonnement abonnement1 = new Abonnement("Разовый", 1, LocalDate.now(),
                LocalDate.now().plusDays(1),new Owner("Vasa", "Ivanov", 01012000));
        fitness.addAbonnementToZone(Zone.GYM, abonnement1);

        // Создание абонемента и добавление в бассейн
        Abonnement abonnement2 = new Abonnement("Дневной", 2, LocalDate.now(),
                LocalDate.now().plusMonths(1), new Owner("Ivan", "Sidorov", 02022001));
        fitness.addAbonnementToZone(Zone.POOL, abonnement2);
        fitness.addAbonnementToZone(Zone.POOL, abonnement1);

//        // Создание абонемента и добавление в групповые занятия
//        Abonnement abonnement3 = new Abonnement("Полный",3, LocalDate.now(),
//                LocalDate.now().plusMonths(3), new Owner("Fedor", "Sidorov", 03032002));
//        fitness.addAbonnementToZone(Zone.GROUP, abonnement3);

        // Вывод информации о текущих абонементах
        fitness.printCurrentAbonnements();
    }
}
