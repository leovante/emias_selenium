package emias.calldoctor.after;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

public class AfterSuite extends AbstractTestGrid {

    @Test(description = "Завершаю все вызовы оператора Темников")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        SQLDemonstration.finalizeCallsOperatorTemnikov();
    }
}