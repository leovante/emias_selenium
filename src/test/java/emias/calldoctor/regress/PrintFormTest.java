package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PrintFormTest extends TestBase {

    @Test(groups = "CD", description = "проверка формы печати")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testCallPrintActiveFrame() {
        page.loginPage().calldoctor();
        page.dashboardPage().printActionColumn();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Отчет по состоянию')]")).shouldBe(Condition.visible);
    }

    /**
     * доделать
     */
    @Test(groups = "CD", description = "проверка формы печати")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testCallDoctorPrint() {
        page.loginPage().calldoctor();
        page.dashboardPage().printActionColumn();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Отчет по состоянию')]")).shouldBe(Condition.visible);
    }
}