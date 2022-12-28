package learn.course.java.chapter10;

import logger.CustomLogger;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        CustomLogger.logger.info("Cat sound");
    }

    public void scratch() {
        CustomLogger.logger.info("scratch is fun");
    }
}
