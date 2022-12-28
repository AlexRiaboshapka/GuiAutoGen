package learn.course.junit5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {
    @Test
    void assertEqualsTest() {
        assertEquals("Expected", "Expected", "The expected is not equals actual");
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("Expected", "Actual",
                        "The expected is not equals actual 1"),
                () -> assertEquals("Expected", "Actual",
                        "The expected is not equals actual 2"),
                () -> assertEquals("Expected", "Expected",
                        "The expected is not equals actual")
        );

    }

    @Test
    void asserForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);
        assertThat(theMap, Matchers.hasKey("secondKey"));
        assertThat(theMap, Matchers.hasValue(2));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString1", "secondString2", "thirdString3");

        assertThat(theList, Matchers.hasItem("secondString2"));
    }
}
