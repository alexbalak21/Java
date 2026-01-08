// Task 1: The Object blueprint classes - Appointment class
// Grading: Provide the code for the appointment class. (4 points)
// Grading: Select the best option for handling the appointment date and time in the Appointment Class. (1 point) - LocalDateTime
// Grading: Specify which class you use to specify the requested date and time format. (2 points) - DateTimeFormatter
package petCare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an appointment for a pet in the pet care scheduler.
 * Includes the type of appointment, scheduled date and time, and optional notes.
 */
public class Appointment {
    private String type;
    private LocalDateTime dateTime;
    private String notes;

    /**
     * Constructs a new Appointment with the specified type, date/time, and notes.
     *
     * @param type the type of appointment (e.g., vet visit, grooming)
     * @param dateTime the date and time of the appointment
     * @param notes optional notes about the appointment
     */
    public Appointment(String type, LocalDateTime dateTime, String notes) {
        this.type = type;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    /**
     * Constructs a new Appointment with the specified type and date/time, with empty notes.
     *
     * @param type the type of appointment
     * @param dateTime the date and time of the appointment
     */
    public Appointment(String type, LocalDateTime dateTime) {
        this(type, dateTime, "");
    }

    /**
     * Gets the type of the appointment.
     *
     * @return the appointment type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the date and time of the appointment.
     *
     * @return the appointment date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets the notes for the appointment.
     *
     * @return the appointment notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the type of the appointment.
     *
     * @param type the new appointment type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the date and time of the appointment.
     *
     * @param dateTime the new date and time
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Sets the notes for the appointment.
     *
     * @param notes the new notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns a string representation of the appointment with formatted date/time.
     *
     * @return a formatted string of the appointment details
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return "Appointment{" +
                "type='" + type + '\'' +
                ", dateTime='" + formattedDateTime + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}