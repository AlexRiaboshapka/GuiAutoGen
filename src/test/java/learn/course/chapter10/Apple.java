package learn.course.chapter10;

import logger.CustomLogger;

public class Apple extends Fruit {

    public Apple() {
        setCalories(300);
    }

    public void takeSeedsOut() {
        CustomLogger.logger.info("Seeds are out");
    }

    @Override
    public void makeJuice() {
        CustomLogger.logger.info("Apple juice");
    }
}
