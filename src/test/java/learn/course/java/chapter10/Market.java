package learn.course.java.chapter10;

import logger.CustomLogger;

public class Market {
    public static void main(String[] args) {
        Fruit banana = new Banana();
        ((Banana) banana).peel();

        Apple apple = new Apple();
        apple.takeSeedsOut();

        squeeze(banana);
        squeeze(apple);

    }

    public static void squeeze(Fruit fruit) {
        CustomLogger.logger.info("Squeezing...");
        fruit.makeJuice();
        fruit.printCalories();
    }
}
