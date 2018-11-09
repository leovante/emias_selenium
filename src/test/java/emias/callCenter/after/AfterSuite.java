package emias.callCenter.after;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;

public class AfterSuite extends AbstractTestGrid {

    @Test(description = "Завершаю все вызовы с тегом 'тест' в жалобах")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        SQLDemonstration.finalizeCallsOperatorTemnikov();
    }
}