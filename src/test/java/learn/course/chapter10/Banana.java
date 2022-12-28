package learn.course.chapter10;

import logger.CustomLogger;

public class Banana extends Fruit {
    public Banana() {
        setCalories(350);
    }

    public void peel() {
        CustomLogger.logger.info("Peel off");
    }

    @Override
    public void makeJuice() {
        CustomLogger.logger.info("Banana Juice");
    }
}
