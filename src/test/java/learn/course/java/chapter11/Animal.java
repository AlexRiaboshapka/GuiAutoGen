package learn.course.java.chapter11;

import logger.CustomLogger;

public abstract class Animal {
    public abstract void makeSound();

    public void eat() {
        CustomLogger.logger.info("Animal eat");
    }
}
