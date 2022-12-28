package learn.course.java.chapter11;

public class Farm {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.makeSound();
        duck.eat();

        Pig pig = new Pig();
        pig.makeSound();
        pig.eat();
    }
}
