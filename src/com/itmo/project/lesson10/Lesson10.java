package com.itmo.project.lesson10;

import com.itmo.project.lesson10.animals.Wolf;
import com.itmo.project.lesson10.clonequals.Item;
import com.itmo.project.lesson10.clonequals.Order;
import com.itmo.project.lesson10.staticmodifier.Auth;

import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {
//        Item item01 = new Item("Карандаш",320);
//        Item item02 = new Item("Карандаш",320);
//
//        System.out.println(item01.toString());
//        System.out.println(item01==item02);//false
//        System.out.println(item01.equals(item02));
//        //Item item03 = new Item("Ручка",490);
//        Order order01= new Order(new Item[]{item01, item02});
//        Order order02= new Order(new Item[]{item01, item02});
//        //order.getItems()[0]=item03
//        Order copy = order01.clone();
//        System.out.println(copy == order01); // false
//        System.out.println(copy.getItems() == order01.getItems()); // true
//
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Имя пользователя");
//        String username = scanner.nextLine();
//
//        System.out.println("Пароль");
//        String password = scanner.nextLine();
//
//        System.out.println("Способ авторизации");
//        String authType = scanner.nextLine(); // github, app
//        Auth auth = Auth.getAuth(authType);
////        if (authType.equals("github")){
////            auth= new GAuth();
////        }else {
////            auth= new AppAuth();
////        }
//        auth.login(username, password);

        Wolf wolf01=new Wolf(12, new String[]{"Мясо", "Рыба"}, "Серый");
        Wolf wolf02=new Wolf(12, new String[]{"Мясо", "Рыба"}, "Серый");
        System.out.println(wolf01.equals(wolf02));


    }
}
