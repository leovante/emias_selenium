package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.commons.assistance.Assistance.visible;

public class EditTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .editCallBtn()
                .verifyCallProfile1(pacient);
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage_2() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .editCallBtn()
                .saveBtn();
        $x("//*[contains(.,'Карта создана')]").shouldBe(Condition.visible);
        List<SelenideElement> se = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        Assert.assertEquals(1, se.size(), "Количество записей в истории больше одной!");
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры. Меняем с мкаб на неформал")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall_mkab_any() {
        Pacient pacient = new PacientImpl("Profile2");
        Pacient pacient2 = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);
        new DuringTestHelper().beforeCleanDecider(pacient2);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall_Mkab();
        page.createCall(pacient2)
                .editCallBtn()
                .setDeafult()
                .editCallPage()
                .saveBtn();
        page.fullCard(pacient2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры. Меняем с неформал на мкаб")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall_any_mkab() {
        Pacient pacient = new PacientImpl("Profile1");
        Pacient pacient2 = new PacientImpl("Profile2");
        new DuringTestHelper().beforeCleanDecider(pacient);
        new DuringTestHelper().beforeCleanDecider(pacient2);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.createCall(pacient2)
                .editCallBtn()
                .setDeafult()
                .editCallPage_Mkab()
                .saveBtn();
        page.fullCard(pacient2, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "CD", description = "проверяю валидацию на наличие адреса после редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testValidationAddressAfterSaveEditedCall() {
        Pacient pacient = new PacientImpl("Profile2");
        Pacient pacient2 = new PacientImpl("Profile0_3");
        new DuringTestHelper().beforeCleanDecider(pacient);
        new DuringTestHelper().beforeCleanDecider(pacient2);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall_Mkab();
        page.fullCard(pacient, testName())
                .editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage()
                .saveBtn();
        $x("//simple-snack-bar[contains(.,'Не указан адрес')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "формализация неформализованного адреса на странице редактирования")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutID() {
        Pacient pacient = new PacientImpl("Profile0_3_1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall();
        page.createCall(pacient).editCallBtn();
        visible(pacient.getAddress3adv());
    }
}