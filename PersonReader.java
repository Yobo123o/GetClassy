import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a Person Data File");
        int fileSelection = chooser.showOpenDialog(null);

        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            ArrayList<Person> personRecords = new ArrayList<>();

            try (Scanner fileScanner = new Scanner(selectedFile)) {
                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "FirstName", "LastName", "Title", "YOB");
                System.out.println("============================================================");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",\s*");

                    if (data.length == 5) {
                        Person person = new Person(data[1], data[2], data[0], data[3], Integer.parseInt(data[4]));
                        personRecords.add(person);
                        System.out.printf("%-10s %-15s %-15s %-10s %-5s%n",
                                person.getID(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYOB());
                    } else {
                        System.out.println("Invalid data format in line: " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("The selected file was not found: " + e.getMessage());
            }
        } else {
            System.out.println("No file was selected. Exiting program.");
        }
    }
}
