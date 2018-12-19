package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class JournalTest extends AbstractTestGrid {
    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по номеру через профиль")
    @RetryCountIfFailed(2)
    public void testSearchCard1() {
        open(DISP_CARD_URL);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(3059);
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(2)
    public void testSearchCard2() {
        open(DISP_CARD_URL);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(7654321);
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(2)
    public void testSearchCard3() {
        open(DISP_CARD_URL);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByFio("Темников Дмитрий Олегович");
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по номеру через журнал")
    @RetryCountIfFailed(2)
    public void testSearchCard4() {
        enter.enterDispJournalFromMis();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(3059);
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(2)
    public void testSearchCard5() {
        enter.enterDispJournalFromMis();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(7654321);
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(2)
    public void testSearchCard6() {
        enter.enterDispJournalFromMis();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByFio("Темников Дмитрий Олегович");
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через журнал")
    @RetryCountIfFailed(2)
    public void verifyMeasurePattern() throws InterruptedException {
        enter.enterDispJournalFromMis();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(1594);
        page.journalPage().clickSearchBtn();
        page.journalPage().editCardBtn(7654321);
        page.exampPage().viewFlurography();
        $(By.xpath("//*[contains(text(),'Не удается открыть медицинскую запись')]")).shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через мкаб")
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromMkab() throws InterruptedException {
        enter.enterMIS();
        page.homePageMis().mkabBtn();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        $(By.id("MkabGrid"))
                .$(By.xpath(".//*[@id='2723314']"))
                .$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']"))
                .click();
        $(By.id("jqContextMenu"))
                .$(By.id("MkabGridcontextmenuitem0"))
                .click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Действия')]")).click();
        $(By.xpath("//*[contains(text(),'Карты диспансеризации')]")).click();
        switchTo().window(1);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(1594);
        page.journalPage().clickSearchBtn();
        page.journalPage().editCardBtn(7654321);
        page.exampPage().viewFlurography();
        $(By.xpath("//*[contains(text(),'Не удается открыть медицинскую запись')]")).shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через ячейку расписания", enabled = false)
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromSheduleCell() throws InterruptedException, IOException, JSONException {
        Pacient pacient = new Pacient("Temnikov94");
        enter.enterMIS();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage().createDispMl(pacient);
        page.doctorMethods().selectDoctor("Ай Бо ЛитАвтоТест");
//        page.raspisaniePriemaPage().selectCell();

        page.homePageMis().mkabBtn();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        $(By.id("MkabGrid"))
                .$(By.xpath(".//*[@id='2723314']"))
                .$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']"))
                .click();
        $(By.id("jqContextMenu"))
                .$(By.id("MkabGridcontextmenuitem0"))
                .click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Действия')]")).click();
        $(By.xpath("//*[contains(text(),'Карты диспансеризации')]")).click();
        switchTo().window(1);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(7654321);
        page.journalPage().clickSearchBtn();
        page.journalPage().editCardBtn(7654321);
        page.exampPage().viewFlurography();
        $(By.xpath("//*[contains(text(),'Не удается открыть медицинскую запись')]")).shouldNotBe(Condition.visible);
    }
    //проверить отображение шаблона через мкаб и через ячейку расписания
}