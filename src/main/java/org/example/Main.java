package org.example;

import org.example.duke.choice.Customer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Customer c1 = new Customer("Pinky");
        greedCustomer(c1);
    }

    static void greedCustomer(Customer customer){
        System.out.println("Hello " + customer.getName());
    }
}
