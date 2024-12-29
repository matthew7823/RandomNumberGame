import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int lives = 3;
        int points = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Rules:");
        System.out.println("1. Guess a number between 1 and 100.");
        System.out.println("2. You have 10 guesses per round.");
        System.out.println("3. If you guess correctly within 10 guesses, you gain a point.");
        System.out.println("4. If you fail to guess correctly within 10 guesses, you lose a life.");
        System.out.println("5. The game ends when you lose all your lives. Good luck!");

        while (lives > 0) {
            int randomNum = (int) (Math.random() * 100) + 1; // 1 to 100
            int guesses = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nA new number has been generated. Start guessing!");

            while (guesses < 10) {
                System.out.print("Enter your guess: ");
                int input = scr.nextInt();

                // Validate input range
                if (input < 1 || input > 100) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    continue;
                }

                guesses++;

                if (input > randomNum) {
                    System.out.println("Lower...");
                } else if (input < randomNum) {
                    System.out.println("Higher...");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    points++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all 10 guesses. You lost a life!");
                lives--;
            }

            System.out.println("Current Score: " + points + " | Lives Remaining: " + lives);
        }

        System.out.println("\nGame Over! Your final score is: " + points);
        scr.close();
    }
}

