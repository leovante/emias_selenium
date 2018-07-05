package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD03Test extends AbstractTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = {"CD", "test"})
    public void afterTest() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "назначить врача на сегодня")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        page.setDoctorPage().appendDoctor(doctorFamPro1);
        page.manageShedule().getSecondName(doctorFamPro1);
        page.fullCardPage().verifyCallProfile1Activity(doctorFamPro1, nameGen)
                .closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyActiveDocGroup(doctorFamPro1, nameGen, adressPro1_2, telephonePro1);
    }
}