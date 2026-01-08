import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        readFile();
        writeFile();
    }

    public static void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            System.out.println("\nContents of the file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try (Scanner scanner = new Scanner(System.in);
                BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true))) {
                System.out.println("Write something to the file:");
                String input = scanner.nextLine();
                writer.write(input);
                writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
