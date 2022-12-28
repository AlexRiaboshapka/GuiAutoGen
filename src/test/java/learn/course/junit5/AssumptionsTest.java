package learn.course.junit5;

import logger.CustomLogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 2, 6})
    void intValues(int theParam) {
        assumeTrue(theParam > 3, "Skipped test for param < 3");
        CustomLogger.logger.info("theParam = " + theParam);
    }
}
