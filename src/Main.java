import java.util.Random;
import java.util.Scanner;

class RockPaperScissorsGame {
    private final int rounds;
    private int playerScore;
    private int computerScore;

    public RockPaperScissorsGame(int rounds) {
        this.rounds = rounds;
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Rock, Paper, Scissors game!");

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);

            System.out.print("Your choice (1 - Rock, 2 - Scissors, 3 - Paper): ");
            int playerChoice = scanner.nextInt();

            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;
            displayChoices(playerChoice, computerChoice);

            int result = determineWinner(playerChoice, computerChoice);

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

        displayFinalResults(playerName);
    }

    private void displayChoices(int playerChoice, int computerChoice) {
        System.out.print("Your choice: ");
        displayChoice(playerChoice);
        System.out.print("Computer's choice: ");
        displayChoice(computerChoice);
    }

    private void displayChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Rock");
                break;
            case 2:
                System.out.println("Scissors");
                break;
            case 3:
                System.out.println("Paper");
                break;
        }
    }

    private int determineWinner(int playerChoice, int computerChoice) {
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

    private void displayFinalResults(String playerName) {
        System.out.println("\nGame over!");
        System.out.println("Results:");
        System.out.println(playerName + ": " + playerScore);
        System.out.println("Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println(playerName + " wins the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie in the game!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rounds: ");
        int rounds = scanner.nextInt();

        RockPaperScissorsGame game = new RockPaperScissorsGame(rounds);
        game.playGame();
    }
}
