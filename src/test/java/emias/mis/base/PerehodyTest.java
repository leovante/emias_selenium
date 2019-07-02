package emias.mis.base;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PerehodyTest extends TestBase {

    /**
     * переходы в диспетчер
     */
    @Test(groups = "mis", description = "Переходы в Диспетчер с дашборда")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionCDdashboard() {
        page.misHomePage().calldoctor();
        $(By.xpath("//*[contains(text(),'Вызов врача на дом')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переходы в Диспетчер из мкаб")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionCDmkab() {
        page.misHomePage().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
//        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
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

    @Test(groups = "mis", description = "Переходы в Диспетчер из журнала")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionCDjournal() {
        page.misHomePage().loginMis();
        $(By.xpath("//span[contains(text(),'Вызов врача на дом')]")).click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переходы в Диспетчер из личного кабинета врача")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionCDlk() {
        page.misHomePage().loginMis();
        $(By.xpath("//span[contains(text(),'Личный кабинет')]")).click();
        $(By.id("MyCallTab")).click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    /**
     * переходы в диспансеризацию
     */
    @Test(groups = "mis", description = "Переход в Карты диспансеризации из дашборда")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionDispDash() throws InterruptedException {
        page.misHomePage().loginMis();
        page.homePageMis().dispCardJournalBtn();
        switchTo().window("Медицинская Информационная Система");
        $(By.xpath("//*[contains(text(),'Журнал')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Карты диспансеризации из МКАБ")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionDispMkab() {
        page.misHomePage().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
//        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Действия')]")).click();
        $(By.xpath("//*[contains(text(),'Карты диспансеризации / профосмотры')]")).click();
        switchTo().window("Медицинская Информационная Система");
        $(By.xpath("//*[contains(text(),'Журнал')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Диспансеризацию из ячейки расписание приема")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionDispShedule() throws IOException, JSONException, NoSuchFieldException, InterruptedException {
        PacientImpl pacientImpl = new PacientImpl("Temnikov94");
        Doctor doctor = new Doctor("Dispanserizatov");
        page.misHomePage().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage()
                .generateML(pacientImpl)
                .getTerapevtTime()
                .saveAndCloseBtn()
                .selectDoctor(doctor)
                .lastDispPacientCell_kartaProfOsmotra();
        $(By.xpath("//*[contains(text(),'Карта мероприятий')]")).shouldBe(Condition.visible);
    }

    /**
     * переходы в медзаписи
     */
    @Test(groups = "mis", description = "Переход в Медзаписи из Мкаб")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionMedMkab() {
        page.misHomePage().loginMis();
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        page.mkabPage().openMkab("Темников Дмитрий Олегович");
//        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Мед. записи →')]")).click();
        switchTo().window(1);
        $(By.xpath("//*[@placeholder='Поиск медицинской записи по наименованию']")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Медзаписи из Тап")
    @Epic("Переходы")
    @RetryCountIfFailed(3)
    public void transitionMedTap() {
        page.misHomePage().loginMis();
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