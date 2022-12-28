package learn.course.java.chapter11;

import logger.CustomLogger;

public class Pig extends Animal {
    @Override
    public void makeSound() {
        CustomLogger.logger.info("Pig sound");
    }
}
