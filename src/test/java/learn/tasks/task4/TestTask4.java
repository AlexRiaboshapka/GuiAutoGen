package learn.tasks.task4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class TestTask4 extends BaseTest {
    @Test
    public void compareArrays() {
        for (int i = 0; i < prepareTestData.arrayList1.size(); i++) {
            System.out.println("prepareTestData.arrayList1.get(i): " + prepareTestData.arrayList1.get(i));
            System.out.println("prepareTestData.arrayList2.get(i): " + prepareTestData.arrayList2.get(i));
            Assert.assertTrue((Objects.equals(prepareTestData.arrayList1.get(i),
                    Integer.valueOf(prepareTestData.arrayList2.get(i)))));
        }

    }
}
