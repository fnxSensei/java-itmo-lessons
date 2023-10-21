package com.itmo.project.lesson10.clonequals;

import java.util.Arrays;

public class Order {
    private final Item[] items;

    public Order(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    // + переопределенные методы equals и hashCode
    // ПКМ -> Generate -> equals() + hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }
@Override
    public Order clone(){
        Item[] items1 = new Item[items.length];
    for (int i = 0; i < items1.length; i++) {
        items1[i]=items[i].clone();
    }
    return new Order(items1);
}

}

