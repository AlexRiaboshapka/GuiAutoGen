package learn.tasks;

public class Task3 {
    // Написать метод с параметрами и проверкой в теле,
    // что если результат умножения параметров друг на друга равняется 100,
    // то запустить цикл с 5 итерациями, в которых в первой итерации
    // выводится результат деления первого параметра на второй,
    // а в остальных итерациях результат деления результата с первой
    // итерации на второй параметр.
    // Если результат умножения параметров друг на друга НЕ равняется 100
    // , то выводить в консоль сообщение, что цикл запущен не будет.
    public static void main(String[] args) {
        task3(50,2);
    }
    public static void task3(int a, int b) {
        if (a * b == 100) {
            for (int i = 0; i < 5; i++) {
                int result1 = a / b;
                int result2;
                if (i != 0) {
                    result2 = result1 / b;
                    System.out.println("Print a/b: " + result2);
                } else {
                    System.out.println("Print a/b: " + result1);
                }
            }
        } else {
            System.out.println("Input is not equals to 100 skipp cycle");
        }
    }
}
