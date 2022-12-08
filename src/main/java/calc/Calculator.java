package calc;

import logger.CustomLogger;


public class Calculator {

    public Double getSum(Double a, Double b) {
        Double sum = a + b;
        CustomLogger.logger.info("Log message from get sum: " + sum);
        return sum;
    }

    public Double getMultiplication(Double a, Double b) {
        return a * b;
    }

    public Double getDivision(Double a, Double b) {
        return a / b;
    }

    public Double getSubtraction(Double a, Double b) {
        return a - b;
    }
}
