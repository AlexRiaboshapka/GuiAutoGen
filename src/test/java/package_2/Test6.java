package package_2;

import org.testng.annotations.Test;

public class Test6 {
    @Test
    public void test1() {
        String[] my = new String[5];
        for (int i = 0; i < my.length; i++) {
            my[i] = "element " + i;
        }
        for (String s : my) {
            System.out.println(s);
        }

    }

}
