package org.example;

import org.example.duke.choice.Clothing;
import org.example.duke.choice.Customer;

import java.util.Random;

public class Main {
    void main() {
        final double TAX = 0.2;
        double total = 0;
        Clothing[] items = new Clothing[10];
        items[0] = new Clothing("Blue Jacket", 20.9, 'M');
        items[1] = new Clothing("Orange T-shirt", 10.5, 'S');
        items[2] = new Clothing("Red Hat", 15.9, 'L');
        items[3] = new Clothing("Blue T-shirt", 12.5, 'M');
        items[4] = new Clothing("Black Hat", 18.9, 'L');
        items[5] = new Clothing("Green T-shirt", 14.5, 'S');
        items[6] = new Clothing("Black Jacket", 25.9, 'M');
        items[7] = new Clothing("Red T-shirt", 16.5, 'L');
        items[8] = new Clothing("Blue Hat", 22.9, 'S');
        items[9] = new Clothing("Green Jacket", 28.5, 'M');

        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Doe");
        Customer customer3 = new Customer("Bob Smith");

        customerAddsItems(customer1, items);
        customerAddsItems(customer2, items);
        customerAddsItems(customer3, items);

        customer1.getCustomerInfo();
        System.out.println("Total: " + customer1.getTotalPrice(TAX));
        customer2.getCustomerInfo();
        System.out.println("Total: " + customer2.getTotalPrice(TAX));
        customer3.getCustomerInfo();
        System.out.println("Total: " + customer3.getTotalPrice(TAX));

        }


    private static void customerAddsItems(Customer customer, Clothing[] items) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(items.length);
            customer.addItem(items[randomIndex]);
        }
    }
}


