package org.example.duke.choice;

public class Customer {
    private final String name;
    Clothing[] items;

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

    public void getCustomerInfo () {
        System.out.println("Customer: " + name);
        System.out.println("Items:");
        for (Clothing item : items) {
            System.out.println(item.getDescription() + " , " + item.getPrice() + " , " + item.getSize());
        }
    }

    public double getTotalPrice (double tax) {
        double totalPrice = 0;
        for (Clothing item : items) {
            totalPrice += item.getPrice();
        }
        totalPrice += totalPrice * tax;
        return totalPrice;
    }

}
