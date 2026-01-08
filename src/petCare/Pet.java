// Task 1: The Object blueprint classes - Pet class
// Grading: Provide the code that creates the Pet Class. (5 points)
package petCare;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pet {
    private int id;
    private String name;
    private String species_breed;
    private int age;
    private String owner_name;
    private String owner_contact_info;
    private LocalDate registration_date;
    private ArrayList<Appointment> appointments;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies_breed() {
        return species_breed;
    }

    public int getAge() {
        return age;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getOwner_contact_info() {
        return owner_contact_info;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistrationDate(LocalDate registration_date) {
        this.registration_date = registration_date;
    }


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
