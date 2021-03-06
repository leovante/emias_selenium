package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.lib.assistance.Assistance.parseTelephone;

public class DashboardPage extends BasePage {
    private SelenideElement exitToMis = $(By.id("headerUserMenu")).$x("../.").$x(".//div");
    private SelenideElement exitBtn = $x("//span[contains(text(),'Выход')]");
    private SelenideElement instructionBtn = $x("//span[contains(text(),'Инструкция')]");
    private SelenideElement filter_all = $(By.xpath("//*[text()='Все']"));
    private SelenideElement filter_today = $(By.xpath("//*[text()='Сегодня']"));
    private SelenideElement filter_tomorrow = $(By.xpath("//*[text()='Завтра']"));
    private SelenideElement filterTodayViz = /*$(By.id("mCSB_5_container")).*/$(By.xpath("//span[contains(text(),'Сегодня')]"));
    private SelenideElement filterTomorrowViz = /*$(By.id("mCSB_5_container")).*/$(By.xpath("//span[contains(text(),'Завтра')]"));
    private SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    private SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    private SelenideElement typeCall = $(By.xpath("//*[text()='Вид вызова']"));
    private SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    private SelenideElement matExpansionPanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    private SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    private SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    private SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));
    private SelenideElement cancelCall = $(By.id("cancelcall"));

    DashboardPage()  {
        refresh();
    }

    @Step("вышел в мис")
    public void exitToMis() {
        exitToMis.click();
        exitBtn.click();
    }

    @Step("инструкция в мис")
    public void instructionTab() {
        exitToMis.click();
        instructionBtn.click();
        switchTo().window("Форум");
    }

