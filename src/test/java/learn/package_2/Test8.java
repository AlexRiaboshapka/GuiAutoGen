package learn.package_2;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Test8 {
    @Test
    public void test1() {
        int[] arrayInt = new int[5];
        try {
            for (int i = 0; i < 8; i++) {
                arrayInt[i] = i;
            }
        } catch (Exception ignore) {

        }
        System.out.println(Arrays.toString(arrayInt));
    }
}
