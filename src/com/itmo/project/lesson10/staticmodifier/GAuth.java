package com.itmo.project.lesson10.staticmodifier;

import com.itmo.project.lesson10.staticmodifier.Auth;

public final class  GAuth implements Auth {
    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
