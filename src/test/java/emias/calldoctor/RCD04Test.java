package emias.calldoctor;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.CleanDoctorTT;
import pages.utilities.StringGenerator;

public class RCD04Test extends BaseTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = {"CD", "test"})
    public void afterTest() {
        CleanDoctorTT.finalizePacientName(nameGen);

    }

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        page.setDoctorPage().appendDoctor(doctorFamPro1);

        page.fullCardPage().sendAnotherDoctorBtn();
        page.setDoctorPage().appendDoctor(doctorFamPro2);
        page.fullCardPage().verifyCallProfile1Activity(doctorFamPro2, nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().clearFilterDepart();
        page.dashboardPage().verifyActiveDocGroup(doctorFamPro2, nameGen, adressPro1_2, telephonePro1);
    }
}