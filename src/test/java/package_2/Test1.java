package package_2;

public class Test1 {
    public static void main(String[] args) {
        String testValue = "Hello World";
        testValue.length();
        int x = 5;
        int y = 2;
        System.out.println(getResult(testValue));
        System.out.println(getCalcResult(x, y));
        System.out.println(getTextResult(testValue, x));

    }

    public static String getResult(String test) {
        return test + "!!!";
    }

    public static int getCalcResult(int x, int y) {
        int result;
        return result = x%y;
    }

    public static String getTextResult(String text, int x) {
        return text + " " + x;
    }
}