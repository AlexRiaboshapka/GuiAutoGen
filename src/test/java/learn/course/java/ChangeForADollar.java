package learn.course.java;

import logger.CustomLogger;

import java.util.Scanner;

public class ChangeForADollar {
    public static void main(String[] args) {
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int pennie = 1;
        int total = 0;
        int change = 100;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            double input = scanner.nextInt();
            switch ((int) input) {
                case 25:
                    total += quarter;
                    break;
                case 10:
                    total += dime;
                    break;
                case 5:
                    total += nickel;
                    break;
                case 1:
                    total += pennie;
                    break;
                default:
                    CustomLogger.logger.info("Invalid input");
                    break;
            }
            if (total < change) {
                CustomLogger.logger.info("You have " + total + " cents. You need " + (change - total) + " more money.");
            } else if (change == total) {
                CustomLogger.logger.info("You have " + total + " cents. You win");
                break;
            } else {
                CustomLogger.logger.info("You have " + total + " cents. You need " + (total - change) + " less money to win.");
                break;
            }
        }
    }
}