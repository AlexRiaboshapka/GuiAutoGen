package learn.course.mix;

import logger.CustomLogger;

public class PhoneBill {
    // Phone bill calculator
    // Calculate the total of a phone bill
    // Allow the operator to input the plan fee and the number of overage minutes.
    // Charge 0.25 for every minute that exceeds the plan minutes and 15% tax on the subtotal.
    // Create separate methods to calculate the tax, overage fees, and final total.
    // Print the itemized bill.

    private int id;
    private double baseCost;
    private int allowedMinutes;
    private int minutesUsed;

    PhoneBill() {
        id = 0;
        baseCost = 50;
        allowedMinutes = 100;
        minutesUsed = 10;
    }

    PhoneBill(int id) {
        this.id = id;
        baseCost = 50;
        allowedMinutes = 100;
        minutesUsed = 10;
    }

    PhoneBill(int id, double baseCost, int allowedMinutes, int minutesUsed) {
        this.id = id;
        this.baseCost = baseCost;
        this.allowedMinutes = allowedMinutes;
        this.minutesUsed = minutesUsed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public int getAllowedMinutes() {
        return allowedMinutes;
    }

    public void setAllowedMinutes(int allowedMinutes) {
        this.allowedMinutes = allowedMinutes;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    public double calculateOverage() {
        if (minutesUsed < allowedMinutes) {
            return 0;
        }
        double overageFeePerMinute = 0.25;
        double overageMinutes = minutesUsed - allowedMinutes;
        return overageMinutes * overageFeePerMinute;
    }

    public double calculateTax() {
        double taxRate = 0.15;
        return taxRate * (baseCost + calculateOverage());
    }

    public double calculateTotal() {
        return baseCost + calculateOverage() + calculateTax();
    }

    public void printItemizedBill() {
        CustomLogger.logger.info("ID: " + id);
        CustomLogger.logger.info("Base Rate: $" + baseCost);
        CustomLogger.logger.info("Overage Fee: $"
                + String.format("%.2f", calculateOverage()));
        CustomLogger.logger.info("Tax: $"
                + String.format("%.2f", calculateTax()));
        CustomLogger.logger.info("Total: $"
                + String.format("%.2f", calculateTotal()));
    }
}
