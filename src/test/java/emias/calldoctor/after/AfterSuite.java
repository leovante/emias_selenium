package emias.calldoctor.after;

import emias.TestBase;
import org.testng.annotations.Test;
import utils.sql.DBScripts;
import utils.testngRetryCount.RetryCountIfFailed;

public class AfterSuite extends TestBase {

    @Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }
}