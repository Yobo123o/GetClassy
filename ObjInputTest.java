import java.util.Scanner;

/**
 * ObjInputTest: A short program to test all SafeInputObj methods interactively.
 */
public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj(new Scanner(System.in));

        // Test getNonZeroLenString
        System.out.println("Testing getNonZeroLenString...");
        String nonEmptyString = input.getNonZeroLenString("Enter a non-empty string");
        System.out.println("You entered: " + nonEmptyString);

        // Test getRangedInt
        System.out.println("\nTesting getRangedInt...");
        int rangedInt = input.getRangedInt("Enter an integer between 1 and 10", 1, 10);
        System.out.println("You entered: " + rangedInt);

        // Test getRangedDouble
        System.out.println("\nTesting getRangedDouble...");
        double rangedDouble = input.getRangedDouble("Enter a decimal between 1.0 and 10.0", 1.0, 10.0);
        System.out.println("You entered: " + rangedDouble);

        // Test getYNConfirm
        System.out.println("\nTesting getYNConfirm...");
        boolean ynConfirm = input.getYNConfirm("Do you agree?");
        System.out.println("You answered: " + (ynConfirm ? "Yes" : "No"));

        // Test getRegExString
        System.out.println("\nTesting getRegExString...");
        String regExString = input.getRegExString("Enter a valid email", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        System.out.println("You entered a valid email: " + regExString);

        System.out.println("\nAll methods tested successfully.");
    }
}

