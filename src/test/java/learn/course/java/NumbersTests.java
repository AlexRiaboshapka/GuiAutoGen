package learn.course.java;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersTests {

    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static void main(String[] args) {
        highAndLow("1 2 3 4 5");
        highAndLow2("1 2 3 4 5");
        solution("abcdef");
        countBits(1234);
    }

    public static String highAndLow(String numbers) {
        // Code here or
        String num1 = numbers.replaceAll(" ", "");
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            intList.add(Integer.parseInt(num1.substring(i, i + 1)));

        }
        String max = String.valueOf(Collections.max(intList));
        String min = String.valueOf(Collections.min(intList));
        return max + " " + min;
    }

    public static String highAndLow2(String numbers) {
        String[] strings = numbers.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String string : strings) {
            int value = Integer.parseInt(string);
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        return max + " " + min;
    }

    public static String[] solution(String s) {
        int length = s.length();
        boolean oddStatus = false;
        if (length % 2 == 1) {
            oddStatus = true;
            length++;
        }
        int loop = length / 2;
        String[] strings = new String[loop];
        int j = 0;
        String tmp;
        for (int i = 0; i < loop; i++) {
            if (i == (loop - 1) && oddStatus) {
                tmp = s.substring(j, j + 1) + "_";
            } else {
                tmp = s.substring(j, j + 2);
                j += 2;
            }
            strings[i] = tmp;
        }
        return strings;
    }

    public static int countBits(int n) {
        // Show me the code!
        String s = Integer.toBinaryString(n);
        return s.replaceAll("0", "").length();
    }
}
