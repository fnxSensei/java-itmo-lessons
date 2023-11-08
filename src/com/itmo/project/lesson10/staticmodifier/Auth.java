package com.itmo.project.lesson10.staticmodifier;

public sealed interface Auth // sealed - ограничение ( заблокирован)
permits GAuth, AppAuth { // permits - Разрешение ( от интерфейса будут
    // имплементироваться только GAuth, AppAuth)
    boolean login(String username, String password);
    boolean logout();

    static Auth getAuth(String authType){
        Auth auth;
        if (authType.equals("github")){
            auth= new GAuth();
        }else {
            auth= new AppAuth();
        }
        return auth;
    }
}
