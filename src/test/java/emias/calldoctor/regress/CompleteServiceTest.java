package emias.calldoctor.regress;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class CompleteServiceTest extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearAllFilters()
                .verifyDoneDocGroup(nameGen, "Profile1");
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}