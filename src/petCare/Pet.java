// Task 1: The Object blueprint classes - Pet class
// Grading: Provide the code that creates the Pet Class. (5 points)
package petCare;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a pet in the pet care scheduler system.
 * Encapsulates pet details including unique ID, personal information, owner details,
 * registration date, and a list of associated appointments.
 */
public class Pet {
    private int id;
    private String name;
    private String species_breed;
    private int age;
    private String owner_name;
    private String owner_contact_info;
    private LocalDate registration_date;
    private ArrayList<Appointment> appointments;

    /**
     * Constructs a new Pet with the specified details.
     * Registration date is set to the current date, and appointments list is initialized empty.
     *
     * @param id the unique identifier for the pet
     * @param name the name of the pet
     * @param species_breed the species or breed of the pet
     * @param age the age of the pet in years
     * @param owner_name the name of the pet's owner
     * @param owner_contact_info the contact information of the pet's owner
     */
    public Pet(int id, String name, String species_breed, int age, String owner_name, String owner_contact_info) {
        this.id = id;
        this.name = name;
        this.species_breed = species_breed;
        this.age = age;
        this.owner_name = owner_name;
        this.owner_contact_info = owner_contact_info;
        this.registration_date = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    /**
     * Gets the unique ID of the pet.
     *
     * @return the pet's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the pet.
     *
     * @return the pet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the species or breed of the pet.
     *
     * @return the pet's species or breed
     */
    public String getSpecies_breed() {
        return species_breed;
    }

    /**
     * Gets the age of the pet.
     *
     * @return the pet's age in years
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the name of the pet's owner.
     *
     * @return the owner's name
     */
    public String getOwner_name() {
        return owner_name;
    }

    /**
     * Gets the contact information of the pet's owner.
     *
     * @return the owner's contact info
     */
    public String getOwner_contact_info() {
        return owner_contact_info;
    }

    /**
     * Gets the registration date of the pet.
     *
     * @return the registration date
     */
    public LocalDate getRegistration_date() {
        return registration_date;
    }

    /**
     * Gets the list of appointments for the pet.
     *
     * @return the list of appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Adds an appointment to the pet's list.
     *
     * @param appointment the appointment to add
     */
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    /**
     * Sets the unique ID of the pet.
     *
     * @param id the new ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the species or breed of the pet.
     *
     * @param species_breed the new species or breed
     */
    public void setSpecies_breed(String species_breed) {
        this.species_breed = species_breed;
    }

    /**
     * Sets the age of the pet.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the name of the pet's owner.
     *
     * @param owner_name the new owner name
     */
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    /**
     * Sets the contact information of the pet's owner.
     *
     * @param owner_contact_info the new contact info
     */
    public void setOwner_contact_info(String owner_contact_info) {
        this.owner_contact_info = owner_contact_info;
    }

    /**
     * Sets the registration date of the pet.
     *
     * @param registration_date the new registration date
     */
    public void setRegistrationDate(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    /**
     * Sets the list of appointments for the pet.
     *
     * @param appointments the new list of appointments
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }


    /**
     * Returns a string representation of the pet.
     *
     * @return a string containing all pet details
     */
    @Override
    public String toString() {
        return "Pet {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species_breed='" + species_breed + '\'' +
                ", age=" + age +
                ", owner_name='" + owner_name + '\'' +
                ", owner_contact_info='" + owner_contact_info + '\'' +
                ", registration_date=" + registration_date +
                ", appointments=" + appointments +
                '}';
    }
}
