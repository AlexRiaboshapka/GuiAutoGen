package learn.course.java.chapter10;

import logger.CustomLogger;

public class Zoo {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.makeSound();
        dog1.fetch();
        feed(dog1);
        Animal momo = new Dog();
        momo.makeSound();
        feed(momo);
        momo = new Cat();
        momo.makeSound();
        ((Cat) momo).scratch();
        feed(momo);


    }

    public static void feed(Animal animal) {
        if (animal instanceof Dog) {
            CustomLogger.logger.info("Dog food");
        } else if (animal instanceof Cat) {
            CustomLogger.logger.info("Cat food");
        }
    }
}
