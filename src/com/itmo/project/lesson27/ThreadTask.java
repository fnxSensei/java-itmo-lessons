package com.itmo.project.lesson27;

import java.util.List;

public class ThreadTask extends Thread{
    private List<String> stringList;

    public ThreadTask(List<String> stringList) {
        this.stringList = stringList;
        System.out.println("Constructor " + Thread.currentThread().getName());
        //
        // this.setPriority(10);
        //this.setName("ThreadTask");
    }

    public void printList(){
        stringList.forEach(System.out::println);
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        printList();
    }
}
