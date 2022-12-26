package learn.course;

import logger.CustomLogger;

import java.util.Scanner;

public class CourseTest {
    // 1. read hours worked
    // 2. read hourly rate
    // 3. calculate gross pay
    // 4. print gross pay
    // 5. print net pay
    // 6. print tax
    // 7. print hours worked
    // 8. print hourly rate
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursWorked = scanner.nextInt();
        double hourlyRate = scanner.nextDouble();
        double grossPay = hoursWorked * hourlyRate;
        double tax = grossPay / 10;
        double netPay = grossPay - tax;
        CustomLogger.logger.info("Gross pay: " + grossPay);
        CustomLogger.logger.info("Net pay: " + netPay);
    }


}
