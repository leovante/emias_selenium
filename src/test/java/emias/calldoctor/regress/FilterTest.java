package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;


public class FilterTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
//                .searchFilterFio()
                .verifyNewCallGroup("Profile1");
    }

    //    @Attachment(value = "Console error", type = "text/plain")
    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor("Profile1")
                .verifyActiveDocGroup("Profile1");
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException {
        page.createCallPage().createCall_Api("Profile3");
        enterSite.enterCalldoctor();
        page.dashboardPage().openNewCallDash("Profile3");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
//                .searchFilterFio()
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup("Profile3");
    }

    @Flaky
    @Test(groups = "CD", description = "проверка кнопки выход")
    @Epic("Проверка фильтра")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        enterSite.enterCalldoctor();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}