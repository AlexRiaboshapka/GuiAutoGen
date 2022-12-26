package learn.course;

import logger.CustomLogger;

import java.util.Scanner;

public class Chapter5 {
    // Phone bill calculator
    // Calculate the total of a phone bill
    // Allow the operator to input the plan fee and the number of overage minutes.
    // Charge 0.25 for every minute that exceeds the plan minutes and 15% tax on the subtotal.
    // Create separate methods to calculate the tax, overage fees, and final total.
    // Print the itemized bill.
    static double planFee = 0;
    static double overageMinutes = 0;
    static double overageFeePerMinute = 0.25;
    static double taxRate = 0.15;
    static double overageFee = 0;
    static double taxFee = 0;
    static double totalFeeWithTax = 0;
    static Scanner scanner = new Scanner(System.in);

    public static double calculateTax(double subtotal) {
        return (subtotal * taxRate);
    }

    public static double calculateOverage(double overageMinutes) {
        return overageMinutes * overageFeePerMinute;
    }

    public static double calculateTotal(double subtotal, double tax, double overage) {
        return subtotal + tax + overage;
    }

    public static void getFee() {
        planFee = scanner.nextDouble();
    }

    public static void getOverageMinutes() {
        overageMinutes = scanner.nextDouble();
    }

    public static void main(String[] args) {
        CustomLogger.logger.info("Enter base cost of the plan: ");
        getFee();
        CustomLogger.logger.info("Enter overage minutes: ");
        getOverageMinutes();
        scanner.close();
        CustomLogger.logger.info("Phone Bill Statement:");
        CustomLogger.logger.info("Plan: $" + planFee);
        CustomLogger.logger.info("Overage: $" + overageFee);
        taxFee = calculateTax(planFee + overageFee);
        CustomLogger.logger.info("Tax: $" + taxFee);
        totalFeeWithTax = calculateTotal(planFee, taxFee, overageFee);
        CustomLogger.logger.info("Total: $" + totalFeeWithTax);
    }
}
