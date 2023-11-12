package com.itmo.project.lesson15;

import java.util.*;

public class FruitsStorage {
    private int numbersOfLots;

    private ArrayList<Fruit> fruits=new ArrayList<>();

    public FruitsStorage(int numbersOfLots) {
        this.numbersOfLots = numbersOfLots;
    }

    // фрукты добавляются в хранилище по следующим правилам:
    // * fruit не может быть null
    // * fruit не может быть ссылкой на существующий элемент коллекции
    // * если в коллекции fruits уже есть фрукт с типом и ценой, как у fruit,
    //   увеличивать значение свойства count фрукта коллекции на значение свойства count
    //   добавляемого фрукта. В противном случае добавлять fruit в коллекцию fruits.
    //   numberOfSlots уменьшается на значение count добавляемого фрукта.
    // * в хранилище нельзя добавить больше numberOfSlots фруктов

    public boolean addToStorage(Fruit fruit){
        Objects.requireNonNull(fruit, "fruit не может быть null"); //проверка на null
        if (fruits.size()>numbersOfLots) return false;
        for (int i=0; i<fruits.size(); i++ ) {
            if(fruits.get(i)==fruit) return false;
            if (fruits.get(i).equals(fruit)){
                fruits.get(i).setCount(fruit.getCount());
                return true;
            } else {
                fruits.add(fruit);
                numbersOfLots-=fruit.getCount();
                return true;
            }
        }
        return false;
    }

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        int countFruitsByType = 0;
        for (Fruit fruit : fruits) {
            if (fruitType.equals(fruit.getType())){
                countFruitsByType+=fruit.getCount();
            }
        }
        return countFruitsByType;
    }
    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots(){
        return numbersOfLots-fruits.size();
    }
    public void increasePrice(int value){
        // value может быть в диапазоне [10; 30)
        // увеличить цену всех фруктов на value процентов
        if (value<10||value>29) {
            System.out.println("value может быть в диапазоне [10; 30)");
            return;
        }else {
            for (int i=0; i<fruits.size(); i++ ) {
                double priceFruit = fruits.get(i).getPrice();
                double percent = priceFruit+((priceFruit*value)/100);
                fruits.get(i).setPrice(percent);
            }
        }
    }
    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной, fruitType не null
        // возвращает список, в который войдут фрукты из коллекции fruits
        // с типом fruitType и ценой не выше maxPrice
        if (maxPrice<1) {
            System.out.println("maxPrice должна быть положительной");
            return null;
        }
        Objects.requireNonNull(fruitType, "fruitype не может быть null");
        List<Fruit> fruitsByTypeAndPrice = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            if(fruits.get(i).getType().equals(fruitType)&& fruits.get(i).getPrice()<=maxPrice){
                fruitsByTypeAndPrice.add(fruits.get(i));
            }
        }
        return fruitsByTypeAndPrice;
    }
    public Set<Fruit.FruitType> getFruitTypes(){
        // возвращает ссылку на множество с типами фруктов в хранилище
        Set<Fruit.FruitType> fruitTypes = new HashSet<>();
        for (int i = 0; i < fruits.size(); i++) {
            fruitTypes.add(fruits.get(i).getType());
        }
        return fruitTypes;
    }
    public double getMinPriceByType(Fruit.FruitType fruitType){
        // вернуть минимальную цену фрукта с типом fruitType
        double minPriceByType = Double.MAX_VALUE;
        for (int i = 0; i < fruits.size(); i++) {
            if(fruits.get(i).getType().equals(fruitType)){
                if(fruits.get(i).getPrice()<minPriceByType){
                    minPriceByType=fruits.get(i).getPrice();
                }
            }
        }
        return minPriceByType;
    }
}
