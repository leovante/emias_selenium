package emias.calldoctor.after;

import emias.TestBase;
import utilities.sql.DBScripts;
import utilities.testngRetryCount.RetryCountIfFailed;

public class AfterSuite extends TestBase {

    @org.testng.annotations.Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }
}