package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile3;
import pages.utilities.StringGenerator;

public class RCD09Test extends AbstractTest implements Profile1, Profile2, Profile3 {
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

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen)
                .verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "test", description = "фильтр поиск по врачу")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        page.setDoctorPage().appendDoctor(doctorFamPro1);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage()
                .searchFilterDoctor(doctorFamPro1)
                .verifyActiveDocGroup(doctorFamPro1, nameGen, adressPro1_2, telephonePro1);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException {
        page.createCallPage().createCallProfile3(nameGen);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(nameGen);
        page.fullCardPage()
                .verifyCallProfile3(nameGen)
                .closeCardBtn();

        page.dashboardPage()
                .searchFilterFio(nameGen)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallProgressFrame(nameGen, adressPro3, telephonePro1);
    }
}