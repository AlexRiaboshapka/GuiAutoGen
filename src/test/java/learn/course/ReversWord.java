package learn.course;

import logger.CustomLogger;

public class ReversWord {
    static String word = "Hello World!";
    static String newWord = "";

    public static void main(String[] args) {
        reverseString(word);
    }

    public static void reverseString(String word) {

        for (int i = (word.length() - 1); i >= 0; i--) {
            newWord += word.charAt(i);

        }

        CustomLogger.logger.info("Reversed newWord: " + newWord);

        StringBuilder sb = new StringBuilder(word);
        String newRevWord = sb.reverse().toString();
        CustomLogger.logger.info("Reversed word newRevWord: " + newRevWord);

    }

}
