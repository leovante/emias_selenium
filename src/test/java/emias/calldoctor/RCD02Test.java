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

public class RCD02Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testVerifyEditPageProfile1() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1", nameGen);
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testEditCallProfile1() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .setDeafult()
                .editCallProfile2("Profile2", nameGen);
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
//                .searchFilterFio(nameGen)
                .verifyNewCallGroup("Profile2");
    }
}