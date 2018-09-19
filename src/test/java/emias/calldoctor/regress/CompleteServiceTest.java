package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

public class CompleteServiceTest extends AbstractTestGrid {

    @Test(groups = "test", description = "завершить обслуживание вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() throws Exception {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearAllFilters()
                .verifyDoneDocGroup(nameGen, "Profile1");
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}