//    @Step("поиск в фильтре ФИО")
//    public DashboardPage searchFilterFio(String fio) {
//        fioFilter.click();
//        fioFilter.setValue(fio);
//        return this;
//    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio_Fam(Pacient pacient) {
        fioFilter.click();
        fioFilter.setValue(pacient.getFamily());
        sleep(2000);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(Doctor doctor)  {
        sleep(1000);
        docFilter.hover().click();
        sleep(1000);
        docFilter.sendKeys(doctor.getFamily());
        sleep(1000);
        fioFilter.hover().click();
        sleep(1000);
        docFilter.hover().click();
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getSpecialization() + "')]")).shouldBe(Condition.visible);
        sleep(1000);
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getSpecialization() + "')]")).click();
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterTypeCallNeotlozhniy() {
        typeCall.click();
        typeCallFilterNeotlozhniy.click();
        return this;
    }

    @Step("очистить фильтр подразделение")
    public DashboardPage clearFilterDepart() {
        ElementsCollection closeList = $$(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (SelenideElement closeBtn : closeList) {
            closeBtn.click();
        }
        fioFilter.clear();
        fioFilter.click();
        return this;
    }

    @Step("Переключить фильтр все-завтра")
    public DashboardPage filter_all_tomorrow() {
        filter_all.click();
        filterTomorrowViz.click();
        return this;
    }

    @Step("Переключить фильтр завтра-сегодня")
    public DashboardPage filter_tomorrow_today() {
        filter_tomorrow.click();
        filterTodayViz.click();
        return this;
    }

//    @Step("проверяю на дашборде запись в группе новые")
//    public void verifyNewCallGroup(String profile, String nameGen) throws InterruptedException, IOException {
//        Thread.sleep(4000);
//        newCallProgressFrame.$(By.id("order")).click();
//        newCallProgressFrame.click();
//        if (proData.get("source").equals("СМП")) {
//            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
//            $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
//        }
//        if (!proData.get("source").equals("СМП")) {
//            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
//            $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
//            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
//        }
//        logger.info("Краткая карта вызова проверена!");
//    }

    @Step("проверяю на дашборде запись в группе новые")
    public void verifyNewCallGroup(Pacient pacientImpl) {
        sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getName() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getFamily() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getOt() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).shouldBe(Condition.visible);
        logger.info("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPage verifyActiveDocGroup(Pacient pacientImpl, Doctor doctor) {
        sleep(1000);
        SelenideElement docFamBlock = $x("//span[contains(text(),'" + doctor.getFamily() + "')]").$x("../../.");
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$x("../../../.");
        docBlock.$x(".//*[contains(text(),'Ожидают обработки')]")
                .$x("../.")
                .$x(".//mat-icon[@id='order']").click();
        docBlock.$x(".//*[contains(text(),'Ожидают обработки')]").click();
        $x("//*[contains(text(),'" + pacientImpl.getAddress() + "')]").click();
        $x("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]").shouldBe(Condition.visible);
        logger.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверяю на дашборде запись не отображается у врача в группе активные")
    public DashboardPage verifyActiveDocGroupNotVisible(Pacient pacientImpl, Doctor doctor) {
        sleep(1000);
        SelenideElement docFamBlock =
                $(By.xpath("//*[contains(text(),'Активные')]"))
                        .$(By.xpath("./../..//span[contains(text(),'" + doctor.getFamily() + "')]"));
        SelenideElement docFamBlockList = docFamBlock
                .$(By.xpath("../../../../../."))
                .$(By.xpath("./div[1]"));
        sleep(500);
        if (docFamBlock.isDisplayed()) {
            if (!docFamBlockList.isDisplayed())
                docFamBlock.click();
            SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
            SelenideElement waitGreen = docFamBlock.$(By.xpath("../../../../../.")).$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"));
            if (waitGreen.isDisplayed()) {
                waitGreen.$(By.xpath("../."))
                        .$(By.xpath(".//*[@id='order']")).click();
                waitGreen.click();
            }
            $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]")).shouldNotBe(Condition.visible);
        } else {
            docFamBlock.shouldNotBe(Condition.visible);
        }
        logger.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверка в группе обслуженные")
    public void verifyPacientNumberInServe(Pacient pacient, Doctor doctor) {
        lib.calldoctor(pacient,doctor)
                .expandDoctorInServe()
                .sortInProgress()
                .expandInProgress()
                .expandPacient();
        $x("//*[contains(text(),'" + parseTelephone(pacient) + "')]").shouldBe(Condition.visible);
        logger.info("Краткая карта вызова проверена!");
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsCancelFromDashboard(PacientImpl pacientImpl)  {
        sleep(5000);
        SelenideElement address = $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        if (newCallProgressFrame.isDisplayed()) {
            newCallProgressFrame.$(By.id("order")).click();
            newCallProgressFrame.click();
            if (address.isDisplayed()) {
                address.click();
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getName() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getFamily() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getOt() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).isDisplayed());
            } else {
                logger.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            logger.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsNotCancelFromDashboard(PacientImpl pacientImpl)  {
        sleep(5000);
        SelenideElement address = $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        if (newCallProgressFrame.isDisplayed()) {
            newCallProgressFrame.$(By.id("order")).click();
            newCallProgressFrame.click();
            if (address.isDisplayed()) {
                address.click();
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getName() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getFamily() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacientImpl.getOt() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).isDisplayed());
            } else {
                logger.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            logger.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("открываю вызов в группе 'Ожидают обработки' через дашбоард")
    public void openNewCallDash(Pacient pacientImpl) {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();

        ElementsCollection addressCollection = matExpansionPanel
                .$$x(".//*[contains(text(),'" + pacientImpl.getAddress() + "')]");
        SelenideElement address = addressCollection.get(0);

        address.shouldBe(Condition.visible);
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();//маленький уголочек

        SelenideElement smallMenu = address
                .$x("../../../.")
                .$x(".//*[contains(text(),'chevron_left')]");
        smallMenu.shouldBe(Condition.visible);
        actions.moveToElement(smallMenu).perform();//большая менюшка

        SelenideElement openCard = address
                .$x("../../../.")
                .$x(".//a[@title='Открыть карту вызова']")
                .$x(".//mat-icon[contains(text(),'assignment')]");
        address.shouldBe(Condition.visible);

        if(openCard.is(Condition.visible)){
            openCard.click();
        }else{
            for (int i = 0; i < 5; i++) {
                waitVisible(address);
                if(openCard.is(Condition.visible))
                    break;
                sleep(1000);
            }
            openCard.click();
        }
    }

    void waitVisible(SelenideElement address){
        address.shouldBe(Condition.visible);
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();//маленький уголочек

        SelenideElement smallMenu = address
                .$x("../../../.")
                .$x(".//*[contains(text(),'chevron_left')]");
        smallMenu.shouldBe(Condition.visible);
        actions.moveToElement(smallMenu).perform();//большая менюшка
    }

    @Step("отменяю вызов без указания причины в группе 'Ожидают обработки' через дашбоард")
    public DashboardPage cancelNewCallDash(PacientImpl pacientImpl)  {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        sleep(4000);
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();

        SelenideElement smallMenu = address
                .$(By.xpath("../../../."))
                .$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        sleep(1000);
        actions.moveToElement(smallMenu).perform();
        SelenideElement cancelCard = address
                .$(By.xpath("../../../."))
                .$(By.xpath(".//a[@title='Отменить вызов']"))
                .$(By.xpath(".//mat-icon[contains(text(),'close')]"));
        sleep(1000);
        cancelCard.click();
        address.$(By.xpath("../../../../../.")).$(By.xpath(".//a[@title='Отменить вызов']")).click();
        return this;
    }

    @Step("отменяю вызов в группе 'Ожидают обработки' через дашбоард")
    public DashboardPage deleteNewCallProgressFrame(PacientImpl pacientImpl) {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();

        SelenideElement adress = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(adress).perform();

        SelenideElement smallMenu = adress
                .$(By.xpath("../../../."))
                .$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        actions.moveToElement(smallMenu).perform();
        SelenideElement openCard = adress
                .$(By.xpath("../../../."))
                .$(By.xpath(".//*[@title='Отменить вызов']"));
        openCard.click();
        return this;
    }

    @Step("валидация что вызов не отменился на странице редактирования")
    public DashboardPage verifyCancellCallValidation()  {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на дашборде")
    public DashboardPage verifyCancellCallValidation_Dash()  {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        sleep(2000);
        return this;
    }

    @Step("кнопка печати группы активные")
    public DashboardPage printActionColumn() {
        $x("//div[@id='activeCallAllCount']/../div[6]/mat-icon").click();
        return this;
    }
}