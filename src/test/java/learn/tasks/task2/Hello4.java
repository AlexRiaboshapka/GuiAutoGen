package learn.tasks.task2;

public class Hello4 implements HelloInterface{
    @Override
    public void printHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Hello4 hello = new Hello4();
        hello.printHello();
    }
}
