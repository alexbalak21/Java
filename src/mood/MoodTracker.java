package mood;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Task 3
        ArrayList<Mood> moods = new ArrayList<>(); // Task 4

        System.out.println("Welcome to the Mood Tracker App!");

        while (true) { // Task 5
            System.out.println("\nMenu:");
            System.out.println("a - Add mood");
            System.out.println("e - Edit mood notes");
            System.out.println("d - Delete mood");
            System.out.println("s - Search mood");
            System.out.println("l - List all moods");
            System.out.println("w - Write moods to file");
            System.out.println("exit - Exit app");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toLowerCase(); // Task 7

            if (choice.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case "a":
                    addMood(scanner, moods);
                    break;

                case "e":
                    editNotes(scanner, moods);
                    break;

                case "d":
                    deleteMenu(scanner, moods);
                    break;

                case "s":
                    searchMenu(scanner, moods);
                    break;

                case "l":
                    listAll(moods);
                    break;

                case "w":
                    writeToFile(moods);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // ---------------------- TASK 8: ADD MOOD ----------------------
    private static void addMood(Scanner scanner, ArrayList<Mood> moods) {
        try {
            System.out.print("Enter mood name: ");
            String name = scanner.nextLine();

            System.out.print("Enter date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter time (HH:MM): ");
            LocalTime time = LocalTime.parse(scanner.nextLine());

            // Validation: no duplicate mood at same date+time
            for (Mood m : moods) {
                if (m.getDate().equals(date) && m.getTime().equals(time)) {
                    throw new Exception("A mood already exists at this date and time.");
                }
            }

            System.out.print("Enter notes: ");
            String notes = scanner.nextLine();

            moods.add(new Mood(name, date, time, notes));
            System.out.println("Mood added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding mood: " + e.getMessage());
        }
    }

    // ---------------------- TASK 9: EDIT NOTES ----------------------
    private static void editNotes(Scanner scanner, ArrayList<Mood> moods) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter time (HH:MM): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        for (Mood m : moods) {
            if (m.getDate().equals(date) && m.getTime().equals(time)) {
                System.out.print("Enter new notes: ");
                m.setNotes(scanner.nextLine());
                System.out.println("Notes updated!");
                return;
            }
        }

        System.out.println("Mood not found.");
    }

    // ---------------------- TASK 10 & 11: DELETE ----------------------
    private static void deleteMenu(Scanner scanner, ArrayList<Mood> moods) {
        System.out.println("Delete by:");
        System.out.println("1 - Date");
        System.out.println("2 - Name + Date + Time");
        System.out.print("Choose: ");

        String option = scanner.nextLine();

        if (option.equals("1")) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            moods.removeIf(m -> m.getDate().equals(date));
            System.out.println("Deleted all moods for that date.");

        } else if (option.equals("2")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter time (HH:MM): ");
            LocalTime time = LocalTime.parse(scanner.nextLine());

            Iterator<Mood> it = moods.iterator();
            while (it.hasNext()) {
                Mood m = it.next();
                if (m.getName().equalsIgnoreCase(name)
                        && m.getDate().equals(date)
                        && m.getTime().equals(time)) {
                    it.remove();
                    System.out.println("Mood deleted.");
                    return;
                }
            }

            System.out.println("Mood not found.");
        }
    }

    // ---------------------- TASK 12 & 13: SEARCH ----------------------
    private static void searchMenu(Scanner scanner, ArrayList<Mood> moods) {
        System.out.println("Search by:");
        System.out.println("1 - Date");
        System.out.println("2 - Name + Date + Time");
        System.out.print("Choose: ");

        String option = scanner.nextLine();

        if (option.equals("1")) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            moods.stream()
                    .filter(m -> m.getDate().equals(date))
                    .forEach(System.out::println);

        } else if (option.equals("2")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter time (HH:MM): ");
            LocalTime time = LocalTime.parse(scanner.nextLine());

            for (Mood m : moods) {
                if (m.getName().equalsIgnoreCase(name)
                        && m.getDate().equals(date)
                        && m.getTime().equals(time)) {
                    System.out.println(m);
                    return;
                }
            }

            System.out.println("Mood not found.");
        }
    }

    // ---------------------- TASK 14: LIST ALL ----------------------
    private static void listAll(ArrayList<Mood> moods) {
        if (moods.isEmpty()) {
            System.out.println("No moods recorded.");
            return;
        }

        moods.forEach(System.out::println);
    }

    // ---------------------- TASK 15: WRITE TO FILE ----------------------
    private static void writeToFile(ArrayList<Mood> moods) {
        try (FileWriter writer = new FileWriter("moodtracker.txt")) {
            for (Mood m : moods) {
                writer.write(m.toString() + "\n");
            }
            System.out.println("Moods written to moodtracker.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
