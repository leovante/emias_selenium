package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class ChangeDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
        String nameGen = new StringGenerator().generator();
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