package org.example.duke.choice;

public class Clothing {
    private final String description;
    private final double price;
    private final char size;

    public Clothing(String description, double price, char size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public  Clothing (String description, double price) {
        this.description = description;
        this.price = price;
        this.size = 'M';
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public char getSize() {
        return size;
    }
}


