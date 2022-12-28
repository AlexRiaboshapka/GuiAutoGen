package learn.course.java.chapter11;

import logger.CustomLogger;

public class ShapeTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        CustomLogger.logger.info("Area of rectangle: " + rectangle.calculateArea());

        rectangle.print();
    }
}
