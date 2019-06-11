package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPageBase extends PageBase {

    private SelenideElement exitToMis = $(By.xpath("//mat-icon[contains(text(),'more_vert')]"));
    private SelenideElement exitBtn = $(By.xpath("//*[contains(text(),'Выход')]"));
    private SelenideElement filter_all = $(By.xpath("//*[text()='Все']"));
    private SelenideElement filter_today = $(By.xpath("//*[text()='Сегодня']"));
    private SelenideElement filter_tomorrow = $(By.xpath("//*[text()='Завтра']"));
    private SelenideElement filterTodayViz = /*$(By.id("mCSB_5_container")).*/$(By.xpath("//span[contains(text(),'Сегодня')]"));
    private SelenideElement filterTomorrowViz = /*$(By.id("mCSB_5_container")).*/$(By.xpath("//span[contains(text(),'Завтра')]"));
    private SelenideElement instructionBtn = $(By.xpath("//*[contains(text(),'Инструкция')]"));
    private SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    private SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    private SelenideElement typeCall = $(By.xpath("//*[text()='Вид вызова']"));
    private SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    private SelenideElement matExpansionPanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    private SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    private SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    private SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));
    private SelenideElement cancelCall = $(By.id("cancelcall"));

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
    public DashboardPageBase searchFilterFio_Fam(PacientImpl pacientImpl) throws InterruptedException {
        fioFilter.click();
        fioFilter.setValue(pacientImpl.getFamily());
        Thread.sleep(2000);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPageBase searchFilterDoctor(Doctor doctor) throws InterruptedException {
        Thread.sleep(1000);
        docFilter.hover().click();
        Thread.sleep(1000);
        docFilter.sendKeys(doctor.getFamily());
        Thread.sleep(1000);
        fioFilter.hover().click();
        Thread.sleep(1000);
        docFilter.hover().click();
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getSpecialization() + "')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getSpecialization() + "')]")).click();
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPageBase searchFilterTypeCallNeotlozhniy() {
        typeCall.click();
        typeCallFilterNeotlozhniy.click();
        return this;
    }

    @Step("очистить фильтр подразделение")
    public DashboardPageBase clearAllFilters() {
        ElementsCollection closeList = $$(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (SelenideElement closeBtn : closeList) {
            closeBtn.click();
        }
        return this;
    }

    @Step("Переключить фильтр все-завтра")
    public DashboardPageBase filter_all_tomorrow() {
        filter_all.click();
        filterTomorrowViz.click();
        return this;
    }

    @Step("Переключить фильтр завтра-сегодня")
    public DashboardPageBase filter_tomorrow_today() {
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
//        LOGGER.info("Краткая карта вызова проверена!");
//    }

    @Step("проверяю на дашборде запись в группе новые")
    public void verifyNewCallGroup(Pacient pacientImpl) throws InterruptedException {
        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getName() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getFamily() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getOt() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPageBase verifyActiveDocGroup(PacientImpl pacientImpl, Doctor doctor) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement docFamBlock = $(By.xpath("//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверяю на дашборде запись не отображается у врача в группе активные")
    public DashboardPageBase verifyActiveDocGroupNotVisible(PacientImpl pacientImpl, Doctor doctor) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement docFamBlock =
                $(By.xpath("//*[contains(text(),'Активные')]"))
                        .$(By.xpath("./../..//span[contains(text(),'" + doctor.getFamily() + "')]"));
        SelenideElement docFamBlockList = docFamBlock
                .$(By.xpath("../../../../../."))
                .$(By.xpath("./div[1]"));
        Thread.sleep(500);
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
        LOGGER.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(PacientImpl pacientImpl, Doctor doctor) {
        SelenideElement doneFrame = $(By.xpath("//*[contains(text(),'Обслуженные')]")).$(By.xpath("../../."));
        SelenideElement docFamBlock = doneFrame.$(By.xpath(".//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacientImpl.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacientImpl) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsCancelFromDashboard(PacientImpl pacientImpl) throws InterruptedException {
        Thread.sleep(5000);
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
                LOGGER.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            LOGGER.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsNotCancelFromDashboard(PacientImpl pacientImpl) throws InterruptedException {
        Thread.sleep(5000);
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
                LOGGER.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            LOGGER.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("открываю вызов в группе 'Ожидают обработки' через дашбоард")
    public void openNewCallDash(Pacient pacientImpl) throws InterruptedException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();

        SelenideElement smallMenu = address.$(By.xpath("../../../.")).$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        actions.moveToElement(smallMenu).perform();
        SelenideElement openCard = address.$(By.xpath("../../../."))
                .$(By.xpath(".//a[@title='Открыть карту вызова']"))
                .$(By.xpath(".//mat-icon[contains(text(),'assignment')]"));
        Thread.sleep(1000);
        openCard.click();
    }

    @Step("отменяю вызов без указания причины в группе 'Ожидают обработки' через дашбоард")
    public DashboardPageBase cancelNewCallDash(PacientImpl pacientImpl) throws InterruptedException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        Thread.sleep(4000);
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacientImpl.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();

        SelenideElement smallMenu = address
                .$(By.xpath("../../../."))
                .$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        Thread.sleep(1000);
        actions.moveToElement(smallMenu).perform();
        SelenideElement cancelCard = address
                .$(By.xpath("../../../."))
                .$(By.xpath(".//a[@title='Отменить вызов']"))
                .$(By.xpath(".//mat-icon[contains(text(),'close')]"));
        Thread.sleep(1000);
        cancelCard.click();
        address.$(By.xpath("../../../../../.")).$(By.xpath(".//a[@title='Отменить вызов']")).click();
        return this;
    }

    @Step("отменяю вызов в группе 'Ожидают обработки' через дашбоард")
    public DashboardPageBase deleteNewCallProgressFrame(PacientImpl pacientImpl) {
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
    public DashboardPageBase verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на дашборде")
    public DashboardPageBase verifyCancellCallValidation_Dash() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        return this;
    }

    @Step("кнопка печати группы активные")
    public DashboardPageBase printActionColumn() {
        $x("//div[@id='activeCallAllCount']/../div[6]/mat-icon").click();
        return this;
    }
}