import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> personRecords = new ArrayList<>();
        boolean addMore = true;

        System.out.println("Welcome to the Person Generator!");
        System.out.println("Enter person details (ID, FirstName, LastName, Title, YearOfBirth).\n");

        while (addMore) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g., Mr., Mrs., Dr., etc.)");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1940, 2010);

            personRecords.add(new Person(firstName, lastName, id, title, yearOfBirth));

            addMore = SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to save the data (e.g., PersonTestData.txt)");

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Person person : personRecords) {
                writer.write(person.toCSV() + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Thank you for using the Person Generator!");
    }
}