package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.controllers.StAddress;
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
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateCallPage extends PageBase {
    private Pacient pacient;
    SelenideElement cancelAdress = $(By.xpath("//*[@id='4198BD84-7A21-4E38-B36B-3ECB2E956408']"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));

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
    SelenideElement kto_pacient_header = $x("//*[contains(text(),'КТО ПАЦИЕНТ')]");
    SelenideElement new_call_header = $x("//*[contains(text(),'Новый вызов')]");
    SelenideElement male = $(By.id("sex1"));
    SelenideElement female = $(By.id("sex2"));
    SelenideElement edit_call = $x("//*[contains(text(),'Редактирование вызова')]");
    SelenideElement reason_cancel_call_validator = $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]"));

    public CreateCallPage(Pacient pacient) throws IOException {
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
//        DBScripts.finalizeCall_NPol(doctor.getNumberpol());
        // TODO: 5/16/2019 мне не нравится что тут очищаем все вызовы оператора, тут нужно чистить вызов этого пациента
        HttpResponse hr = new CallDoctorHttp(pacient).execute();
        if (hr.getStatusLine().getStatusCode() != 200)
            throw new SkipException("Вызов не создан\n" + hr);
    }

    @Step("редактирую вызов")
    public CreateCallPage editCallPage(PacientImpl pacientImpl) throws IOException, ParseException, InterruptedException {
        this.pacient = pacientImpl;
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
    public CreateCallPage editCallPage_Mkab(PacientImpl pacientImpl) throws InterruptedException {
        this.pacient = pacientImpl;
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
        stAddress = new StAddress(pacient);
        stAddress.clearAddress();
        stAddress.write(pacient.getAddress1())
                .write(pacient.getAddress2(), pacient.getAddress2adv())
                .write(pacient.getAddress3(), pacient.getAddress3adv())
                .dom(pacient.getNumber());
        addressPlus();
        return this;
    }




    /*@Step("жду загрузку адреса")
    void addressLoadWaiter() throws InterruptedException {
        kto_pacient_header.shouldBe(Condition.visible);
        if (new_call_header.isDisplayed()) {
            int i = 0;
            do {
                LOGGER.info("жду загрузку адреса");
                Thread.sleep(1000);
                i++;
            } while (!adress.$x("..//mat-chip[contains(text(),'Московская обл.,')]").is(Condition.visible) && i < 10);
            Assert.assertTrue(adress.$x("..//mat-chip[contains(text(),'Московская обл.,')]").is(Condition.visible), "адрес не загрузился");
        }
    }*/

    @Step("уточняю адрес")
    private CreateCallPage addressPlus() {
        korpus.setValue(pacient.getBuilding());
        stroenie.setValue(pacient.getConstruction());
        kvartira.setValue(pacient.getAppartment());
        pd.setValue(String.valueOf(pacient.getEntrance()));
        dfon.setValue(pacient.getCodedomophone());
        etazh.setValue(String.valueOf(pacient.getFloor()));
        return this;
    }

    @Step("телефон")
    private CreateCallPage telephone() {
        try {
            if (!pacient.getPhone().equals(null)) {
                phone.setValue(pacient.getPhone());
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
        switch (pacient.getGender()) {
            case (1):
                male.click();
            case (2):
                female.click();
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
    public CreateCallPage verifyCallProfile1(PacientImpl pacientImpl) {
        Assert.assertEquals(phone.getAttribute("value"), parseTelephone(pacientImpl), "Номер телефона некорректный");
        Assert.assertEquals(nomerPol.getAttribute("value"), pacientImpl.getNumberpol(), "Номер полиса некорректный");
        Assert.assertEquals(seriyaPol.getAttribute("value"), pacientImpl.getSeriespol(), "Серия полса некорректная");
        Assert.assertEquals(fam.getAttribute("value"), pacientImpl.getFamily(), "Фамилия некорректная");
        Assert.assertEquals(name.getAttribute("value"), pacientImpl.getName(), "Имя некорректное");
        Assert.assertEquals(otchestvo.getAttribute("value"), pacientImpl.getOt(), "Отчество некорректное");
        Assert.assertEquals(birthDateTemp.getAttribute("value"), pacientImpl.getBirthdate("dd.MM.yyyy"), "Дата рождения некорректная");
//        Assert.assertEquals(age.getAttribute("value"), doctor.getAge(), "Возраст некорректный");
//        Assert.assertEquals(vKat.getAttribute("value"), doctor.getVkat(), "Возрастная категория некорректная");
        assertThat("Адрес некорректный", pacientImpl.getAddress(), containsString(stAddress.getAddressSE().getAttribute("value")));
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
        reason_cancel_call_validator.shouldBe(Condition.visible);
        Thread.sleep(2000);
        kto_pacient_header.shouldBe(Condition.visible);
        return this;
    }

    @Step("отменить вызов")
    public CreateCallPage cancelOnFullCardBtn(String reason) {
        edit_call.shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }
}