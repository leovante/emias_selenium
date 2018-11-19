package emias.mis.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import utilities.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PerehodyTest extends AbstractTestGrid {

    /**
     * переходы в диспетчер
     */
    @Test(groups = "mis", description = "Переходы в Диспетчер с дашборда")
    @RetryCountIfFailed(3)
    public void transitionCDdashboard() {
        enterSite.enterCalldoctorFromMis();
        $(By.xpath("//*[contains(text(),'Вызов врача на дом')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переходы в Диспетчер из мкаб")
    @RetryCountIfFailed(3)
    public void transitionCDmkab() {
        page.loginPage().login(site, login, pass);
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.id("actions_tab")).$(By.xpath(".//*[contains(text(),'Действия')]")).click();
        $(By.id("mkabtabs_Actions_scroller")).$(By.xpath(".//*[contains(.,'Оформить вызов врача на дом')]")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переходы в Диспетчер из журнала")
    @RetryCountIfFailed(3)
    public void transitionCDjournal() {
        page.loginPage().login(site, login, pass);
        $(By.xpath("//span[contains(text(),'Вызов врача на дом')]")).click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переходы в Диспетчер из личного кабинета врача")
    @RetryCountIfFailed(3)
    public void transitionCDlk() {
        page.loginPage().login(site, login, pass);
        $(By.xpath("//span[contains(text(),'Личный кабинет')]")).click();
        $(By.id("MyCallTab")).click();
        $(By.id("add_doc_house_btn")).click();
        switchTo().window(1);
        $(By.xpath("//*[contains(text(),'Новый вызов')]")).shouldBe(Condition.visible);
    }

    /**
     * переходы в диспансеризацию
     */
    @Test(groups = "mis", description = "Переход в Карты диспансеризации из дашборда", enabled = false)
    @RetryCountIfFailed(3)
    public void transitionDispDash() {
        page.loginPage();
        //
        $(By.xpath("//*[contains(text(),'Журнал')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Карты диспансеризации из МКАБ", enabled = false)
    @RetryCountIfFailed(3)
    public void transitionDispMkab() {
        page.loginPage();
        //
        $(By.xpath("//*[contains(text(),'Журнал')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Диспансеризацию из Расписания приема", enabled = false)
    @RetryCountIfFailed(3)
    public void transitionDispShedule() {
        page.loginPage();
        //Карта мероприятий
        $(By.xpath("//*[contains(text(),'Карта мероприятий')]")).shouldBe(Condition.visible);
    }

    /**
     * переходы в медзаписи
     */
    @Test(groups = "mis", description = "Переход в Медзаписи из Мкаб")
    @RetryCountIfFailed(3)
    public void transitionMedMkab() {
        page.loginPage().login(site, login, pass);
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Мед. записи →')]")).click();
        switchTo().window(1);
        $(By.xpath("//*[@placeholder='Поиск медицинской записи по наименованию']")).shouldBe(Condition.visible);
    }

    @Test(groups = "mis", description = "Переход в Медзаписи из Тап")
    @RetryCountIfFailed(3)
    public void transitionMedTap() {
        page.loginPage().login(site, login, pass);
        $(By.xpath("//*[contains(text(),'Медицинские карты')]")).click();
        $(By.id("patientMkab")).val("Темников Дмитрий Олегович");
        $(By.id("searchMkabByFilter")).click();
        $(By.id("MkabGrid")).$(By.xpath(".//*[@id='2723314']")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("MkabGridcontextmenuitem0")).click();
        $(By.id("mkab_tabs")).$(By.xpath(".//*[contains(text(),'Случаи')]")).click();
        $(By.id("tapgrid2")).$(By.id("1944035")).$(By.xpath(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")).click();
        $(By.id("jqContextMenu")).$(By.id("tapgrid2contextmenuitem0")).click();
        $(By.id("TAPDialogTabs")).$(By.xpath(".//*[contains(text(),'Медицинские записи →')]")).click();
        switchTo().window(1);
        $(By.xpath("//*[@placeholder='Поиск медицинской записи по наименованию']")).shouldBe(Condition.visible);
    }
}