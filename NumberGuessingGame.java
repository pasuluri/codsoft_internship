import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game! Try to guess a number between 1 and 100.");
            int randomNumber = random.nextInt(100) + 1;
            int userGuess = 0;

            while (userGuess != randomNumber) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            System.out.println("You took " + attempts + " attempts to guess the number. Your score is " + score + ".");
            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}