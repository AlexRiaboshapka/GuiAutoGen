package learn.tasks.task4;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
    PrepareTestData prepareTestData = new PrepareTestData();

    @BeforeMethod
    public void setUp(){
        prepareTestData.createArrayInt();
        prepareTestData.createArrayString();
    }
}
