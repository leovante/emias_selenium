package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class CompleteServiceTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(3)
    public void testCompleteCallRegistr() throws Exception {
        String nameGen = new StringGenerator().generator();
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