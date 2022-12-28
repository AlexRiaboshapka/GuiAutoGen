package learn.course.java.chapter10;

import logger.CustomLogger;

public class Fruit {
    private double calories;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void makeJuice() {
        CustomLogger.logger.info("Juice is made");
    }

    public void printCalories() {
        CustomLogger.logger.info("Juice calories: " + calories);
    }
}
