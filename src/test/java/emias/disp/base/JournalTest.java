package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.Datas;
import com.datas.calldoctor.PacientImpl;
import com.system.service.HltDispCardServiceImpl;
import emias.TestDispBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.beans.SpringBeansUtil.getBean;
import static com.codeborne.selenide.Selenide.*;

public class JournalTest extends TestDispBase {
    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "отображение элементов на странице журнала")
    @RetryCountIfFailed(2)
    public void testJournalPageElements(){
        IPage.misHome().dispJournal();
        IPage.journalPage()
                .journalMenuBtn()
                .validJournalElements();
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по номеру через журнал")
    @RetryCountIfFailed(2)
    public void testSearchCardByCardNumber() {
        IPage.misHome().dispJournal();
        IPage.journalPage()
                .journalMenuBtn()
                .searchByCardNumber(1649)
                .clickSearchBtn()
                .fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(2)
    public void testSearchCardByPolNumber() {
        PacientImpl pac = new PacientImpl("Temnikov94");
        IPage.misHome().dispJournal();
        IPage.journalPage().journalMenuBtn();
        IPage.journalPage().searchByPolNumber(Integer.parseInt(pac.getNumberpol()));
        IPage.journalPage().clickSearchBtn();
        IPage.journalPage().fioIsVisible(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(2)
    public void testSearchCardByFio() {
        PacientImpl pac = new PacientImpl("Temnikov94");
        IPage.misHome().dispJournal();
        IPage.journalPage().journalMenuBtn();
        IPage.journalPage().searchByFio(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
        IPage.journalPage().clickSearchBtn();
        IPage.journalPage().fioIsVisible(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через журнал")
    @RetryCountIfFailed(2)
    public void verifyMeasurePattern() {
        IPage.misHome().dispJournal();
        IPage.journalPage().journalMenuBtn();
        IPage.journalPage().searchByCardNumber(418);
        IPage.journalPage().clickSearchBtn();
        IPage.journalPage().editCardBtn(165734);
        IPage.exampPage().viewFlurography();
        $x("//*[contains(text(),'Не удается открыть медицинскую запись')]")
                .shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия")
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromMkab() {
        // TODO: 5/28/2019 объект с данными пациента
        Datas d = new Datas(){
          int a = 1;
        };
        //get на карту диспы
//        HltDispCardEntity card = hltDispCardService.getCardWithFluorography();

        IPage.misHome().dispJournal();
        IPage.journalPage().journalMenuBtn();
        IPage.journalPage().searchByCardNumber(1594);
        IPage.journalPage().clickSearchBtn();
        IPage.journalPage().editCardBtn(7654321);
        IPage.exampPage().viewFlurography();
        $x("//*[contains(text(),'Не удается открыть медицинскую запись')]")
                .shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через ячейку расписания", enabled = false)
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromSheduleCell() {
        PacientImpl pacientImpl = new PacientImpl("Temnikov94");
        IPage.misHome().loginMis();
        IPage.homePageMis().raspisaniPriemaBtn();
        IPage.doctorMethods().selectDoctor("Ай Бо ЛитАвтоТест");
        IPage.homePageMis().mkabBtn();
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
        IPage.journalPage().journalMenuBtn();
        IPage.journalPage().searchByPolNumber(7654321);
        IPage.journalPage().clickSearchBtn();
        IPage.journalPage().editCardBtn(7654321);
        IPage.exampPage().viewFlurography();
        $(By.xpath("//*[contains(text(),'Не удается открыть медицинскую запись')]")).shouldNotBe(Condition.visible);
    }
    // TODO: 9/26/2019 проверить отображение шаблона через мкаб и через ячейку расписания

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверяю что мероприятие открывается у подписанной карты")
    @RetryCountIfFailed(2)
    public void openClosedCard() {
        IPage.misHome().dispJournal();
        IPage.journalPage()
                .journalMenuBtn()
                .searchByCardNumber(1652)
                .clickSearchBtn()
                .editCardBtn(334438);
        IPage.exampPage()
                .switchAllServicesTap()
                .viewFlurography();
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "закрытие карты диспансеризации с проставлением причины")
    @RetryCountIfFailed(2)
    public void closeCard() {
        getBean(HltDispCardServiceImpl.class).open(180);
        IPage.misHome().dispJournal();
        IPage.journalPage()
                .journalMenuBtn()
                .searchByCardNumber(180)
                .clickSearchBtn()
                .closeCardBtn(165734)
                .setCloseReasonDeath()
                .setCloseReasonDescription()
                .closeCard2()
                .changeCardStatus_toClosed()
                .clickSearchBtn()
                .openCardByPolis(165734);
        IPage.exampPage().validateCardIsDisable();
    }
}