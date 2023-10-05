import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
        
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess a number within the valid range.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Higher! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Lower! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
            }
        }
        
        scanner.close();
    }
}
