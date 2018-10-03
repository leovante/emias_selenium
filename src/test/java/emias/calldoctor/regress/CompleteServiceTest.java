package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CompleteServiceTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(3)
    public void testCompleteCallRegistr() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneCall("Profile1")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyDoneDocGroup("Profile1");
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}