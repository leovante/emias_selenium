package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD05Test extends AbstractTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = {"CD", "test"})
    public void afterTest() {
        //SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistr() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().cancelRecordOnFullCardPage();
        page.dashboardPage().searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().editCallBtn()
                .cancelRecordOnChangePage();
        page.dashboardPage().searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }
}