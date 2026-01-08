package date;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConferanceSchegualer {
    public static void main(String[] args) {
        ZonedDateTime conferenceZonedDateTime = ZonedDateTime.of(2025, 1, 16, 10, 30, 0, 0, ZonedDateTime.now().getZone());
        String[] participantsTimeZones = {
            "Europe/Paris",
            "America/New_York",
            "Europe/London",
            "Asia/Tokyo",
            "Australia/Sydney",
            "Asia/Novosibirsk"
        };
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy HH:mm");
        System.out.println("\nConference time in different time zones:");
        for (String timeZone : participantsTimeZones) {
            ZonedDateTime participantTime = conferenceZonedDateTime.withZoneSameInstant(java.time.ZoneId.of(timeZone));
            System.out.println("Conference time in " + timeZone + ": " + participantTime.format(formatter));
        }

    }
    
}
