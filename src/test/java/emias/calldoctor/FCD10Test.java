package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class FCD10Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @Test(groups = "test", description = "проверка списка врачей для ребенка")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall() throws IOException {
        open(curUrlCalldoctor);

        page.createCallPage().createCallProfile0();
        page.fullCardPage()
                .verifyCallProfile0("Profile7")
                .closeCardBtn();
    }
}
