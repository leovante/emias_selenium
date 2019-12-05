package com.commons.retry;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

public class RetryAnalyzer extends TestListenerAdapter implements IRetryAnalyzer {
    private static Logger logger = Logger.getLogger(RetryAnalyzer.class);
    private int counter = 0;
    private static final int retryLimit = 3;

    @Override
    public boolean retry(ITestResult result) {
        logger.info("Running retry for " + result.getMethod());
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
