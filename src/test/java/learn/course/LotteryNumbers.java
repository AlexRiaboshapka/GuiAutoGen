package learn.course;

import logger.CustomLogger;

import java.util.Arrays;
import java.util.Random;

public class LotteryNumbers {
    private static final int LENGTH = 6;
    private static final int MAX_NUMBER = 45;


    public static void main(String[] args) {
        int[] numbers = generateNumbers();
        Arrays.sort(numbers);
        for (int num : numbers) {
            CustomLogger.logger.info("Numbers: " + num);
        }

    }

    public static int[] generateNumbers() {
        int[] ticket = new int[LENGTH];
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            int randomNum;
            do {
                randomNum = random.nextInt(MAX_NUMBER) + 1;
            } while (search(ticket, randomNum));

            ticket[i] = randomNum;
        }
        return ticket;
    }

    /**
     * Does a sequential search on the array to find a value
     *
     * @param array Array to search through
     * @param num   Value to search
     * @return true if found false if not
     */
    public static boolean search(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int num) {
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, num);
        if (index < 0) {
            return false;
        } else {
            return true;
        }
    }
}

