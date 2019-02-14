package emias.calldoctor.e2e;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

public class CreateCallTest extends AbstractTestGrid {

    @Test(groups = "e2e", description = "")
    @Epic("")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() {
        //сделать запрос select в таблицу мкаб

    }
}