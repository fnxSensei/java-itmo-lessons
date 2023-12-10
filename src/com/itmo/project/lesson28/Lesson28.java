package com.itmo.project.lesson28;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Lesson28 {
    public static void main(String[] args) {
        ProductStorage storage = new ProductStorage(
                new ArrayList<>(), 10
        );

        Runnable createProduktTask = () -> {
            int count=1;
            while (true){
                Product product = new Product(
                        "Product" + count,
                        (int) (Math.random() *1000),
                        (int) (Math.random() * 100)
                        );
                try {
                    storage.addProductToList(product);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        };

        Thread create01 = new Thread(createProduktTask);
        Thread create02 = new Thread(createProduktTask);
        create01.start();
        create02.start();




        List<Product> products = new ArrayList<>();

        ProductReader reader01 = new ProductReader(products, new File("file01.txt"));
        ProductReader reader02 = new ProductReader(products, new File("file02.txt"));
        ProductReader reader03 = new ProductReader(products, new File("file03.txt"));

        reader01.start();
        reader02.start();
        reader03.start();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(()->{
            synchronized (products) {
                System.out.println(products);
                products.clear();
            }
        }, 0, 10, TimeUnit.MINUTES);
    }

}
