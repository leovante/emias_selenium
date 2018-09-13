package emias.retry2;

import org.testng.ITestResult;

public interface IRetryAnalyzer {

    boolean retry(ITestResult result);

}
