package learn.oop.polimorphism;

public class Main {
    static Aibolit aibolit = new Aibolit();
    static Lion lion = new Lion();
    static Cheetah cheetah = new Cheetah();
    static Tiger tiger = new Tiger();

    public static void main(String[] args) {
        aibolit.heal(lion);
        aibolit.heal(cheetah);
        aibolit.heal(tiger);
    }
}
