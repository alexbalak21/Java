package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy");

        System.out.println("");
        System.out.println("Current Date : " + currentDate.format(formatter));
        System.out.println("Current Date and Time: " + currentDateTime);
        System.out.println("Current Zoned Date and Time: " + currentZonedDateTime);
    }
}
