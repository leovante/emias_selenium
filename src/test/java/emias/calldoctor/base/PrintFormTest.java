package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.*;

@Ignore
public class PrintFormTest extends TestBase {

    @Test(groups = "CD", description = "проверка формы печати группы активные")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintAllDoctors() {
        page.loginPage().calldoctor();
        page.dashboardPage().printActionColumn();
        switchTo().window(1);
        $x("//*[contains(text(),'Отчет по состоянию')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка формы печати на странице карты вызова")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintCard() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacient, testName()).printBtn();
        switchTo().window(1);
        $x("//*[contains(.,'Карта вызова')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка формы печати одного врача", enabled = false)
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintOneDoctor() throws IOException, JSONException, ParseException, InterruptedException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(pacient, testName()).printBtn();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'test/call-doctor/card/view')]")).shouldBe(Condition.visible);
        // TODO: 4/1/2019 доделать
    }
}