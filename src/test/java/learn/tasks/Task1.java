package learn.tasks;

public class Task1 {
    public static void main(String[] args) {
        printStars1();
        printStars2();
    }

    public static void printStars1() {
        int i, y, row = 9;
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
        int i, j, row = 10;
        for (i = 0; i < row; i++) {
            for (j = i; j >= 0; j--) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
        for (i = 0; i < (row - 1); i++) {
            for (j = (row - 1); j > i; j--) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }

    }
}
