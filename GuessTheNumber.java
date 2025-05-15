import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    private static final int MAX_POINTS_PER_ROUND = 100;
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int totalScore = 0;
    
    public static void main(String[] args) {
        System.out.println("=== WELCOME TO GUESS THE NUMBER ===");
        System.out.println("Try to guess the number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts per round");
        System.out.println("There are " + MAX_ROUNDS + " rounds in total");
        System.out.println("Good luck!\n");
        
        String playerName = getPlayerName();
        
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            playRound(round, playerName);
        }
        
        displayFinalResults(playerName);
    }
    
    private static String getPlayerName() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();
        
        // Use a default name if the user doesn't enter anything
        if (name.isEmpty()) {
            name = "Player";
        }
        
        System.out.println("\nHello, " + name + "! Let's begin.");
        return name;
    }
    
    private static void playRound(int round, String playerName) {
        int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attemptsLeft = MAX_ATTEMPTS;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("\n=== ROUND " + round + " ===");
        System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        
        while (attemptsLeft > 0 && !hasGuessedCorrectly) {
            System.out.println("\nAttempts left: " + attemptsLeft);
            System.out.print("Enter your guess: ");
            
            int userGuess;
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }
            
            if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                System.out.println("Your guess should be between " + MIN_NUMBER + " and " + MAX_NUMBER);
                continue;
            }
            
            attemptsLeft--;
            
            if (userGuess == targetNumber) {
                hasGuessedCorrectly = true;
                int roundScore = calculateScore(MAX_ATTEMPTS - attemptsLeft);
                totalScore += roundScore;
                
                System.out.println("\n🎉 CONGRATULATIONS! You've guessed the number correctly!");
                System.out.println("The number was: " + targetNumber);
                System.out.println("You used " + (MAX_ATTEMPTS - attemptsLeft) + " attempts");
                System.out.println("Round score: " + roundScore + " points");
                
            } else {
                String hint = userGuess < targetNumber ? "higher" : "lower";
                System.out.println("Not quite! The number is " + hint + " than your guess.");
            }
        }
        
        if (!hasGuessedCorrectly) {
            System.out.println("\nOut of attempts! The number was: " + targetNumber);
            System.out.println("Round score: 0 points");
        }
        
        // Display current total score
        System.out.println("Current total score: " + totalScore + " points");
        
        // Pause before the next round
        if (round < MAX_ROUNDS) {
            System.out.println("\nPress Enter to continue to the next round...");
            scanner.nextLine();
        }
    }
    
    private static int calculateScore(int attemptsTaken) {
        // Score calculation: The fewer attempts used, the higher the score
        // If solved in 1 attempt: MAX_POINTS_PER_ROUND
        // If solved in MAX_ATTEMPTS: MIN_SCORE_PER_ROUND (which is 10)
        
        if (attemptsTaken == 0) {
            return MAX_POINTS_PER_ROUND;  // Perfect score for immediate guess
        }
        
        int minScorePerRound = 10;
        int scoreRange = MAX_POINTS_PER_ROUND - minScorePerRound;
        
        // Linear score calculation based on attempts taken
        return (int) (MAX_POINTS_PER_ROUND - ((double) attemptsTaken / MAX_ATTEMPTS) * scoreRange);
    }
    
    private static void displayFinalResults(String playerName) {
        System.out.println("\n=== FINAL RESULTS ===");
        System.out.println("Player: " + playerName);
        System.out.println("Total Score: " + totalScore + " points");
        
        // Display achievement based on score
        int maxPossibleScore = MAX_ROUNDS * MAX_POINTS_PER_ROUND;
        double percentageScore = (double) totalScore / maxPossibleScore * 100;
        
        System.out.println("Performance: " + String.format("%.1f", percentageScore) + "%");
        
        String achievement;
        if (percentageScore >= 90) {
            achievement = "MASTER GUESSER";
        } else if (percentageScore >= 70) {
            achievement = "SKILLED PLAYER";
        } else if (percentageScore >= 50) {
            achievement = "GOOD EFFORT";
        } else if (percentageScore >= 30) {
            achievement = "NOVICE";
        } else {
            achievement = "BEGINNER";
        }
        
        System.out.println("Achievement: " + achievement);
        
        System.out.println("\nThank you for playing Guess the Number!");
        System.out.println("=== GAME OVER ===");
    }
}