package petCare;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class DataLoader {

    private static final String PETS_FILE = "../pets.txt";
    private static final String APPOINTMENTS_FILE = "../appointments.txt";

    // Load pets from file - part of loading data
    /**
     * Loads pets from the pets file into a HashMap.
     * Parses each line, creates Pet objects, and sets their registration dates.
     * Skips invalid lines and handles exceptions gracefully.
     *
     * @return a HashMap of pets keyed by their ID
     */
    public static HashMap<Integer, Pet> loadPets() {
        HashMap<Integer, Pet> pets = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PETS_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                if (p.length < 7) continue;

                int id = Integer.parseInt(p[0]);
                String name = p[1];
                String species = p[2];
                int age = Integer.parseInt(p[3]);
                String owner = p[4];
                String contact = p[5];
                LocalDate regDate = LocalDate.parse(p[6]);

                Pet pet = new Pet(id, name, species, age, owner, contact);
                pet.setRegistrationDate(regDate);

                pets.put(id, pet);
            }

        } catch (IOException e) {
            System.out.println("Error loading pets: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error loading pets: " + e.getMessage());
        }

        return pets;
    }

    // Load appointments and attach them to pets - part of loading data
    /**
     * Loads appointments from the appointments file and attaches them to the corresponding pets.
     * Parses each line and adds appointments to pets if the pet exists.
     * Handles null pets map and exceptions gracefully.
     *
     * @param pets the HashMap of pets to attach appointments to
     */
    public static void loadAppointments(HashMap<Integer, Pet> pets) {
        if (pets == null) {
            System.out.println("Error: Pets map is null.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] a = line.split("\\|");
                if (a.length < 4) continue;

                int petId = Integer.parseInt(a[0]);
                String type = a[1];
                LocalDateTime dateTime = LocalDateTime.parse(a[2]);
                String notes = a[3];

                Appointment appt = new Appointment(type, dateTime, notes);

                if (pets.containsKey(petId)) {
                    pets.get(petId).addAppointment(appt);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading appointments: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error loading appointments: " + e.getMessage());
        }
    }

    // Save pets - part of storing data
    /**
     * Saves the pets from the HashMap to the pets file.
     * Writes each pet's details in pipe-separated format.
     * Handles null pets map and exceptions gracefully.
     *
     * @param pets the HashMap of pets to save
     */
    public static void savePets(HashMap<Integer, Pet> pets) {
        if (pets == null) {
            System.out.println("Error: Pets map is null.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PETS_FILE))) {
            for (Pet p : pets.values()) {
                bw.write(p.getId() + "|" +
                         p.getName() + "|" +
                         p.getSpecies_breed() + "|" +
                         p.getAge() + "|" +
                         p.getOwner_name() + "|" +
                         p.getOwner_contact_info() + "|" +
                         p.getRegistration_date());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving pets: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error saving pets: " + e.getMessage());
        }
    }

    // Save appointments - part of storing data
    /**
     * Saves the appointments for all pets to the appointments file.
     * Writes each appointment's details in pipe-separated format.
     * Handles null pets map and exceptions gracefully.
     *
     * @param pets the HashMap of pets whose appointments to save
     */
    public static void saveAppointments(HashMap<Integer, Pet> pets) {
        if (pets == null) {
            System.out.println("Error: Pets map is null.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(APPOINTMENTS_FILE))) {
            for (Pet p : pets.values()) {
                for (Appointment a : p.getAppointments()) {
                    bw.write(p.getId() + "|" +
                             a.getType() + "|" +
                             a.getDateTime() + "|" +
                             a.getNotes());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving appointments: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error saving appointments: " + e.getMessage());
        }
    }
}
