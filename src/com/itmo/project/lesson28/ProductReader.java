package com.itmo.project.lesson28;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductReader extends Thread{
    private List<Product> products;
    private File file; //Product in file - name::price::

    public ProductReader(List<Product> products, File file) {
        this.products = products;
        this.file = file;
    }

    @Override
    public void run() {
        List<Product> list = getProductsFromFile();
        synchronized (products) {
            products.addAll(list);
        }
    }

    private List<Product> getProductsFromFile() {
        try (Stream<String> stringStream = Files.lines(file.toPath())){
            return stringStream.map(s -> {
                String[] strings=s.split("::");
                return new Product(
                        strings[0],
                        Integer.parseInt(strings[1]),
                        Integer.parseInt(strings[2]));
            }).collect(Collectors.toList());
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
