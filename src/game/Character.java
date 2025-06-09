package game;

public class Character {
    String name;
    int health;
    int damage;

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    void attack (Character enemy){
        enemy.health = Math.max(enemy.health - this.damage, 0);
        System.out.println(name + " attacks " + enemy.name + " for " + damage + " damage!");

        // Display enemy's health after attack
        if (enemy.health > 0) {
            System.out.println(enemy.name + " now has " + enemy.health + " HP remaining.");
        } else {
            System.out.println(enemy.name + " has been defeated!");
        }
    }
}
