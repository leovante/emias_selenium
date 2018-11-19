package emias.callDoctor.after;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

public class AfterSuite extends AbstractTestGrid {

    @Test(description = "Завершаю все вызовы с тегом 'тест' в жалобах")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() {
        SQLDemonstration.finalizeCallsOperatorTemnikov();
    }
}