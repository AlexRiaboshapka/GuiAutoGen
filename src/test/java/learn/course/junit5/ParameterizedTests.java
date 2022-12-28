package learn.course.junit5;

import logger.CustomLogger;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 2, 6})
    void intValues(int theParam) {
        CustomLogger.logger.info("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"string1", "string2"})
    void stringValues(String value) {
        CustomLogger.logger.info("value = " + value);
    }

    @ParameterizedTest
    @CsvSource(value = {"sea, sky", "fly, left"})
    void csvSourceStringString(String s, String t) {
        CustomLogger.logger.info("s = " + s + ", t = " + t);
    }

    @ParameterizedTest
    @CsvSource(value = {"stringValue1 with is long", "'second value with , comma'"})
    void csvValueString(String value) {
        CustomLogger.logger.info("value = " + value);
    }

    @ParameterizedTest
    @CsvSource(value = {"space?future", "grow?small"}, delimiter = '?')
    void csvSourceCustomDelimiter(String s, String t) {
        CustomLogger.logger.info("s = " + s + ", t = " + t);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/datafiles/shop.csv", "src/test/resources/datafiles/shop2.csv"}, numLinesToSkip = 1)
    void csvFileSource(String product, double price, int quantity, String unit, String provider) {
        CustomLogger.logger.info("product = " + product + ", price = " + price + ", quantity = " + quantity
                + ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/datafiles/shop3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSourceCustomDelimiter(String product, double price, int quantity, String unit, String provider) {
        CustomLogger.logger.info("product = " + product + ", price = " + price + ", quantity = " + quantity
                + ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSourceString(String s) {
        CustomLogger.logger.info("s = " + s);
    }

    List<String> sourceString() {
        return Arrays.asList("stringValue1 with is long", "second value with , comma");
    }

    Stream<String> sourceStringStream() {
        return Stream.of("value1", "value2", "value3");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringStream")
    void methodSourceStringStream(String s) {
        CustomLogger.logger.info("s = " + s);
    }

    List<Arguments> sourceListStringDouble() {
        return Arrays.asList(arguments("orange", 1.5), arguments("apple", 0.99));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceListStringDouble")
    void methodSourceListStringDouble(String s, Double d) {
        CustomLogger.logger.info("s = " + s + ", d = " + d);
    }

    @ParameterizedTest
    @MethodSource(value = "learn.course.junit5.ParamProvider#sourceStreamStringDouble")
    void methodSourceStreamStringDouble(String s, Double d) {
        CustomLogger.logger.info("s = " + s + ", d = " + d);
    }
}
