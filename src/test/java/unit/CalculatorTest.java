package unit;

import calc.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        Double a = 2.0;
        Double b = 3.0;
        Double expectedResult = 5.0;
        Double actualResult = calculator.getSum(a, b);
        Assertions.assertEquals(expectedResult, actualResult, "ActualResult: " + actualResult
                + " Not equals expected Result " + expectedResult);
    }

    @Test
    public void testGetMultiplication() {
        Double a = 2.0;
        Double b = 3.0;
        Double expectedResult = 6.0;
        Double actualResult = calculator.getMultiplication(a, b);
        Assertions.assertEquals(expectedResult, actualResult, "ActualResult: " + actualResult
                + " Not equals expected Result " + expectedResult);
    }

    @Test
    public void testGetDivision() {
        Double a = 3.0;
        Double b = 3.0;
        Double expectedResult = 1.0;
        Double actualResult = calculator.getDivision(a, b);
        Assertions.assertEquals(expectedResult, actualResult, "ActualResult: " + actualResult
                + " Not equals expected Result " + expectedResult);
    }

    @Test
    public void testGetSubtraction() {
        Double a = 3.0;
        Double b = 2.0;
        Double expectedResult = 1.0;
        Double actualResult = calculator.getSubtraction(a, b);
        Assertions.assertEquals(expectedResult, actualResult, "ActualResult: " + actualResult
                + " Not equals expected Result " + expectedResult);
    }
}
