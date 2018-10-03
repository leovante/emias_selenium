package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChangeDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
//        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage().changeDoctorBtn();
        page.setDoctorPage().chooseDoctor("SerovaStendTestovoe");
        page.fullCardPage()
                .verifyActivCall("Profile1")
                .verifyDoctor("SerovaStendTestovoe")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
//                .searchFilterFio()
                .verifyActiveDocGroup("Profile1", "SerovaStendTestovoe");
    }
}