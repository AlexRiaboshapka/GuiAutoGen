package learn.course.chapter13;

import logger.CustomLogger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        createFile();
    }

    public static void createFile() {
        File file = new File("target/new.txt");
        try (Scanner scanner = new Scanner(file)) {
            file.createNewFile();
            String line = scanner.nextLine();
            List<String> list = new ArrayList<String>();
            list = Arrays.stream(line.split(" ")).toList();
            for (String item : list) {
                CustomLogger.logger.info(item);
            }
        } catch (IOException e) {
            CustomLogger.logger.info("Path is not valid");
            throw new RuntimeException(e);
        } finally {

        }
    }
}
