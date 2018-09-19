package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;


public class FilterTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyNewCallGroup("Profile1", nameGen);
    }

    //    @Attachment(value = "Console error", type = "text/plain")
    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor("Profile1")
                .verifyActiveDocGroup(nameGen, "Profile1");
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException {
        page.createCallPage().createCallProfile3(nameGen);
        beforecdCD.loginMis_Calldoctor();
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup("Profile3", nameGen);
    }

    @Test(groups = "test", description = "проверка кнопки выход")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        beforecdCD.loginMis_Calldoctor();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}