import java.util.Scanner;

// This is the main class responsible for starting the game and collecting user input.
public class Main {
    public static void main(String[] args) {
        // Create a new Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message to the user
        System.out.println("Welcome to the Rock Paper Scissors game!");

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Prompt the user for the number of rounds they'd like to play
        System.out.print("Enter the number of rounds: ");
        int rounds = InputHelper.getIntInput(scanner);

        // Create a new game instance with the desired rounds and player name
        RockPaperScissorsGame game = new RockPaperScissorsGame(rounds, playerName);

        // Start the game
        game.playGame(scanner);
    }
}