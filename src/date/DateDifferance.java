package date;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateDifferance {
    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.of(1985, 11, 6, 12, 0);
        LocalDateTime endDateTime = LocalDateTime.now();
        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println("\nDifference between " + startDateTime + " and " + endDateTime + ":"
            + "\nDays: " + duration.toDays()
            + "\nHours: " + duration.toHours()
            + "\nMinutes: " + duration.toMinutes()
            + "\nSeconds: " + duration.getSeconds()
        );
    }
    
}
