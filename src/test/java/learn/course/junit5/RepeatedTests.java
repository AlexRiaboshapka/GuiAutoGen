package learn.course.junit5;

import logger.CustomLogger;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests {
    @RepeatedTest(value = 2, name = "Running test: {currentRepetition}. " + " Total is: {totalRepetitions} ")
    void firstRepeatedMethod() {
        CustomLogger.logger.info("firstRepeatedMethod: ");
    }
}
