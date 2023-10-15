import java.util.Random;
import java.util.Scanner;

// This class represents the Rock Paper Scissors game and contains game logic.
public class RockPaperScissorsGame {
    private final int rounds;
    private int playerScore;
    private int computerScore;
    private final String playerName;

    // Constructor for initializing the game
    public RockPaperScissorsGame(int rounds, String playerName) {
        this.rounds = rounds;
        this.playerScore = 0;
        this.computerScore = 0;
        this.playerName = playerName;
    }

    // This method contains the primary game loop
    public void playGame(Scanner scanner) {
        // Random object for generating computer choices
        Random random = new Random();

        // Game loop for each round
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);

            // Collect the player's choice
            System.out.print("Your choice (1 - Rock, 2 - Scissors, 3 - Paper): ");
            int playerChoice = InputHelper.getIntInput(scanner, 1, 3);

            // Generate a choice for the computer
            int computerChoice = random.nextInt(3) + 1;

            // Display the choices made by the player and the computer
            displayChoices(playerChoice, computerChoice);

            // Determine the winner of this round
            int result = determineWinner(playerChoice, computerChoice);

            // Display the result of this round
            if (result == 0) {
                System.out.println("It's a tie in this round.");
            } else if (result == 1) {
                System.out.println(playerName + " wins this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round.");
                computerScore++;
            }
        }

        // Once all rounds are played, display the final results
        displayFinalResults();
    }

    // Helper method to display both player's and computer's choices
    private void displayChoices(int playerChoice, int computerChoice) {
        System.out.print("Your choice: ");
        displayChoice(playerChoice);
        System.out.print("Computer's choice: ");
        displayChoice(computerChoice);
    }

    // Helper method to display a single choice (Rock/Scissors/Paper)
    private void displayChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.println("Rock");
            case 2 -> System.out.println("Scissors");
            case 3 -> System.out.println("Paper");
        }
    }

    // Method to determine the winner based on the choices
    private int determineWinner(int playerChoice, int computerChoice) {
        // If choices are the same, it's a tie
        if (playerChoice == computerChoice) {
            return 0; // Tie
        } else if ((playerChoice == 1 && computerChoice == 2) ||
                (playerChoice == 2 && computerChoice == 3) ||
                (playerChoice == 3 && computerChoice == 1)) {
            return 1; // Player wins
        } else {
            return -1; // Computer wins
        }
    }

    // Method to display final results after all rounds are played
    private void displayFinalResults() {
        System.out.println("\nGame over!");
        System.out.println("Results:");
        System.out.println(playerName + ": " + playerScore);
        System.out.println("Computer: " + computerScore);

        // Determine the overall game winner based on scores
        if (playerScore > computerScore) {
            System.out.println(playerName + " wins the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie in the game!");
        }
    }
}
