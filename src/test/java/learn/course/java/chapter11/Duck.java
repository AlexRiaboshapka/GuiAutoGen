package learn.course.java.chapter11;

import logger.CustomLogger;

public class Duck extends Animal {
    @Override
    public void makeSound() {
        CustomLogger.logger.info("Duck sound");
    }
}
