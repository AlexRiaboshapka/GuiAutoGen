package tasks;

public class Task1 {
    public static void main(String[] args) {
        printStars1();
    }

    public static void printStars1() {
        int i, y, row=9;
        for (i = 0; i < row; i++) {
            for (y = 0; y <= i; y++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        int x, g;
        for (x = row; x >= 0; x--) {
            for (g = 0; g <= x; g++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void printStars2() {

    }
}
