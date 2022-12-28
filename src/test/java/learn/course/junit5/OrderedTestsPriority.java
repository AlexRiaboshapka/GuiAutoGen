package learn.course.junit5;

import logger.CustomLogger;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Run test in alphanumerical order 
public class OrderedTestsPriority {

    @Test
    @Order(2)
    void firstTest() {
        CustomLogger.logger.info("firstTest");
    }

    @Test
    @DisplayName("My custom name for secondTest: ")
    void secondTest() {
        CustomLogger.logger.info("secondTest");
    }

    @Test
    @Order(1)
    void thirdTest() {
        CustomLogger.logger.info("thirdTest");
    }

}
