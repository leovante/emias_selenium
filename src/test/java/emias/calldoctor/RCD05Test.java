package emias.calldoctor;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD05Test extends BaseTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
    }

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistr() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().cancelRecordOnFullCardPage();
        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().cancelRecordOnChangePage();
        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyRecordIsCancelFromDashboard();
    }
}