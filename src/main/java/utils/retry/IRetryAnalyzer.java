package utils.retry;

import org.testng.ITestResult;

public interface IRetryAnalyzer {

    boolean retry(ITestResult result);

}
