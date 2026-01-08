package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth date (DD-MM-YYYY): ");
        String birthDate = scanner.nextLine();
        DateTimeFormatter input_Formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse(birthDate, input_Formatter);
        DateTimeFormatter output_Formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy");
        System.out.println("Your Birth Date was: " + birthday.format(output_Formatter));
        scanner.close();
    }
    
}
