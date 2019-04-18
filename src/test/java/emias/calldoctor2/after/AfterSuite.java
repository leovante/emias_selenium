package emias.calldoctor2.after;

import emias.TestBase;
import utils.sql.DBScripts;
import utils.testngRetryCount.RetryCountIfFailed;

public class AfterSuite extends TestBase {

    @org.testng.annotations.Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }
}