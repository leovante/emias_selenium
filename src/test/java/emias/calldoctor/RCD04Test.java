package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD04Test extends AbstractTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        //SQLDemonstration.finalizePacientName(nameGen);

    }

    @Test(groups = "test", description = "передать вызов другому врачу")
    @Issue("EMIAS-90")
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

        page.dashboardPage().searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyActiveDocGroup(doctorFamPro2, nameGen, adressPro1_2, telephonePro1);
    }
}