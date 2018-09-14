package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ChangeDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage().changeDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile2");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile1", "Profile2")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterFio(nameGen)
                .verifyActiveDocGroup(nameGen, "Profile2", "Profile1");
    }
}