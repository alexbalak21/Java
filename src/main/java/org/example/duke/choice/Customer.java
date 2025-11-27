package org.example.duke.choice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final String name;
    private final Clothing[] items;

    public Customer(String name) {
        this.name = name;
        items = new Clothing[3];
    }

    public void addItem(Clothing item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }
    public List<Clothing> getItems() {
        return Collections.unmodifiableList(Arrays.asList(items));
    }

    public void getCustomerInfo () {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Items:");
        for (Clothing item : items) {
            System.out.println(item);
        }
    }

    public double getTotalPrice(double tax) {
        double totalPrice = 0;
        for (Clothing item : items) {
            totalPrice += item.getPrice();
        }
        totalPrice += totalPrice * tax;

        // Round to 2 decimal places
        return Math.round(totalPrice * 100.0) / 100.0;
    }

    public double getAverageOfSize (char size) {
        double total = 0;
        int sizeCount = 0;
        for (Clothing item : items) {
            sizeCount += item.getSize() == size ? 1 : 0;
            total += item.getPrice();
        }
        try{
            return total / sizeCount;
        } catch (ArithmeticException e) {
            return 0;
        }

    }

}
