package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.datas.Datas;
import com.datas.calldoctor.PacientImpl;
import com.system.model.HltDispCardEntity;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class JournalTest extends TestBase {
    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по номеру через журнал")
    @RetryCountIfFailed(2)
    public void testSearchCardByCardNumber() {
        page.misHome().dispJournal();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(1649);
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible("Темников Дмитрий Олегович");
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(2)
    public void testSearchCardByPolNumber() throws IOException, JSONException {
        PacientImpl pac = new PacientImpl("Temnikov94");
        page.misHome().dispJournal();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(Integer.parseInt(pac.getNumberpol()));
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(2)
    public void testSearchCardByFio() throws IOException, JSONException {
        PacientImpl pac = new PacientImpl("Temnikov94");
        page.misHome().dispJournal();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByFio(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
        page.journalPage().clickSearchBtn();
        page.journalPage().fioIsVisible(pac.getFamily() + " " + pac.getName() + " " + pac.getOt());
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через журнал")
    @RetryCountIfFailed(2)
    public void verifyMeasurePattern() throws InterruptedException {
        page.misHome().dispJournal();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(418);
        page.journalPage().clickSearchBtn();
        page.journalPage().editCardBtn(165734);
        page.exampPage().viewFlurography();
        $x("//*[contains(text(),'Не удается открыть медицинскую запись')]")
                .shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия")
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromMkab() throws InterruptedException {
        // TODO: 5/28/2019 объект с данными пациента
        Datas d = new Datas(){
          int a = 1;
        };
        //get на карту диспы
//        HltDispCardEntity card = hltDispCardService.getCardWithFluorography();

        page.misHome().dispJournal();
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(1594);
        page.journalPage().clickSearchBtn();
        page.journalPage().editCardBtn(7654321);
        page.exampPage().viewFlurography();
        $x("//*[contains(text(),'Не удается открыть медицинскую запись')]")
                .shouldNotBe(Condition.visible);
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверить открытие шаблона у мероприятия при входе через ячейку расписания", enabled = false)
    @RetryCountIfFailed(2)
    public void verifyMeasurePatternFromSheduleCell() throws InterruptedException, IOException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Temnikov94");
        page.misHome().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.doctorMethods().selectDoctor("Ай Бо ЛитАвтоТест");
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
    // TODO: 9/26/2019 проверить отображение шаблона через мкаб и через ячейку расписания

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "проверяю что мероприятие открывается у подписанной карты")
    @RetryCountIfFailed(2)
    public void openClosedCard() throws InterruptedException {
        page.misHome().dispJournal();
        page.journalPage()
                .journalMenuBtn()
                .searchByCardNumber(1652)
                .clickSearchBtn()
                .editCardBtn(334438);
        page.exampPage()
                .switchAllServicesTap()
                .viewFlurography();
    }

    @Epic("Журнал диспансеризации")
    @Test(groups = "disp", description = "закрытие карты диспансеризации с проставлением причины")
    @RetryCountIfFailed(2)
    public void closeCard() {
        hltDispCardService.unClose(180);
        page.misHome().dispJournal();
        page.journalPage()
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
        page.exampPage().validateCardIsDisable();
    }
}