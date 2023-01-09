package learn.course.mix;

import logger.CustomLogger;

import java.util.Random;

public class Chapter4 {
    public static void main(String[] args) {
        // Roll the Die Game - 1
        // 1. Generate a random number between 1 and 6
        // 2. Ask the user to guess the number
        // 3. Compare the user's guess to the random number
        // 4. If the user's guess is correct, print "You win!"
        // 5. If the user's guess is incorrect, print "You lose!"
        // 6. Ask the user if they want to play again
        // 7. If the user enters "y", repeat the game
        // 8. If the user enters "n", end the game
        // 9. If the user enters anything else, print "Invalid input" and end the game
        int position = 0;
        int throw_hands = 5;
        int myNumber = 20;
        Random random = new Random();

        for (int i = 1; i <= throw_hands; i++) {
            int dice = random.nextInt(6) + 1;
            position += dice;
            CustomLogger.logger.info("Roll: " + i + " Dice: " + dice + " Position: " + position);
            if (position == myNumber) {
                CustomLogger.logger.info("You win!");
                break;
            } else if (position > myNumber) {
                CustomLogger.logger.info("You lose!");
                break;
            } else if (i == throw_hands && position < myNumber) {
                CustomLogger.logger.info("You lose!");
                break;
            } else {
                CustomLogger.logger.info("Roll again you are not there yet!");
                CustomLogger.logger.info("Roll again you are not there yet!");
            }
        }
    }
}
