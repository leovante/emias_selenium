package emias.calldoctor2.after;

import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;

public class AfterSuite extends TestBase {

    @org.testng.annotations.Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }
}