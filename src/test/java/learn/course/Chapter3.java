package learn.course;

import logger.CustomLogger;

import java.util.Scanner;

public class Chapter3 {

    public static void main(String[] args) {
        // Salary Calculator
        /* IF Statement
         * Sales salary 1000 give bonus 250 for sales > 10
         */

        // Initialize known values
        int salary = 1000;
        int bonus = 250;
        int quota = 10;

        // Get values for the unknown
        CustomLogger.logger.info("Enter sales: ");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        // Quick detour for the bonus earners
        if (sales > quota) {
            salary = salary + bonus;
        }
        // Output
        CustomLogger.logger.info("Salary is: " + salary);
    }
}
