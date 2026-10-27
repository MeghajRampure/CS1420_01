package lab09;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random generator = new Random();
        Scanner userInput = new Scanner(System.in);
        int secretNumber = generator.nextInt(100) + 1;

        int turnCounter = 0;

        while (turnCounter < 10) {
            int playerGuess = validateInput(userInput);

            if (playerGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the secret number.");
                break;
            }
            else if  (secretNumber > playerGuess) {
                System.out.println("You guessed too low");
            }
            else{
                System.out.println("You guessed too high");
            }
            turnCounter++;
            if (turnCounter == 10) {
                System.out.println("You ran out of guesses.");
            }


        }

    }

    private static int validateInput(Scanner userInput) {
        System.out.println("Please enter a number between 1 and 100");
        int guess = userInput.nextInt();
        while (guess < 1 || guess > 100) {
            System.out.println("Please enter a number between 1 and 100");
            guess = userInput.nextInt();
        }
        return guess;

    }


}
