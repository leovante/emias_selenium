package emias.mis.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PerehodyTest extends TestBase {
    @Test(groups = "mis", description = "Переход в диспетчер с дашборда МИС")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionCDdashboard() {
        page.misHome().calldoctorAdminTemnikov();
        $(By.xpath("//*[contains(text(),'Вызов врача на дом')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в диспетчер из МКАБ")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionCDmkab() {
        page.misHome().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
        $(By.id("jqContextMenu"))
                .$(By.id("MkabGridcontextmenuitem0"))
                .click();
        $(By.id("mkab_tabs"))
                .$(By.id("actions_tab"))
                .$(By.xpath(".//*[contains(text(),'Действия')]"))
                .click();
        $(By.id("mkabtabs_Actions_scroller"))
                .$(By.xpath(".//*[contains(text(),'Оформить вызов врача на дом')]"))
                .hover()
                .click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в диспетчер из журнала вызовы на дом")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionCDjournal() {
        page.misHome().loginMis();
        $x("//span[contains(text(),'Вызов врача на дом')]").click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $x("//*[contains(text(),'Новый вызов')]").shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в диспетчер из личного кабинета врача")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionCDlk() {
        page.misHome().loginMis();
        $(By.xpath("//span[contains(text(),'Личный кабинет')]")).click();
        $(By.id("MyCallTab")).click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в журнал диспансеризации из дашборда МИС")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionDispDash() {
        page.misHome().loginMis();
        page.homePageMis().dispCardJournalBtn();
        switchTo().window("Медицинская Информационная Система");
        $(By.xpath("//*[contains(text(),'Журнал')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в журнал диспансеризации из МКАБ")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionDispMkab() {
        page.misHome().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Действия')]")).click();
        $(By.xpath("//*[contains(text(),'Карты диспансеризации / профосмотры')]")).click();
        sleep(1000);
        switchTo().window(2);
        SelenideElement se = $x("//*[contains(text(),'Журнал')]");
        se.shouldBe(Condition.visible);
        Assert.assertTrue(se.is(Condition.visible));
    }

    @Test(groups = "mis", description = "Переход в маршрутный лист диспансеризации из ячейки расписания")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionDispShedule() {
        PacientImpl pacientImpl = new PacientImpl("Temnikov94");
        Doctor doctor = new Doctor("Dispanserizatov");
        page.misHome().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage()
                .generateML(pacientImpl)
                .getTerapevtTime()
                .saveAndCloseBtn()
                .selectDoctor(doctor)
                .lastDispPacientCell_kartaProfOsmotra();
        $(By.xpath("//*[contains(text(),'Карта мероприятий')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в медзаписи из МКАБ")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionMedMkab() {
        page.misHome().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Мед. записи →')]")).click();
        switchTo().window(1);
        $(By.xpath("//*[@placeholder='Поиск медицинской записи по наименованию']")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в медзаписи из ТАП")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void transitionMedTap() {
        page.misHome().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
        $(By.id("jqContextMenu"))
                .$(By.id("MkabGridcontextmenuitem0"))
                .click();
        $(By.id("mkab_tabs"))
                .$(By.xpath(".//*[contains(text(),'Случаи')]"))
                .click();
        $(By.id("tapgrid2"))
                .$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']"))
                .click();
        $(By.id("jqContextMenu"))
                .$(By.id("tapgrid2contextmenuitem0"))
                .click();
        $(By.id("TAPDialogTabs"))
                .$(By.xpath(".//*[contains(text(),'Медицинские записи →')]"))
                .click();
        switchTo().window(1);
        $(By.xpath("//*[@placeholder='Поиск медицинской записи по наименованию']")).shouldBe(Condition.visible);
    }
}