package learn.course.java.chapter10;

import logger.CustomLogger;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        CustomLogger.logger.info("Dog sound");
    }

    public void fetch() {
        CustomLogger.logger.info("Fetch is fun");
    }
}
