package com.itmo.project.lesson10.staticmodifier;

public final /*sealed*/ /*non-sealed*/ class AppAuth implements Auth {
    // класс имплементирующий sealed должен быть либо final либо сам sealed c определенным набором наследнико
    // либо non-sealed
    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
