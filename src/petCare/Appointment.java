// Task 1: The Object blueprint classes - Appointment class
// Grading: Provide the code for the appointment class. (4 points)
// Grading: Select the best option for handling the appointment date and time in the Appointment Class. (1 point) - LocalDateTime
// Grading: Specify which class you use to specify the requested date and time format. (2 points) - DateTimeFormatter
package petCare;

import java.time.LocalDateTime;

public class Appointment {
    private String type;
    private LocalDateTime dateTime;
    private String notes;

     public Appointment(String type, LocalDateTime dateTime, String notes) {
        this.type = type;
        this.dateTime = dateTime;
        this.notes = notes;
    }

     public Appointment(String type, LocalDateTime dateTime) {
        this(type, dateTime, "");
    }

    public String getType() {
        return type;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getNotes() {
        return notes;
    }
}