package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RCD05Test extends AbstractTest {
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

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistr() throws InterruptedException, IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile1("Profile1", nameGen);
        page.fullCardPage().cancelRecordOnFullCardPage();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelCallRegistrEmpy() throws InterruptedException, IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile1("Profile1", nameGen);
        page.fullCardPage()
                .editCallBtn()
                .cancelRecordOnChangePage();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }
}