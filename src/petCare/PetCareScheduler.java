// Task 2: The main application
// Grading: Specify the which class processes user input. (3 points) - PetCareScheduler
// Grading: Provide the code that handles user choices. (3 points) - runMenu method
package petCare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The main application class for the Pet Care Scheduler.
 * Manages pets and appointments, provides a console-based menu for user interactions,
 * loads and saves data from/to files.
 */
public class PetCareScheduler {

    private HashMap<Integer, Pet> pets = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * The main entry point of the application.
     * Creates an instance of PetCareScheduler and starts it.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        PetCareScheduler scheduler = new PetCareScheduler();
        scheduler.start();
    }

    /**
     * Starts the application by loading data, running the menu, and saving data on exit.
     */
    public void start() {
        loadData();
        runMenu();
        saveData();
    }

    // Task 2: Load Data - Load any existing data from the files, when the application starts up.
    // Grading: Provide the code that addresses loading data from a file. (4 points)
    /**
     * Loads pets and appointments from files at application startup.
     */
    private void loadData() {
        pets = DataLoader.loadPets();
        DataLoader.loadAppointments(pets);
        System.out.println("Data loaded successfully.");
    }

    // Store data - Save pet profiles and appointment records to files
    /**
     * Saves pets and appointments to files when the application exits.
     */
    private void saveData() {
        DataLoader.savePets(pets);
        DataLoader.saveAppointments(pets);
        System.out.println("Data saved.");
    }

    //Take and Process user input - Take user input and process it to perform one of the allowed operations
    /**
     * Displays the main menu and processes user choices in a loop.
     * Allows users to register pets, schedule appointments, display data, generate reports, or exit.
     * Continues until the user selects exit.
     */
    private void runMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- PetCare Scheduler ---");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display All Pets");
            System.out.println("4. Display Appointments for a Pet");
            System.out.println("5. Display Upcoming Appointments");
            System.out.println("6. Display Past Appointments");
            System.out.println("7. Generate Reports");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    displayPets();
                    break;
                case "4":
                    displayAppointmentsForPet();
                    break;
                case "5":
                    displayUpcomingAppointments();
                    break;
                case "6":
                    displayPastAppointments();
                    break;
                case "7":
                    generateReports();
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Register the pet - Create new pet profiles
    // Grading: Provide the code that handles pet registration. (3 points)
    /**
     * Prompts the user to enter pet details and registers a new pet.
     * Validates ID uniqueness, name, species, age, owner name, and contact info.
     */
    private void registerPet() {
        System.out.print("Enter pet ID (unique integer): ");
        int id = 0;
        while (true) {
            String idInput = scanner.nextLine();
            try {
                id = Integer.parseInt(idInput);
                if (pets.containsKey(id)) {
                    System.out.print("ID already exists. Please enter a unique ID: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a numeric ID: ");
            }
        }
        System.out.print("Enter pet name: ");
        String name = "";
        while (true) {
            name = scanner.nextLine().trim();
            if (name.isEmpty() || !name.matches("^[a-zA-Z\\s']+$")) {
                System.out.print("Invalid name. Please enter a name with only letters, spaces, and apostrophes: ");
                continue;
            }
            break;
        }
        System.out.print("Enter pet species/breed: ");
        String species = "";
        while (true) {
            species = scanner.nextLine().trim();
            if (species.isEmpty() || !species.matches("^[a-zA-Z\\s'-]+$")) {
                System.out.print("Invalid species/breed. Please enter with only letters, spaces, hyphens, and apostrophes: ");
                continue;
            }
            break;
        }
        System.out.print("Enter pet age: ");
        int age = 0;
        while (true) {
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (age < 0) {
                    System.out.print("Age cannot be negative. Please enter a valid age: ");
                    continue;
                }
                break; // valid → exit loop
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a numeric age: ");
            }

        }
        System.out.print("Enter owner name: ");
        String owner = "";
        while (true) {
            owner = scanner.nextLine().trim();
            if (owner.isEmpty()) {
                System.out.print("Owner name cannot be empty. Please enter a valid owner name: ");
                continue;
            }
            break;
        }
        System.out.print("Enter owner contact info: ");
        String contact = scanner.nextLine().trim();

        Pet pet = new Pet(id, name, species, age, owner, contact);
        pets.put(pet.getId(), pet);
        System.out.println("Pet registered successfully with ID: " + pet.getId());
    }

    // Schedule an appointment - Allow users to schedule appointments for a pet
    // Grading: Provide the code that handles appointment scheduling. (4 points)
    /**
     * Prompts the user to schedule an appointment for a pet.
     * Validates pet ID, appointment type, future date/time, and checks for conflicts.
     */
    private void scheduleAppointment() {
        System.out.print("Enter pet ID: ");
        int petId = 0;
        while (true) {
            String idInput = scanner.nextLine();
            try {
                petId = Integer.parseInt(idInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid ID. Please enter a numeric ID: ");
            }
        }

        if (!pets.containsKey(petId)) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.print("Enter appointment type: ");
        String type = "";
        while (true) {
            type = scanner.nextLine().trim();
            if (type.isEmpty()) {
                System.out.print("Appointment type cannot be empty. Please enter a valid type: ");
                continue;
            }
            break;
        }

        LocalDateTime appointmentDateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.print("Enter appointment date and time (YYYY-MM-DD HH:MM): ");
            String dateTimeInput = scanner.nextLine();

            try {
                appointmentDateTime = LocalDateTime.parse(dateTimeInput, formatter);
                LocalDateTime now = LocalDateTime.now();
                if (appointmentDateTime.isBefore(now)) {
                    System.out.println("Cannot schedule appointments in the past. Please enter a future date and time.");
                    continue;
                }
                // Check if the date/time is already taken for this pet
                boolean conflict = false;
                for (Appointment existing : pets.get(petId).getAppointments()) {
                    if (existing.getDateTime().equals(appointmentDateTime)) {
                        conflict = true;
                        break;
                    }
                }
                if (conflict) {
                    System.out.println("This date and time is already booked for this pet. Please choose a different time.");
                    continue;
                }
                break; // valid → exit loop
            } catch (Exception e) {
                System.out.println("Invalid date/time format. Please try again.");
            }
        }

        System.out.print("Enter notes (optional): ");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(type, appointmentDateTime, notes);
        pets.get(petId).addAppointment(appointment);

        System.out.println("Appointment scheduled successfully!");
    }

    // Display the records - All registered pets
    /**
     * Displays all registered pets.
     */
    private void displayPets() {
        for (Pet pet : pets.values()) {
            System.out.println(pet);
        }
    }

    // Display the records - All appointments for a specific pet
    /**
     * Prompts for a pet ID and displays all appointments for that pet.
     */
    private void displayAppointmentsForPet() {
        System.out.print("Enter pet ID to view appointments: ");
        int petId = 0;
        while (true) {
            String idInput = scanner.nextLine();
            try {
                petId = Integer.parseInt(idInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid ID. Please enter a numeric ID: ");
            }
        }
        if (!pets.containsKey(petId)) {
            System.out.println("Pet not found.");
            return;
        }
        Pet pet = pets.get(petId);
        System.out.println("Appointments for " + pet.getName() + ":");
        for (Appointment appt : pet.getAppointments()) {
            System.out.println(" - Type: " + appt.getType() + ", Date/Time: " + appt.getDateTime() + ", Notes: " + appt.getNotes());
        }
    }

    /**
     * Displays all upcoming appointments for all pets.
     */
    private void displayUpcomingAppointments() {
        System.out.println("Upcoming Appointments:");
        LocalDateTime now = LocalDateTime.now();
        boolean hasUpcoming = false;
        for (Pet pet : pets.values()) {
            for (Appointment appt : pet.getAppointments()) {
                if (appt.getDateTime().isAfter(now)) {
                    System.out.println("Pet: " + pet.getName() + " - Type: " + appt.getType() + ", Date/Time: " + appt.getDateTime() + ", Notes: " + appt.getNotes());
                    hasUpcoming = true;
                }
            }
        }
        if (!hasUpcoming) {
            System.out.println("No upcoming appointments.");
        }
    }

    /**
     * Displays past appointment history for each pet.
     */
    private void displayPastAppointments() {
        System.out.println("Past Appointments:");
        LocalDateTime now = LocalDateTime.now();
        for (Pet pet : pets.values()) {
            System.out.println("Pet: " + pet.getName());
            boolean hasPast = false;
            for (Appointment appt : pet.getAppointments()) {
                if (appt.getDateTime().isBefore(now)) {
                    System.out.println(" - Type: " + appt.getType() + ", Date/Time: " + appt.getDateTime() + ", Notes: " + appt.getNotes());
                    hasPast = true;
                }
            }
            if (!hasPast) {
                System.out.println("  No past appointments.");
            }
        }
    }

    // Generate reports - Produce simple reports
    // Grading: Provide the code that generates reports based on the project requirements. (3 points)
    private void generateReports() {
        System.out.println("--- Reports ---");
        System.out.println("1. Pets with upcoming appointments in the next week");
        System.out.println("2. Pets overdue for a vet visit");
        System.out.print("Choose a report: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                reportUpcomingWeek();
                break;
            case "2":
                reportOverdueVet();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Generates a report of pets with upcoming appointments in the next week.
     */
    private void reportUpcomingWeek() {
        System.out.println("Pets with upcoming appointments in the next week:");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusWeeks(1);
        boolean hasAny = false;
        for (Pet pet : pets.values()) {
            boolean hasUpcoming = false;
            for (Appointment appt : pet.getAppointments()) {
                if (appt.getDateTime().isAfter(now) && appt.getDateTime().isBefore(nextWeek)) {
                    if (!hasUpcoming) {
                        System.out.println("Pet: " + pet.getName());
                        hasUpcoming = true;
                        hasAny = true;
                    }
                    System.out.println(" - " + appt.getType() + " on " + appt.getDateTime());
                }
            }
        }
        if (!hasAny) {
            System.out.println("No pets with upcoming appointments in the next week.");
        }
    }

    /**
     * Generates a report of pets overdue for a vet visit (no vet visit in the last 6 months).
     */
    private void reportOverdueVet() {
        System.out.println("Pets overdue for a vet visit (no vet visit in the last 6 months):");
        LocalDateTime sixMonthsAgo = LocalDateTime.now().minusMonths(6);
        boolean hasAny = false;
        for (Pet pet : pets.values()) {
            boolean hasVetVisit = false;
            for (Appointment appt : pet.getAppointments()) {
                if (appt.getType().equalsIgnoreCase("vet visit") && appt.getDateTime().isAfter(sixMonthsAgo)) {
                    hasVetVisit = true;
                    break;
                }
            }
            if (!hasVetVisit) {
                System.out.println(" - " + pet.getName() + " (Owner: " + pet.getOwner_name() + ")");
                hasAny = true;
            }
        }
        if (!hasAny) {
            System.out.println("No pets are overdue for a vet visit.");
        }
    }
}
