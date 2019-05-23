package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.pages.AbstractPage;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.api_model.CallDoctorHttp;
import com.utils.except.NoticeException;
import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateCallPage extends AbstractPage {
    private Pacient pacient;
    SelenideElement cancelAdress = $(By.xpath("//*[@id='4198BD84-7A21-4E38-B36B-3ECB2E956408']"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
    SelenideElement adress = $(By.xpath("//input[@placeholder='Адрес']"));
    SelenideElement dom = $(By.xpath("//input[@placeholder='Дом']"));
    SelenideElement vKat = $(By.xpath("//input[@placeholder='Возр. категория']"));
    SelenideElement korpus = $(By.xpath("//input[@placeholder='Корпус']"));
    SelenideElement stroenie = $(By.xpath("//input[@placeholder='Строение']"));
    SelenideElement kvartira = $(By.xpath("//input[@placeholder='Квартира']"));
    SelenideElement pd = $(By.xpath("//input[@placeholder='П-д']"));
    SelenideElement dfon = $(By.xpath("//input[@placeholder='Д-фон']"));
    SelenideElement etazh = $(By.xpath("//input[@placeholder='Этаж']"));
    SelenideElement seriyaPol = $(By.xpath("//input[@placeholder='Серия']"));
    SelenideElement nomerPol = $(By.xpath("//input[@placeholder='Номер полиса']"));
    SelenideElement fam = $(By.xpath("//input[@placeholder='Фамилия']"));
    SelenideElement name = $(By.xpath("//input[@placeholder='Имя']"));
    SelenideElement otchestvo = $(By.xpath("//input[@placeholder='Отчество']"));
    SelenideElement birthDateTemp = $(By.xpath("//input[@placeholder='Дата рождения']"));
    SelenideElement phone = $(By.id("phone"));
    SelenideElement famCall = $(By.id("callFamily"));
    SelenideElement nameCall = $(By.id("callName"));
    SelenideElement otCall = $(By.id("callPatronymic"));
    SelenideElement sourceSmp = $(By.id("source0"));
    SelenideElement sourceSmp2 = $(By.id("sourceSmp"));
    SelenideElement sourceReg = $(By.id("source1"));
    SelenideElement callerType = $(By.xpath("//mat-select[@aria-label='Тип вызывающего']"));
    SelenideElement cancelBtn = $(By.id("cancelCall"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));
    SelenideElement cancelCall = $(By.xpath("//a[@title='Отменить вызов']"));

    public CreateCallPage(Pacient pacient) {
        this.pacient = pacient;
    }

    protected static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


    public CreateCallPage createCall() throws IOException, InterruptedException, ParseException {
        addNewCall()
                .sourceCall()
                .address()
                .birthDay()
                .gender()
                .complaint()
                .polis()
                .FIO()
                .caller()
                .telephone();
        return this;
    }

    public CreateCallPage createCall_Mkab() throws IOException, InterruptedException, ParseException {
        addNewCall()
                .sourceCall()
                .searchField()
                .addressPlus()
                .complaint()
                .caller()
                .telephone();
        return this;
    }

    @Step("создаю вызов через api")
    public void createCall_Api() throws JSONException {
//        DBScripts.finalizeCall_NPol(pacient.getNumberpol());
// TODO: 5/16/2019 мне не нравится что тут очищаем все вызовы оператора, тут нужно чистить вызов этого пациента
        HttpResponse hr = new CallDoctorHttp(pacient).execute();
        if (hr.getStatusLine().getStatusCode() != 200)
            throw new SkipException("Вызов не создан\n" + hr);
    }

    @Step("редактирую вызов")
    public CreateCallPage editCallPage(Pacient pacient) throws IOException, ParseException, InterruptedException {
        this.pacient = pacient;
        sourceCall()
                .sourceCall()
                .address()
                .birthDay()
                .addressPlus()
                .addressPlus()
                .complaint()
                .polis()
                .FIO()
                .caller()
                .telephone();
        LOGGER.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("редактирую вызов с МКАБ + СМП")
    public CreateCallPage editCallPage_Mkab(Pacient pacient) throws InterruptedException {
        this.pacient = pacient;
        sourceCall()
                .searchField()
                .addressPlus()
                .complaint()
                .caller()
                .telephone();
        LOGGER.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("очищаю все поля у карты")
    public CreateCallPage setDeafult() {
        $(By.id("source1")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        ElementsCollection selenideElements = $$(By.xpath("//button/span/mat-icon[contains(text(),'close')] | //svg[@height='16px']"));

        for (SelenideElement element : selenideElements) {
            if (element.isDisplayed())
                element.click();
            actions.sendKeys(Keys.ESCAPE).perform();
        }

        //        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        $(By.xpath("//input[@placeholder='Дом']")).clear();
        $(By.id("phone")).clear();
//        $(By.xpath("//label[@class='mat-checkbox-layout']")).clear();
        $(By.xpath("//input[@placeholder='Корпус']")).clear();
        $(By.xpath("//input[@placeholder='Строение']")).clear();
        $(By.xpath("//input[@placeholder='Квартира']")).clear();
        $(By.xpath("//input[@placeholder='П-д']")).clear();
        $(By.xpath("//input[@placeholder='Д-фон']")).clear();
        $(By.xpath("//input[@placeholder='Этаж']")).clear();
        $(By.xpath("//input[@placeholder='Серия']")).clear();
        $(By.xpath("//input[@placeholder='Номер полиса']")).clear();
        $(By.xpath("//input[@placeholder='Фамилия']")).clear();
        $(By.xpath("//input[@placeholder='Имя']")).clear();
        $(By.xpath("//input[@placeholder='Отчество']")).clear();
        $(By.xpath("//input[@placeholder='Дата рождения']")).clear();
        LOGGER.info("Карта вызова очищена для редактирования!");
        return this;
    }

    @Step("добавить новый вызов")
    public CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    @Step("выбор источника вызова")
    private CreateCallPage sourceCall() {
        try {
            if (pacient.getSource() == 1) {
                sourceReg.click();
            }
            if (pacient.getSource() == 2) {
                sourceSmp.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден источник вызова!");
        }
        return this;
    }

    @Step("поиск МКАБ")
    public CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(String.valueOf(pacient.getNumberpol()));
        $(By.xpath("//mat-option/span[contains(text(),'" + pacient.getFamily() + "')]")).click();
        return this;
    }

    @Step("ввод адреса")
    private CreateCallPage address() throws InterruptedException {
        if (pacient.getAddress1() != null && pacient.getAddress1() != "") {
            clearAddress();
            list_first_container(pacient.getAddress1());
        }
        if (pacient.getAddress2() != null && pacient.getAddress2() != "") {
            if (pacient.getAddress2adv() != null && pacient.getAddress2adv() != "") {
                Thread.sleep(1000);
                adress.sendKeys(pacient.getAddress3());
                $(By.xpath("//mat-option/span[contains(text(),'" + pacient.getAddress2adv() + "')]")).click();
            } else
                list_first_container(pacient.getAddress2());
        }
        if (pacient.getAddress3() != null && pacient.getAddress3() != "") {
            if (pacient.getAddress3adv() != null && pacient.getAddress3adv() != "") {
                Thread.sleep(1000);
                adress.sendKeys(pacient.getAddress3());
                $(By.xpath("//mat-option/span[contains(text(),'" + pacient.getAddress3adv() + "')]")).click();
            } else
                list_first_container(pacient.getAddress3());
        }
        if (pacient.getNumber() != null && pacient.getNumber() != "") {
            $(By.xpath("//input[@placeholder='Дом']")).setValue(pacient.getNumber());
        }
        addressPlus();
        return this;
    }

    @Step("выбрал адрес из выпадающего списка")
    public CreateCallPage list_first_container(String address) throws InterruptedException {
        adress.hover();
        Thread.sleep(1000);
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement address1 = driver.findElement(By.xpath("//input[@placeholder='Адрес']"));
        address1.sendKeys(address);
        Thread.sleep(1000);
        korpus.hover();
        Thread.sleep(1000);
        adress.hover();
        address1.sendKeys(" ");
        $(By.xpath("//mat-option/span[contains(text(),'" + address + "')]"))
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    @Step("очистить поле с адресом")
    void clearAddress() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        addressLoadWaiter();
        for (int k = 0; k < 10 && !adress.getValue().equals(""); k++) {
            cancelAdress.shouldBe(Condition.visible).click();
            LOGGER.info("очистил поле с адресом");
        }
    }

    @Step("жду загрузку адреса")
    void addressLoadWaiter() throws InterruptedException {
        if ($(By.xpath("//*[contains(text(),'Новый вызов')]")).isDisplayed()) {
            int i = 0;
            do {
                LOGGER.info("жду загрузку адреса");
                Thread.sleep(1000);
                i++;
            } while (!adress.getValue().equals("Московская обл.,") && i < 10);
            // TODO: 5/22/2019 эта проверка отображения элемента, нужна проверка по апи перед запуском тестов
            Assert.assertTrue(adress.getValue().equals("Московская обл.,"), "адрес не загрузился");
        }
    }

    @Step("уточняю адрес")
    private CreateCallPage addressPlus() {
        korpus.setValue(pacient.getBuilding());
        $(By.xpath("//input[@placeholder='Строение']")).setValue(pacient.getConstruction());
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(pacient.getAppartment());
        $(By.xpath("//input[@placeholder='П-д']")).setValue(String.valueOf(pacient.getEntrance()));
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(pacient.getCodedomophone());
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(String.valueOf(pacient.getFloor()));
        return this;
    }

    @Step("телефон")
    private CreateCallPage telephone() {
        try {
            if (!pacient.getPhone().equals(null)) {
                $(By.id("phone")).setValue(pacient.getPhone());
            }
            if (pacient.getPhone().equals("")) {
                $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден номер телефона у профиля!");
        }
        return this;
    }

    @Step("пол")
    private CreateCallPage gender() {
        if (pacient.getGender() == 1) {
            $(By.id("sex1")).click();
        }
        if (pacient.getGender() == 2) {
            $(By.id("sex2")).click();
        }
        return this;
    }

    @Step("жалоба")
    private CreateCallPage complaint() throws InterruptedException {
        SelenideElement complaint = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + pacient.getComplaint() + "';", complaint);
        complaint.sendKeys(Keys.SPACE);

        $(By.xpath("//span[contains(text(),'диатез')]")).click();
        $(By.xpath("//div[contains(text(),'" + pacient.getComplaint() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("полис")
    private CreateCallPage polis() {
        if (pacient.getSeriespol() != null && pacient.getSeriespol() != "") {
            $(By.xpath("//input[@placeholder='Серия']")).setValue(String.valueOf(pacient.getSeriespol()));
        }
        if (pacient.getNumberpol() != null && pacient.getNumberpol() != "") {
            $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(String.valueOf(pacient.getNumberpol()));
        }
        return this;
    }

    @Step("фио")
    private CreateCallPage FIO() {
        if (pacient.getFamily() != null) {
            $(By.xpath("//input[@placeholder='Фамилия']")).setValue(pacient.getFamily());
        }
        if (pacient.getName() != null) {
            $(By.xpath("//input[@placeholder='Имя']")).setValue(pacient.getName());
        }
        if (pacient.getOt() != null) {
            $(By.xpath("//input[@placeholder='Отчество']")).setValue(pacient.getOt());
        }
        return this;
    }

    @Step("день рождения")
    private CreateCallPage birthDay() {
        if (pacient.getBirthdate("") != null)
            $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(pacient.getBirthdate("dd-MM-yyyy"));
        return this;
    }

    @Step("возрастная категория")
    public CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        vKat.click();

        Date newData = new Date();
        Date bd = pacient.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        if (years > 18) {
            $(By.xpath("//span[contains(.,'Взрослые')]")).click();
        }
        if (years < 18) {
            $(By.xpath("//span[contains(.,'Дети')]")).click();
        }
        return this;
    }

    @Step("фио вызывающего")
    private CreateCallPage caller() {
        if (pacient.getSource() == 2) {
            $(By.id("sourceSmp")).setValue("Супер станция");
            $(By.id("callFamily")).setValue("ФамилияВызывающего");
            $(By.id("callName")).setValue("ИмяВызывающего");
            $(By.id("callPatronymic")).setValue("ОтчествоВызывающего");
        } else {
            if (years() > 18) {
                callerType.click();
                $(By.xpath("//span[contains(.,'Пациент')]")).click();
            } else {
                callerType.click();
                $(By.xpath("//span[contains(.,'Представитель')]")).click();
            }
        }
        return this;
    }

    @Step("количество лет")
    public int years() {
        Date newData = new Date();
        Date bd = pacient.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        return years;
    }

    @Step("кнопка сохранить")
    public CreateCallPage saveBtn() throws InterruptedException, NoticeException {
        Thread.sleep(1000);
        SelenideElement save = $(By.id("save"));
        save.click();
        return this;
    }

    @Step("кнопка сохранить")
    public CreateCallPage allertBtn() throws InterruptedException, NoticeException {
        SelenideElement allert = $(By.xpath("//button[@aria-label='Close dialog']"));
        allert.click();
        return this;
    }

    @Step("кнопка редактировать")
    public CreateCallPage editCallBtn() {
        $(By.id("change")).click();
        return this;
    }

    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPage verifyCallProfile1(Pacient pacient) {
        Assert.assertEquals(phone.getAttribute("value"), parseTelephone(pacient), "Номер телефона некорректный");
        Assert.assertEquals(nomerPol.getAttribute("value"), pacient.getNumberpol(), "Номер полиса некорректный");
        Assert.assertEquals(seriyaPol.getAttribute("value"), pacient.getSeriespol(), "Серия полса некорректная");
        Assert.assertEquals(fam.getAttribute("value"), pacient.getFamily(), "Фамилия некорректная");
        Assert.assertEquals(name.getAttribute("value"), pacient.getName(), "Имя некорректное");
        Assert.assertEquals(otchestvo.getAttribute("value"), pacient.getOt(), "Отчество некорректное");
        Assert.assertEquals(birthDateTemp.getAttribute("value"), pacient.getBirthdate("dd.MM.yyyy"), "Дата рождения некорректная");
//        Assert.assertEquals(age.getAttribute("value"), pacient.getAge(), "Возраст некорректный");
//        Assert.assertEquals(vKat.getAttribute("value"), pacient.getVkat(), "Возрастная категория некорректная");
        assertThat("Адрес некорректный", pacient.getAddress(), containsString(adress.getAttribute("value")));
        Assert.assertEquals(dom.getAttribute("value"), pacient.getNumber(), "Номер дома некорректный");
        Assert.assertEquals(korpus.getAttribute("value"), pacient.getBuilding(), "Номер корпуса некорректный");
        Assert.assertEquals(stroenie.getAttribute("value"), pacient.getConstruction(), "Номер строения некорректный");
        Assert.assertEquals(kvartira.getAttribute("value"), pacient.getAppartment(), "Номер квартиры некорректный");
        Assert.assertEquals(pd.getAttribute("value"), pacient.getEntrance(), "Номер подъезда некорректный");
        Assert.assertEquals(dfon.getAttribute("value"), pacient.getCodedomophone(), "Номер домофона некорректный");
        Assert.assertEquals(etazh.getAttribute("value"), pacient.getFloor(), "Номер этажа некорректный");
        LOGGER.info("Проверка данных на странице редактирования выполнена!");
        return this;
    }

    @Step("нажимаю на выпадающий список участков")
    public CreateCallPage selectUchastokFromNeUdalosOpredelit() {
        SelenideElement se = $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок для адреса')]")).shouldBe(Condition.visible);
        $(By.xpath("//mat-label[contains(text(),'Участок')]/../../..//mat-select")).click();
        return this;
    }

    @Step("очищаю ФИО кто вызывает")
    public CreateCallPage deleteWhoCallFIO() {
        famCall.clear();
        nameCall.clear();
        otCall.clear();
        return this;
    }

    @Step("станция СМП")
    public CreateCallPage fillSourceSmp() {
        sourceSmp2.val("тест");
        return this;
    }

    @Step("валидация что вызов не отменился на странице редактирования")
    public CreateCallPage verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("отменить вызов")
    public CreateCallPage cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'Редактирование вызова')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }
}