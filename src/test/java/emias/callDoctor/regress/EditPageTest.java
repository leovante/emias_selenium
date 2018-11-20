package emias.callDoctor.regress;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditPageTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage()
                .createCall(pacient)
                .editCallBtn()
                .verifyCallProfile1(pacient);
    }

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова. После сохранения в истории не должно появиться новых записей")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage_2() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage()
                .createCall(pacient)
                .editCallBtn()
                .saveBtn();
        List<SelenideElement> se = $$(By.xpath("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']"));
        Assert.assertTrue(se.size() == 1, "Количество записей в истории больше одной!");
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCall() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Pacient pacient2 = new Pacient("Profile2");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage()
                .createCall(pacient)
                .editCallBtn()
                .setDeafult()
                .editCallPage_Mkab(pacient2)
                .saveBtn();
        page.fullCardPage()
                .verifyNewCall(pacient2)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }

    @Test(groups = "test", description = "проверяю наличие валидации адреса после редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testValidationAddressAfterSaveEditedCall() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        Pacient pacient2 = new Pacient("Profile0_3");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Mkab(pacient);
        page.fullCardPage().editCallBtn();
        page.createCallPage()
                .setDeafult()
                .editCallPage(pacient2)
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Московская обл.,Химки г.,Пролетарская ул.')]")).shouldNotBe(Condition.visible);
    }
}