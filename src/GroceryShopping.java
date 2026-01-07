import java.util.ArrayList;
import java.util.Scanner;

public class GroceryShopping {

    public static int searchItem(String[] items, String itemToFind) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(itemToFind)) {
                return i;
            }
        }
        return -1;
    }

    public static float calculateAveragePrice(float[] prices) {
        float total = 0;
        for (float price : prices) {
            total += price;
        }
        return total / prices.length;
    }

    public static void filterItemsBelowPrice(String[] items, float[] prices, float max) {
        for (short i = 0; i < items.length ; i++){
            if (prices[i] <= max) System.out.println(i + 1 + " : " + items[i] + " - " + prices[i] + " $");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = {
                "apples", "bananas", "bread", "milk", "eggs",
                "cheese", "chicken", "rice", "pasta", "tomatoes",
                "onions", "carrots", "potatoes", "yogurt", "butter",
                "cereal", "orange juice", "coffee", "tea", "lettuce",
                "cucumbers", "bell peppers", "ground beef", "salmon", "toilet paper"
        };

        float[] prices = {
                2.50f, 1.20f, 2.00f, 1.50f, 2.30f,
                3.80f, 5.50f, 1.00f, 1.20f, 2.10f,
                1.00f, 1.10f, 2.00f, 3.00f, 2.70f,
                3.50f, 3.20f, 4.50f, 2.80f, 1.40f,
                1.30f, 2.60f, 6.00f, 7.50f, 4.00f
        };

        float total = 0;
        ArrayList<String> cart = new ArrayList<>();
        for (short i = 0; i < items.length; i++) {
            System.out.println(i + 1 + " : " + items[i] + " - " + prices[i] + " $");
        }

        int itemIndex = 0;

        String input = "";
        do {
            System.out.println("Enter desired item or exit :");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                itemIndex = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equalsIgnoreCase("exit"))
                    System.out.println("Please enter an integer from the list.");
            }

            try {
                total += prices[itemIndex - 1];
                cart.add(items[itemIndex - 1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter an item from the list.");
            }

        } while (!input.equalsIgnoreCase("exit"));
        System.out.println("Items in your cart :");
        for (String item : cart)
            System.out.println(item);
        System.out.println("Your total is : " + total + " $");
        scanner.close();

        System.out.println("index of coffee : " + searchItem(items, "coffee"));
        System.out.println("avrage price of items : " + calculateAveragePrice(prices));
        filterItemsBelowPrice(items, prices, 2);
    }

}
