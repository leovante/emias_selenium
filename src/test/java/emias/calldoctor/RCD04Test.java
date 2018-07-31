package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class RCD04Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        open(curUrlCalldoctor);

        page.createCallPage().createCallProfile1("Profile1", nameGen);

        page.fullCardPage().appoindDoctorBtn();
        page.setDoctorPage().appendDoctor("Profile1");

        page.fullCardPage().sendAnotherDoctorBtn();
        page.setDoctorPage().appendDoctor("Profile2");
        page.fullCardPage().verifyCallProfile1Activity(nameGen, "Profile2");
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio("Profile2")
                .clearFilterDepart()
                .verifyActiveDocGroup(nameGen, "Profile2");
    }
}