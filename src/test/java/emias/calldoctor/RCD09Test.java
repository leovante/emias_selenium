package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile3;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD09Test extends AbstractTest implements Profile1, Profile2, Profile3 {
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

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        page.setDoctorPage().appendDoctor(doctorFamPro1);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterDoctor(doctorFamPro1);
        page.dashboardPage().verifyActiveDocGroup(doctorFamPro1, nameGen, adressPro1_2, telephonePro1);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException {
        page.createCallPage().createCallProfile3(nameGen);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(nameGen);
        page.fullCardPage().verifyCallProfile3(nameGen);

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().searchFilterTypeCallNeotlozhniy();
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro3, telephonePro1);
    }
}