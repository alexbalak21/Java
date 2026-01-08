package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateExample {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("");
        System.out.println("Current Date : " + currentDate);
        System.out.println("Current Date and Time: " + currentDateTime);
        System.out.println("Current Zoned Date and Time: " + currentZonedDateTime);
    }
}
