package com.itmo.exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


    class Fitness {
        private Abonnement[] gymAbonnements;
        private Abonnement[] poolAbonnements;
        private Abonnement[] groupAbonnements;

        public Fitness() {
            this.gymAbonnements = new Abonnement[20];
            this.poolAbonnements = new Abonnement[20];
            this.groupAbonnements = new Abonnement[20];
        }

        public void addAbonnementToZone(Zone zone, Abonnement abonnement) {
            if (isAbonnementValid(abonnement) && !isAbonnementRegistered(abonnement)
                    && isRejectionReason(abonnement, zone)) {
                switch (zone) {
                    case GYM:
                        gymAbonnements[getIndex(gymAbonnements)] = abonnement;
                        break;
                    case POOL:
                        poolAbonnements[getIndex(poolAbonnements)] = abonnement;
                        break;
                    case GROUP:
                        groupAbonnements[getIndex(groupAbonnements)] = abonnement;
                        break;
                }

                System.out.println(abonnement.getOwner().getFirstName() + " " + abonnement.getOwner().getLastName() +
                        " посещает " + zoneToString(zone));
                System.out.println("Дата и время посещения: " + LocalDate.now() + " " + LocalTime.now());
            } else {
                System.out.println("Невозможно добавить абонемент в " + zoneToString(zone) + ". Причина: " +
                        getRejectionReason(abonnement, zone));
            }
        }

        private boolean isAbonnementValid(Abonnement abonnement) {
            LocalDate currentDate = LocalDate.now();
            if (abonnement.getExpirationDate().isBefore(currentDate)) {
                return false;
            }
            return true;
        }

        private boolean isAbonnementRegistered(Abonnement abonnement) {
                    for (Abonnement gymAbonnement : gymAbonnements) {
                        if (gymAbonnement != null && gymAbonnement.getNumber() == abonnement.getNumber()) {
                            return true;
                        }
                    }
                    for (Abonnement poolAbonnement : poolAbonnements) {
                        if (poolAbonnement != null && poolAbonnement.getNumber() == abonnement.getNumber()) {
                            return true;
                        }
                    }
                    for (Abonnement groupAbonnement : groupAbonnements) {
                        if (groupAbonnement != null && groupAbonnement.getNumber() == abonnement.getNumber()) {
                            return true;
                        }
                    }
            return false;
        }

        private int getIndex(Abonnement[] abonnements) {
            for (int i = 0; i < abonnements.length; i++) {
                if (abonnements[i] == null) {
                    return i;
                }
            }
            return -1;
        }

        private String zoneToString(Zone zone) {
            switch (zone) {
                case GYM:
                    return "тренажерный зал";
                case POOL:
                    return "бассейн";
                case GROUP:
                    return "групповые занятия";
                default:
                    return "";
            }
        }

        private boolean isRejectionReason(Abonnement abonnement, Zone zone) {
            if (abonnement.getExpirationDate().isBefore(LocalDate.now())) {
                return false;
            }

            if (isAbonnementRegistered(abonnement)) {
                return false;
            }

            if (zone == Zone.POOL && abonnement.getType().equals("Дневной") ) {
                return false;
            }

            if (zone == Zone.GROUP && abonnement.getType().equals("Разовый")) {
                return false;
            }
            if ((LocalTime.now().isBefore(LocalTime.of(8,00))
                    || LocalTime.now().isAfter(LocalTime.of(16,00)))
                    && abonnement.getType().equals("Дневной")){
                return false;
            }
            if (LocalTime.now().isBefore(LocalTime.of(8,00))
                    || LocalTime.now().isAfter(LocalTime.of(22,00))){
                return false;
            }
            return true;
        }
        private String getRejectionReason(Abonnement abonnement, Zone zone) {
            if (abonnement.getExpirationDate().isBefore(LocalDate.now())) {
                return "срок абонемента истек";
            }

            if (isAbonnementRegistered(abonnement)) {
                return "абонемент уже зарегистрирован в одной из зон";
            }

            if (zone == Zone.POOL && abonnement.getType().equals("Дневной") ) {
                return "доступ в бассейн не разрешен по дневному абонементу";
            }

            if (zone == Zone.GROUP && abonnement.getType().equals("Разовый")) {
                return "доступ на групповые занятия по разовому абонементу недоступен";
            }
            if ((LocalTime.now().isBefore(LocalTime.of(8,00))
                    || LocalTime.now().isAfter(LocalTime.of(16,00)))
                    && abonnement.getType().equals("Дневной")){
                return "В это время по дневному абонементу нет посещений";
            }
            if (LocalTime.now().isBefore(LocalTime.of(8,00))
                    || LocalTime.now().isAfter(LocalTime.of(22,00))){
                return "В это время нет посещений";
            }
            return "неизвестная причина";
        }

        public void printCurrentAbonnements() {
            System.out.println("Посетители тренажерного зала:");
            for (Abonnement gymAbonnement : gymAbonnements) {
                if (gymAbonnement != null) {
                    System.out.println(gymAbonnement.getOwner().getLastName() + " " +
                            gymAbonnement.getOwner().getFirstName());
                    System.out.println("Дата и время посещения: " + LocalDate.now() + " " + LocalTime.now());
                }
            }

            System.out.println("Посетители бассейна:");
            for (Abonnement poolAbonnement : poolAbonnements) {
                if (poolAbonnement != null) {
                    System.out.println(poolAbonnement.getOwner().getLastName() + " " +
                            poolAbonnement.getOwner().getFirstName());
                    System.out.println("Дата и время посещения: " + LocalDate.now() + " " + LocalTime.now());
                }
            }

            System.out.println("Посетители групповых занятий:");
            for (Abonnement groupAbonnement : groupAbonnements) {
                if (groupAbonnement != null) {
                    System.out.println(groupAbonnement.getOwner().getLastName() + " " +
                            groupAbonnement.getOwner().getFirstName());
                    System.out.println("Дата и время посещения: " + LocalDate.now() + " " + LocalTime.now());
                }
            }
        }
}
