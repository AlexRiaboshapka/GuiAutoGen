package learn.package_2;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Test7 {
    @Test
    public void test1() {
        ArrayList<String> myList = new ArrayList<>();
        String[] my = new String[5];
        for (int i = 0; i < 5; i++) {
            myList.add(String.valueOf(i));
        }
        for (String s : myList) {
            System.out.println(s);
        }
    }
}
