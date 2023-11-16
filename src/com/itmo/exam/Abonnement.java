package com.itmo.exam;

import java.time.LocalDate;

class Abonnement {
    private String type;
    private int number;
    private LocalDate registrationDate;
    private LocalDate expirationDate;
    private Owner owner;

    public Abonnement(int number, LocalDate registrationDate, LocalDate expirationDate) {
        this.number = number;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
    }

    public Abonnement(String type, int number, LocalDate registrationDate, LocalDate expirationDate, Owner owner) {
        this.type=type;
        this.number = number;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
        this.owner=owner;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
