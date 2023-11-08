package com.itmo.project.lesson14;


//T компилируется в Object
public class User<T> {
    private T id;
    private String userName;

    public User(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


