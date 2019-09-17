package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.*;

public class PrintFormTest extends TestBase {

    @Test(groups = "CD", description = "проверка формы печати группы активные")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintAllDoctors() throws IOException {
        page.misHome().calldoctor();
        page.dashboard().printActionColumn();
        switchTo().window(1);
        $x("//*[contains(text(),'Отчет по состоянию')]").shouldBe(Condition.visible);
    }

/*
    @Ignore//не появляется доп. окно
    @Test(groups = "CD", description = "проверка формы печати на странице карты вызова")
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintCard() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCard(pacientImpl, testName()).printBtn();
        switchTo().window(1);
        $x("//*[contains(.,'Карта вызова')]").shouldBe(Condition.visible);
    }
*/

    @Ignore
    @Test(groups = "CD", description = "проверка формы печати одного врача", enabled = false)
    @Epic("Печать")
    @RetryCountIfFailed(2)
    public void testPrintOneDoctor() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).printBtn();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'test/call-doctor/card/view')]")).shouldBe(Condition.visible);
        // TODO: 4/1/2019 доделать
    }
}