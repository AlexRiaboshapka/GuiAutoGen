package package_1;

public class Class2 {
    private static String var1 = "a";

    public static void method01(String text) {
        var1 = var1 + text;
        System.out.println(var1 + " new text added from class2");
    }
}
