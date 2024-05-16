package NumberGameq;
import java.util.Scanner;
import java.util.Random;

public class NumberGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int minRange = 1;
		int maxRange = 100;
		int attemptsLimit = 5;
		int score = 0;

		System.out.println("Welcome to the Number Game!");

		while (true) {
			int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
			System.out.println("I have generated a number between " + minRange + " and " + maxRange + ". Guess the number!");

			for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
				System.out.print("Attempt " + attempts + ": ");
				int userGuess = scanner.nextInt();

				if (userGuess == randomNumber) {
					System.out.println("Congratulations! You guessed the number!");
					score += attemptsLimit - attempts + 1;
					break;
				} else if (userGuess < randomNumber) {
					System.out.println("Too low! Try again.");
				} else {
					System.out.println("Too high! Try again.");
				}

				if (attempts == attemptsLimit) {
					System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
				}
			}

			System.out.print("Do you want to play again? (yes/no): ");
			String playAgain = scanner.next().toLowerCase();

			if (!playAgain.equals("yes")) {
				System.out.println("Thanks for playing! Your total score is: " + score);
				break;
			}
		}

		scanner.close();
	}
}
