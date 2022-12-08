package config;

import logger.CustomLogger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryConfig implements IRetryAnalyzer {
    private final int maxRetryCount = 1;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (result.getStatus() == 2) {
            if (retryCount < maxRetryCount) {
                CustomLogger.logger.info("Retrying test: " + result.getName());
                retryCount++;
                return true;
            }
        }
        return false;
    }
}
