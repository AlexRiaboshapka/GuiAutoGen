package learn.package_2;

import org.testng.annotations.Test;

public class Test6_1 {
    @Test
    public void test1() {
        String[] my = new String[5];
        for (int i = 0; i < my.length; i++) {
            my[i] = "Element" + i;
        }
        for (String m : my) {
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
