package learn.tasks.task5;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    /*
    * "Написать программу, которая будет выводить в консоль двумерный массив с квадратными скобками в таком порядке,
    *  как показано в примере. Программа должна выводить в консоль фразу ""Enter the size: ""
    * и ждать ввода от пользователя. Введённое значение должно определять размер массивов как показано в примере.

Output ->

Enter the size: 3

[[5, 4, 3],

[6, 9, 2],

[7, 8, 1]]

    * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\"Enter the size: \"");
        int a = in.nextInt();
        int[][] two = new int[a][a];
        System.out.println("a: " + a);
        int i = a - 1;
        int j = a - 1;
        int value = 1;
        for (; i > 0; i--) {
            for (; j>0;j--){
                two[j][i] = value;
                value++;
            }
            two[j][i] = value;
            value++;
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            buf.append("[]");
            return;
        }
        System.out.println(Arrays.deepToString(two));
        //printSpiral(a);
    }

    public static void printSpiral(int size) {

        // Create row and col
        // to traverse rows and columns
        int row = 0, col = 0;

        int boundary = size - 1;
        int sizeLeft = size - 1;
        int flag = 1;

        // Variable to determine the movement
        // r = right, l = left, d = down, u = upper
        char move = 'l';

        // Array for matrix
        int matrix[][] = new int[size][size];

        for (int i = 1; i < size * size + 1; i++) {

            // Assign the value
            matrix[row][col] = i;

            // switch-case to determine the next index
            switch (move) {

                // If right, go right
                case 'r':
                    col += 1;
                    break;

                // if left, go left
                case 'l':
                    col -= 1;
                    break;

                // if up, go up
                case 'u':
                    row -= 1;
                    break;

                // if down, go down
                case 'd':
                    row += 1;
                    break;
            }

            // Check if the matrix
            // has reached array boundary
            if (i == boundary) {

                // Add the left size for the next boundary
                boundary += sizeLeft;

                // If 2 rotations has been made,
                // decrease the size left by 1
                if (flag != 2) {

                    flag = 2;
                } else {

                    flag = 1;
                    sizeLeft -= 1;
                }

                // switch-case to rotate the movement
                switch (move) {

                    // if right, rotate to down
                    case 'r':
                        move = 'd';
                        break;

                    // if down, rotate to left
                    case 'd':
                        move = 'l';
                        break;

                    // if left, rotate to up
                    case 'l':
                        move = 'u';
                        break;

                    // if up, rotate to right
                    case 'u':
                        move = 'r';
                        break;
                }
            }
        }

        // Print the matrix
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {

                int n = matrix[row][col];
                System.out.print((n < 10) ? (n + " ")
                        : (n + " "));
            }

            System.out.println();
        }
    }

}
