package learn.course.junit5;

import logger.CustomLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
// Run test in alphanumerical order
public class OrderedTests {

    @Test
    void firstTest() {
        CustomLogger.logger.info("firstTest");
    }

    @Test
    @DisplayName("My custom name for secondTest: ")
    void secondTest() {
        CustomLogger.logger.info("secondTest");
    }
}
