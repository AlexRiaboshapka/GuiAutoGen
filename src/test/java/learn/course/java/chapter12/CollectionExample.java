package learn.course.java.chapter12;

import logger.CustomLogger;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        CustomLogger.logger.info("Set Demo");
        setDemo();
        CustomLogger.logger.info("Map Demo");
        mapDemo();
    }

    public static void setDemo() {
        Set<String> fruit = new HashSet<>();
        fruit.add("apple");
        fruit.add("lemon");
        fruit.add("banana");
        fruit.add("orange");
        fruit.add("lemon");
        CustomLogger.logger.info(fruit.size());
        CustomLogger.logger.info(fruit);
        Iterator<String> i = fruit.iterator();
        while (i.hasNext()) {
            CustomLogger.logger.info("Fruit: " + i.next());
        }

        for (String item : fruit) {
            CustomLogger.logger.info("Fruit: " + item);
        }

        fruit.forEach(x -> CustomLogger.logger.info("Fruit: " + x));
    }

    public static void mapDemo() {
        Map<String, Integer> fruitCalories = new HashMap<>();
        fruitCalories.put("apple", 95);
        fruitCalories.put("lemon", 5);
        fruitCalories.put("banana", 105);
        fruitCalories.put("orange", 45);
        fruitCalories.put("lemon", 17);
        CustomLogger.logger.info(fruitCalories.size());
        CustomLogger.logger.info(fruitCalories);
        for (Map.Entry<String, Integer> entry : fruitCalories.entrySet()) {
            CustomLogger.logger.info(entry.getValue());
        }
        fruitCalories.forEach((k, v) -> CustomLogger.logger.info("Key: " + k + " Value: " + v));
    }
}
