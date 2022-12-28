package learn.course.java;

import logger.CustomLogger;

import java.util.Scanner;

public class ChangeForADollar2 {
    public static void main(String[] args) {
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        int total;
        int change = 100;
        CustomLogger.logger.info("Enter the number of quarters: ");
        Scanner scanner = new Scanner(System.in);
        quarters = scanner.nextInt();
        CustomLogger.logger.info("Enter the number of dimes: ");
        dimes = scanner.nextInt();
        CustomLogger.logger.info("Enter the number of nickels: ");
        nickels = scanner.nextInt();
        CustomLogger.logger.info("Enter the number of pennies: ");
        pennies = scanner.nextInt();
        total = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        if (total < change) {
            CustomLogger.logger.info("You have " + total + " cents. You need " + (change - total) + " more money to win.");
        } else if (change == total) {
            CustomLogger.logger.info("You have " + total + " cents. You win");
        } else {
            CustomLogger.logger.info("You have " + total + " cents. You need " + (total - change) + " less money to win.");
        }
    }
}
