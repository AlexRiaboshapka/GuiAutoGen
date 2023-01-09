package learn.course.mix;

import logger.CustomLogger;

public class PalindromeTest {
    public static void main(String[] args) {
        String word = "racecar";
        String reverse = "";

        for (int i = word.length(); i > 0; i--) {
            reverse += word.charAt(i - 1);
        }
        if (word.equals(reverse)) {
            CustomLogger.logger.info("Palindrome");
        } else {
            CustomLogger.logger.info("Not Palindrome");
        }
    }
}
