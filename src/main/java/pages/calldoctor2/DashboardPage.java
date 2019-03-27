package pages.calldoctor2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dataGenerator.ModuleData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.AbstractPage;
import pages.calldoctor2.doctors_interfaces.Doctor;
import pages.calldoctor2.profiles_interfaces.Pacient;
import system.model.HltMkabEntity;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends AbstractPage {
    ModuleData mData;
    HltMkabEntity mkab;

    private SelenideElement exitToMis = $(By.xpath("//mat-icon[contains(text(),'more_vert')]"));
    private SelenideElement exitBtn = $(By.xpath("//*[contains(text(),'Выход')]"));
    private SelenideElement mat_select_value = $(By.xpath("//div[@class='mat-select-value']"));
    private SelenideElement filterTomorrow = $(By.xpath("//*[contains(text(),'Завтра')]"));
    private SelenideElement filterToday = $(By.xpath("//*[contains(text(),'Сегодня')]"));

    private SelenideElement filterTodayViz = $(By.id("mCSB_5_container")).$(By.xpath(".//span[contains(text(),'Сегодня')]"));
    private SelenideElement filterTomorrowViz = $(By.id("mCSB_5_container")).$(By.xpath(".//span[contains(text(),'Завтра')]"));

    private SelenideElement instructionBtn = $(By.xpath("//*[contains(text(),'Инструкция')]"));
    private SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    private SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    private SelenideElement typeCall = $(By.xpath("//*[@placeholder='Вид вызова']"));
    private SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    private SelenideElement matExpansionPanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    private SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    private SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    private SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));
    private SelenideElement cancelCall = $(By.id("cancelcall"));


    public DashboardPage(ModuleData mData) {
        this.mData = mData;
        this.mkab = mData.getMkab();

    }

    @Step("вышел в мис")
    public void exitToMis() {
        exitToMis.click();
        exitBtn.click();
    }

    @Step("вышел в мис")
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
    public DashboardPage searchFilterFio_Fam(Pacient pacient) throws IOException, InterruptedException {
        fioFilter.click();
        fioFilter.setValue(pacient.getFamily());
        Thread.sleep(2000);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(Doctor doctor) throws IOException, InterruptedException {
        Thread.sleep(1000);
        docFilter.hover().click();
        Thread.sleep(1000);
        docFilter.sendKeys(doctor.getFamily());
        Thread.sleep(1000);
        fioFilter.hover().click();
        Thread.sleep(1000);
        docFilter.hover().click();
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//div[@role='listbox']/mat-option/span[contains(text(),'" + doctor.getFamily() + "')]")).click();
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterTypeCallNeotlozhniy() {
        typeCall.click();
        typeCallFilterNeotlozhniy.click();
        return this;
    }

    @Step("очистить фильтр подразделение")
    public DashboardPage clearAllFilters() {
        ElementsCollection closeList = $$(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (SelenideElement closeBtn : closeList) {
            closeBtn.click();
        }
        return this;
    }

    @Step("Переключить фильтр на завтра")
    public DashboardPage filterTomorrow() {
        mat_select_value.click();
        filterTomorrow.click();
        filterTomorrowViz.shouldBe(Condition.visible);
        return this;
    }

    @Step("Переключить фильтр на сегодня")
    public DashboardPage filterToday() {
        mat_select_value.click();
        filterToday.click();
        filterTodayViz.shouldBe(Condition.visible);
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
    public void verifyNewCallGroup() throws InterruptedException, IOException {
        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
//        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
//        $(By.xpath("//*[contains(text(),'" + pacient.getName() + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + pacient.getFamily() + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + pacient.getOt() + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacient) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPage verifyActiveDocGroup(Pacient pacient, Doctor doctor) throws IOException, InterruptedException {
        Thread.sleep(1000);
        SelenideElement docFamBlock = $(By.xpath("//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(mData) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверяю на дашборде запись не отображается у врача в группе активные")
    public DashboardPage verifyActiveDocGroupNotVisible(Pacient pacient, Doctor doctor) throws IOException, InterruptedException {
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
            $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).shouldNotBe(Condition.visible);
        } else {
            docFamBlock.shouldNotBe(Condition.visible);
        }
        LOGGER.info("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(Pacient pacient, Doctor doctor) throws InterruptedException {
        SelenideElement doneFrame = $(By.xpath("//*[contains(text(),'Обслуженные')]")).$(By.xpath("../../."));
        SelenideElement docFamBlock = doneFrame.$(By.xpath(".//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(mData) + "')]")).shouldBe(Condition.visible);
        LOGGER.info("Краткая карта вызова проверена!");
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsCancelFromDashboard(Pacient pacient) throws InterruptedException {
        Thread.sleep(5000);
        SelenideElement address = $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]"));
        if (newCallProgressFrame.isDisplayed()) {
            newCallProgressFrame.$(By.id("order")).click();
            newCallProgressFrame.click();
            if (address.isDisplayed()) {
                address.click();
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getName() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getFamily() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getOt() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + parseTelephone(mData) + "')]")).isDisplayed());
            } else {
                LOGGER.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            LOGGER.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyCallIsNotCancelFromDashboard(Pacient pacient) throws InterruptedException {
        Thread.sleep(5000);
        SelenideElement address = $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]"));
        if (newCallProgressFrame.isDisplayed()) {
            newCallProgressFrame.$(By.id("order")).click();
            newCallProgressFrame.click();
            if (address.isDisplayed()) {
                address.click();
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacient.getName() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacient.getFamily() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + pacient.getOt() + "')]")).isDisplayed());
                Assert.assertTrue(!$(By.xpath("//*[contains(text(),'" + parseTelephone(mData) + "')]")).isDisplayed());
            } else {
                LOGGER.info("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            LOGGER.info("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("открываю вызов в группе 'Ожидают обработки' через дашбоард")
    public void openNewCallDash(Pacient pacient) throws IOException, InterruptedException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacient.getAddress() + "')]"));
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
    public DashboardPage cancelNewCallDash(Pacient pacient) throws IOException, InterruptedException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        Thread.sleep(4000);
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacient.getAddress() + "')]"));
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
    public DashboardPage deleteNewCallProgressFrame(Pacient pacient) throws IOException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();

        SelenideElement adress = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacient.getAddress() + "')]"));
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
    public DashboardPage verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на дашборде")
    public DashboardPage verifyCancellCallValidation_Dash() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        return this;
    }
}