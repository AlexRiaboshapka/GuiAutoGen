package listener;

import logger.CustomLogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        CustomLogger.logger.info("Test started. Test name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        CustomLogger.logger.info("Test PASSED. Test name: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        CustomLogger.logger.info("Test FAILED. Test name: " + result.getName() + "\n");
        CustomLogger.logger.info(result.getThrowable().getMessage() + "\n");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        CustomLogger.logger.info("Test SKIPPED. Test name: " + result.getName() + "\n");
        CustomLogger.logger.info(result.getThrowable().getMessage() + "\n");
    }
}
