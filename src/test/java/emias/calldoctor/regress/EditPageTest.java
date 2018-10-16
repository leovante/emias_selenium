package emias.calldoctor.regress;

import com.codeborne.selenide.SelenideElement;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class EditPageTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPage() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctor();
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
        enterSite.enterCalldoctor();
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
        enterSite.enterCalldoctor();
        page.createCallPage()
                .createCall(pacient)
                .editCallBtn()
                .setDeafult()
                .editCallPage(pacient2);
        page.fullCardPage()
                .verifyNewCall(pacient2)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }
}