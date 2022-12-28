package learn.course.java.chapter11;

import logger.CustomLogger;

public abstract class Shape {
    abstract double calculateArea();

    public void print() {
        CustomLogger.logger.info("Print from abstract class");
    }
}
