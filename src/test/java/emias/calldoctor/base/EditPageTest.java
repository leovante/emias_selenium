package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.calldoctor.pacients.PacientImpl;
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
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .verifyCallProfile1(pacientImpl);
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage_2() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
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
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        PacientImpl pacientImpl2 = new PacientImpl("Profile2");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .editCallBtn()
                .setDeafult()
                .editCallPage_Mkab(pacientImpl2)
                .saveBtn();
        page.fullCardPage(pacientImpl2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup(pacientImpl2);
    }

    @Test(groups = "CD", description = "проверяю валидацию на наличие адреса после редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testValidationAddressAfterSaveEditedCall() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        PacientImpl pacientImpl2 = new PacientImpl("Profile0_3");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).editCallBtn();
        page.createCallPage(pacientImpl)
                .setDeafult()
                .editCallPage(pacientImpl2)
                .saveBtn();
        $(By.xpath("//simple-snack-bar[contains(.,'Не указан адрес')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "формализация неформализованного адреса на странице редактирования")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutID() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_3_1");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall_Api();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName()).verifyNewCall();
        page.createCallPage(pacientImpl).editCallBtn();
        $(By.xpath("//*[contains(.,'" + pacientImpl.getAddress3adv() + "')]")).shouldBe(Condition.visible);
    }
}