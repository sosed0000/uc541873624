import java.util.Scanner;

// This class provides utility methods for validating user input.
public class InputHelper {

    // Method to get an integer input from the user
    public static int getIntInput(Scanner scanner) {
        int input;
        do {
            // Ensure the user input is an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            input = scanner.nextInt();
            // Ensure the input is greater than 0
            if (input <= 0) {
                System.out.print("Invalid input. Please enter greater than 0");
            }
        } while (input <= 0);
        return input;
    }

    // Overloaded method to get an integer input from the user within a specified range
    public static int getIntInput(Scanner scanner, int min, int max) {
        int input;
        do {
            // Ensure the user input is an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            input = scanner.nextInt();
            // Ensure the input is within the specified range
            if (input < min || input > max) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
            }
        } while (input < min || input > max);
        return input;
    }
}