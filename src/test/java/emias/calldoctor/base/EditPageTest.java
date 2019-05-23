package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.calldoctor.pacients.Pacient;
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
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .verifyCallProfile1(pacient);
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage_2() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .saveBtn();
        $x("//*[contains(.,'Карта создана')]").shouldBe(Condition.visible);
        List<SelenideElement> se = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        Assert.assertTrue(se.size() == 1, "Количество записей в истории больше одной!");
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Pacient pacient2 = new Pacient("Profile2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .setDeafult()
                .editCallPage_Mkab(pacient2)
                .saveBtn();
        page.fullCardPage(pacient2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "CD", description = "проверяю валидацию на наличие адреса после редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testValidationAddressAfterSaveEditedCall() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        Pacient pacient2 = new Pacient("Profile0_3");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(pacient, testName()).editCallBtn();
        page.createCallPage(pacient)
                .setDeafult()
                .editCallPage(pacient2)
                .saveBtn();
        $(By.xpath("//simple-snack-bar[contains(.,'Не указан адрес')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "подтягивание неформализованного мкаб на странице редактирования")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutID() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile0_3_1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(pacient, testName()).verifyNewCall();
        page.createCallPage(pacient).editCallBtn();
        $(By.xpath("//*[contains(.,'" + pacient.getAddress3adv() + "')]")).shouldBe(Condition.visible);
    }

    // TODO: 1/21/2019 добавить тест, вводить новый адрес английскими буквами
}