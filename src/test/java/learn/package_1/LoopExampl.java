package learn.package_1;

public class LoopExampl {
    public static void main(String[] args) {
        Loop1:
        for (int i = 1; i <= 5; i++) {
            System.out.println("Loop1:! " + i);
            for (int a = 1; a <= 5; a++) {
                System.out.println("Loop2:* " + a);
                for (int b = 1; b <= 5; b++) {
                    System.out.println("Loop3: " + b);
                }
                if (a >= 2 && i == 2) {
                    break Loop1;
                }
            }
        }
    }
}
