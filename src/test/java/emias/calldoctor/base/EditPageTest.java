package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class EditPageTest extends TestBase {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .verifyCallProfile1(pacient);
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage_2() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .saveBtn();
        $x("//*[contains(.,'Карта создана')]").shouldBe(Condition.visible);
        List<SelenideElement> se = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        Assert.assertTrue(se.size() == 1, "Количество записей в истории больше одной!");
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры. Меняем с мкаб на неформал")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall_mkab_any() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile2");
        PacientImpl pacient2 = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.createCall(pacient2)
                .editCallBtn()
                .setDeafult()
                .editCallPage()
                .saveBtn();
        page.fullCard(pacient2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры. Меняем с неформал на мкаб")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall_any_mkab() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile1");
        PacientImpl pacient2 = new PacientImpl("Profile2");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn();
        page.createCall(pacient2)
                .editCallBtn()
                .setDeafult()
                .editCallPage_Mkab()
                .saveBtn();
        page.fullCard(pacient2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "CD", description = "проверяю валидацию на наличие адреса после редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testValidationAddressAfterSaveEditedCall() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile2");
        PacientImpl pacient2 = new PacientImpl("Profile0_3");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage()
                .saveBtn();
        $(By.xpath("//simple-snack-bar[contains(.,'Не указан адрес')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "формализация неформализованного адреса на странице редактирования")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutID() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacient = new PacientImpl("Profile0_3_1");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall();
        page.createCall(pacient).editCallBtn();
        $(By.xpath("//*[contains(.,'" + pacient.getAddress3adv() + "')]")).shouldBe(Condition.visible);
    }
}