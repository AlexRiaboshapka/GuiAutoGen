package package_2;

public class Test5 {
    public static void main(String[] args) {
        transferTypeAndPrint("Test", 12345);
        transferTypeAndPrint2("5", 10);

    }

    public static void transferTypeAndPrint(String text, int num) {
        String a = text;
        String b = String.valueOf(num);
        System.out.println("a:" + a + "\n" + "b:" + b);
    }

    public static void transferTypeAndPrint2(String text, int num) {
        int a = Integer.valueOf(text);
        int b = num;
        int c = a + b;
        System.out.println("int a + b: " + a + b);
        System.out.println("int a + b: " + c);
    }
}
