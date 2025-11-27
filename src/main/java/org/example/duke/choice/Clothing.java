package org.example.duke.choice;


public class Clothing implements Comparable<Clothing> {
    private final String description;
    private final double price;
    private final char size;
    final int measurement;

    public Clothing(String description, double price, char size) {
        this.description = description;
        this.price = price;
        this.size = size;
        switch (size) {
            case 'S':
                measurement = 1;
                break;
            case 'L':
                measurement = 3;
                break;
            default:
                measurement = 2;
        }
    }

    public  Clothing (String description, double price) {
        this.description = description;
        this.price = price;
        this.size = 'M';
        measurement = 2;
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

    public String toString() {
        return description + " , " + price + " , " + size;
    }

    public int compare (Object o1, Object o2) {
        return 0;
    }

    public int compareTo(Clothing other) {
        // Example: compare by price
        return Double.compare(this.price, other.price);
    }

}


