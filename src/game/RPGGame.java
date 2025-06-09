package game;

import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Hero and Enemy
        Character hero = new Character("Hero", 100, 20);
        Character enemy = new Character("Goblin", 50, 15);

        System.out.println("Welcome to the RPG Battle!");
        System.out.println(hero.name + " vs " + enemy.name + "\n");

        // Battle loop
        while (hero.health > 0 && enemy.health > 0) {
            System.out.println("Press Enter to attack!");
            scanner.nextLine(); // Wait for user input

            hero.attack(enemy);
            if (enemy.health > 0) {
                enemy.attack(hero);
            }

            // Check if hero is defeated
            if (hero.health <= 0) {
                System.out.println("Game Over! " + hero.name + " has been defeated.");
            }
        }

        scanner.close();
    }
}
