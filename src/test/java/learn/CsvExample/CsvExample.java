package learn.CsvExample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

import static helper.CsvHelper.parseCsv;
import static helper.CsvHelper.writeToCsv;

public class CsvExample {
    private final String csvPath = "target/users.csv";
    private final String userName = "User1";
    private final String userPass = "User1Pass123";

    @DataProvider
    public Iterator<Object[]> users() throws IOException {
        return parseCsv(csvPath);
    }

    @Test
    public void writeToCsvTest() throws IOException {
        writeToCsv(csvPath, userName, userPass);
    }

    @Test(dataProvider = "users")
    public void readFromCsvTest(String userName, String userPass){
        System.out.println("userName: " + userName);
        System.out.println("userPass: " + userPass);
    }
}
