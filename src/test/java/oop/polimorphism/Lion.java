package oop.polimorphism;

public class Lion extends Animal {
    @Override
    public void run() {
        System.out.println("Run Lion");
    }
}

class Cheetah extends Animal {
    @Override
    public void run() {
        System.out.println("Run Cheetah");
    }
}

class Tiger extends Animal {
    @Override
    public void run() {
        System.out.println("Run Tiger");
    }
}
