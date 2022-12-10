package helper;

import com.opencsv.CSVWriter;
import io.qameta.allure.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvHelper {

    @Step
    public static void writeToCsv(String pathToCsv, String... fields) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(pathToCsv, true), '‡',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            writer.writeNext(fields);
        }

    }

    public static Iterator<Object[]> parseCsv(String csvPath) throws IOException {
        File file = new File(csvPath);
        ArrayList<Object[]> data = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] temp = line.split("‡");
                List<Object> array = new ArrayList<>(Arrays.asList(temp));
                data.add(array.toArray());
            }
        }
        return data.iterator();
    }
}