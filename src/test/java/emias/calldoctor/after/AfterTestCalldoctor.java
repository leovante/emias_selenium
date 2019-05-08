package emias.calldoctor.after;

import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Test;

public class AfterTestCalldoctor extends TestBase {

    @Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanAfterCallDoctorTests() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }
}