package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
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

public class CreateCallPageBase extends PageBase {
    private Pacient pacientImpl;
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

    public CreateCallPageBase(Pacient pacientImpl) {
        this.pacientImpl = pacientImpl;
    }

    protected static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


    public CreateCallPageBase createCall() throws IOException, InterruptedException, ParseException {
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

    public CreateCallPageBase createCall_Mkab() throws IOException, InterruptedException, ParseException {
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
        HttpResponse hr = new CallDoctorHttp(pacientImpl).execute();
        if (hr.getStatusLine().getStatusCode() != 200)
            throw new SkipException("Вызов не создан\n" + hr);
    }

    @Step("редактирую вызов")
    public CreateCallPageBase editCallPage(PacientImpl pacientImpl) throws IOException, ParseException, InterruptedException {
        this.pacientImpl = pacientImpl;
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
    public CreateCallPageBase editCallPage_Mkab(PacientImpl pacientImpl) throws InterruptedException {
        this.pacientImpl = pacientImpl;
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
    public CreateCallPageBase setDeafult() {
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
    public CreateCallPageBase addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    @Step("выбор источника вызова")
    private CreateCallPageBase sourceCall() {
        try {
            if (pacientImpl.getSource() == 1) {
                sourceReg.click();
            }
            if (pacientImpl.getSource() == 2) {
                sourceSmp.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден источник вызова!");
        }
        return this;
    }

    @Step("поиск МКАБ")
    public CreateCallPageBase searchField() {
        $(By.id("findPatientInput")).setValue(String.valueOf(pacientImpl.getNumberpol()));
        $(By.xpath("//mat-option/span[contains(text(),'" + pacientImpl.getFamily() + "')]")).click();
        return this;
    }

    @Step("ввод адреса")
    private CreateCallPageBase address() throws InterruptedException {
        if (pacientImpl.getAddress1() != null && pacientImpl.getAddress1() != "") {
            clearAddress();
            list_first_container(pacientImpl.getAddress1());
        }
        if (pacientImpl.getAddress2() != null && pacientImpl.getAddress2() != "") {
            if (pacientImpl.getAddress2adv() != null && pacientImpl.getAddress2adv() != "") {
                Thread.sleep(1000);
                adress.sendKeys(pacientImpl.getAddress3());
                $(By.xpath("//mat-option/span[contains(text(),'" + pacientImpl.getAddress2adv() + "')]")).click();
            } else
                list_first_container(pacientImpl.getAddress2());
        }
        if (pacientImpl.getAddress3() != null && pacientImpl.getAddress3() != "") {
            if (pacientImpl.getAddress3adv() != null && pacientImpl.getAddress3adv() != "") {
                Thread.sleep(1000);
                adress.sendKeys(pacientImpl.getAddress3());
                $(By.xpath("//mat-option/span[contains(text(),'" + pacientImpl.getAddress3adv() + "')]")).click();
            } else
                list_first_container(pacientImpl.getAddress3());
        }
        if (pacientImpl.getNumber() != null && pacientImpl.getNumber() != "") {
            $(By.xpath("//input[@placeholder='Дом']")).setValue(pacientImpl.getNumber());
        }
        addressPlus();
        return this;
    }

    @Step("выбрал адрес из выпадающего списка")
    public CreateCallPageBase list_first_container(String address) throws InterruptedException {
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
    private CreateCallPageBase addressPlus() {
        korpus.setValue(pacientImpl.getBuilding());
        $(By.xpath("//input[@placeholder='Строение']")).setValue(pacientImpl.getConstruction());
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(pacientImpl.getAppartment());
        $(By.xpath("//input[@placeholder='П-д']")).setValue(String.valueOf(pacientImpl.getEntrance()));
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(pacientImpl.getCodedomophone());
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(String.valueOf(pacientImpl.getFloor()));
        return this;
    }

    @Step("телефон")
    private CreateCallPageBase telephone() {
        try {
            if (!pacientImpl.getPhone().equals(null)) {
                $(By.id("phone")).setValue(pacientImpl.getPhone());
            }
            if (pacientImpl.getPhone().equals("")) {
                $(By.xpath("//label[@class='mat-checkbox-layout']")).click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден номер телефона у профиля!");
        }
        return this;
    }

    @Step("пол")
    private CreateCallPageBase gender() {
        if (pacientImpl.getGender() == 1) {
            $(By.id("sex1")).click();
        }
        if (pacientImpl.getGender() == 2) {
            $(By.id("sex2")).click();
        }
        return this;
    }

    @Step("жалоба")
    private CreateCallPageBase complaint() throws InterruptedException {
        SelenideElement complaint = $(By.xpath("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + pacientImpl.getComplaint() + "';", complaint);
        complaint.sendKeys(Keys.SPACE);

        $(By.xpath("//span[contains(text(),'диатез')]")).click();
        $(By.xpath("//div[contains(text(),'" + pacientImpl.getComplaint() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("полис")
    private CreateCallPageBase polis() {
        if (pacientImpl.getSeriespol() != null && pacientImpl.getSeriespol() != "") {
            $(By.xpath("//input[@placeholder='Серия']")).setValue(String.valueOf(pacientImpl.getSeriespol()));
        }
        if (pacientImpl.getNumberpol() != null && pacientImpl.getNumberpol() != "") {
            $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(String.valueOf(pacientImpl.getNumberpol()));
        }
        return this;
    }

    @Step("фио")
    private CreateCallPageBase FIO() {
        if (pacientImpl.getFamily() != null) {
            $(By.xpath("//input[@placeholder='Фамилия']")).setValue(pacientImpl.getFamily());
        }
        if (pacientImpl.getName() != null) {
            $(By.xpath("//input[@placeholder='Имя']")).setValue(pacientImpl.getName());
        }
        if (pacientImpl.getOt() != null) {
            $(By.xpath("//input[@placeholder='Отчество']")).setValue(pacientImpl.getOt());
        }
        return this;
    }

    @Step("день рождения")
    private CreateCallPageBase birthDay() {
        if (pacientImpl.getBirthdate("") != null)
            $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(pacientImpl.getBirthdate("dd-MM-yyyy"));
        return this;
    }

    @Step("возрастная категория")
    public CreateCallPageBase vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        vKat.click();

        Date newData = new Date();
        Date bd = pacientImpl.getBirthdate();
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
    private CreateCallPageBase caller() {
        if (pacientImpl.getSource() == 2) {
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
        Date bd = pacientImpl.getBirthdate();
        int years = (int) getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
        return years;
    }

    @Step("кнопка сохранить")
    public CreateCallPageBase saveBtn() throws InterruptedException, NoticeException {
        Thread.sleep(1000);
        SelenideElement save = $(By.id("save"));
        save.click();
        return this;
    }

    @Step("кнопка сохранить")
    public CreateCallPageBase allertBtn() throws InterruptedException, NoticeException {
        SelenideElement allert = $(By.xpath("//button[@aria-label='Close dialog']"));
        allert.click();
        return this;
    }

    @Step("кнопка редактировать")
    public CreateCallPageBase editCallBtn() {
        $(By.id("change")).click();
        return this;
    }

    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPageBase verifyCallProfile1(PacientImpl pacientImpl) {
        Assert.assertEquals(phone.getAttribute("value"), parseTelephone(pacientImpl), "Номер телефона некорректный");
        Assert.assertEquals(nomerPol.getAttribute("value"), pacientImpl.getNumberpol(), "Номер полиса некорректный");
        Assert.assertEquals(seriyaPol.getAttribute("value"), pacientImpl.getSeriespol(), "Серия полса некорректная");
        Assert.assertEquals(fam.getAttribute("value"), pacientImpl.getFamily(), "Фамилия некорректная");
        Assert.assertEquals(name.getAttribute("value"), pacientImpl.getName(), "Имя некорректное");
        Assert.assertEquals(otchestvo.getAttribute("value"), pacientImpl.getOt(), "Отчество некорректное");
        Assert.assertEquals(birthDateTemp.getAttribute("value"), pacientImpl.getBirthdate("dd.MM.yyyy"), "Дата рождения некорректная");
//        Assert.assertEquals(age.getAttribute("value"), pacient.getAge(), "Возраст некорректный");
//        Assert.assertEquals(vKat.getAttribute("value"), pacient.getVkat(), "Возрастная категория некорректная");
        assertThat("Адрес некорректный", pacientImpl.getAddress(), containsString(adress.getAttribute("value")));
        Assert.assertEquals(dom.getAttribute("value"), pacientImpl.getNumber(), "Номер дома некорректный");
        Assert.assertEquals(korpus.getAttribute("value"), pacientImpl.getBuilding(), "Номер корпуса некорректный");
        Assert.assertEquals(stroenie.getAttribute("value"), pacientImpl.getConstruction(), "Номер строения некорректный");
        Assert.assertEquals(kvartira.getAttribute("value"), pacientImpl.getAppartment(), "Номер квартиры некорректный");
        Assert.assertEquals(pd.getAttribute("value"), pacientImpl.getEntrance(), "Номер подъезда некорректный");
        Assert.assertEquals(dfon.getAttribute("value"), pacientImpl.getCodedomophone(), "Номер домофона некорректный");
        Assert.assertEquals(etazh.getAttribute("value"), pacientImpl.getFloor(), "Номер этажа некорректный");
        LOGGER.info("Проверка данных на странице редактирования выполнена!");
        return this;
    }

    @Step("нажимаю на выпадающий список участков")
    public CreateCallPageBase selectUchastokFromNeUdalosOpredelit() {
        SelenideElement se = $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок для адреса')]")).shouldBe(Condition.visible);
        $(By.xpath("//mat-label[contains(text(),'Участок')]/../../..//mat-select")).click();
        return this;
    }

    @Step("очищаю ФИО кто вызывает")
    public CreateCallPageBase deleteWhoCallFIO() {
        famCall.clear();
        nameCall.clear();
        otCall.clear();
        return this;
    }

    @Step("станция СМП")
    public CreateCallPageBase fillSourceSmp() {
        sourceSmp2.val("тест");
        return this;
    }

    @Step("валидация что вызов не отменился на странице редактирования")
    public CreateCallPageBase verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("отменить вызов")
    public CreateCallPageBase cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'Редактирование вызова')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }
}