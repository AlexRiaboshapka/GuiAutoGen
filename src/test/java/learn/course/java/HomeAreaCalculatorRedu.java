package learn.course.java;

import logger.CustomLogger;

import java.util.Scanner;

public class HomeAreaCalculatorRedu {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HomeAreaCalculatorRedu calculator = new HomeAreaCalculatorRedu();
        Rectangle kitchen = calculator.getRoom();
        Rectangle bathroom = calculator.getRoom();
        double area = calculator.calculateTotalArea(kitchen, bathroom);
        CustomLogger.logger.info("The total area is: " + area);
        calculator.scanner.close();
    }

    Rectangle getRoom() {
        CustomLogger.logger.info("Enter the length of your room");
        double length = scanner.nextDouble();
        CustomLogger.logger.info("Enter the width of your room");
        double width = scanner.nextDouble();
        return new Rectangle(length, width);
    }

    public double calculateTotalArea(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.calculateArea() + rectangle2.calculateArea();
    }
}
