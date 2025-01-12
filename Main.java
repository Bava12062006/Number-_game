import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have a limited number of attempts to guess the number correctly.");

        while (playAgain) {
            int randomNumber = (int) (Math.random() * 100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round: I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                if (!scanner.hasNextInt()) {  // Validate user input
                    System.out.println("Please enter a valid number.");
                    scanner.next();  // Clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("You guessed it in " + attempts + " attempt(s).");
                    totalScore += (maxAttempts - attempts + 1) * 10;  // Scoring based on remaining attempts
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your total score so far is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
