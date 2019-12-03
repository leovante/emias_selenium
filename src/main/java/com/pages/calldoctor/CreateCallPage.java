package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Pacient;
import com.pages.WebPage;
import com.pages.calldoctor.controllers.StAddress;
import com.utils.api_model.CallDoctorHttp;
import io.qameta.allure.Step;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.utils.assistance.Assistance.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateCallPage extends WebPage {
    private Pacient pacient;
    private SelenideElement
            cancelAdress = $x("//*[@id='4198BD84-7A21-4E38-B36B-3ECB2E956408']"),
            list_first_container = $x("//div[@class='autocomplete-list-container']/ul/li"),
            dom = $x("//input[@placeholder='Дом']"),
            vKat = $x("//input[@placeholder='Возр. категория']"),
            korpus = $x("//input[@placeholder='Корпус']"),
            stroenie = $x("//input[@placeholder='Строение']"),
            kvartira = $x("//input[@placeholder='Квартира']"),
            pd = $x("//input[@placeholder='П-д']"),
            dfon = $x("//input[@placeholder='Д-фон']"),
            etazh = $x("//input[@placeholder='Этаж']"),
            seriyaPol = $x("//input[@placeholder='Серия']"),
            nomerPol = $x("//input[@placeholder='Номер полиса']"),
            fam = $x("//input[@placeholder='Фамилия']"),
            name = $x("//input[@placeholder='Имя']"),
            otchestvo = $x("//input[@placeholder='Отчество']"),
            birthDateTemp = $x("//input[@placeholder='Дата рождения']"),
            phone = $(By.id("phone")),
            famCall = $(By.id("callFamily")),
            nameCall = $(By.id("callName")),
            otCall = $(By.id("callPatronymic")),
            sourceSmp = $(By.id("source0")),
            sourceSmp2 = $(By.id("sourceSmp")),
            sourceReg = $(By.id("source1")),
            callerType = $x("//mat-select[@aria-label='Тип вызывающего']"),
            callerType_pacient = $x("//span[contains(.,'Пациент')]"),
            callerType_predstavitel = $x("//span[contains(.,'Представитель')]"),
            cancelBtn = $(By.id("cancelCall")),
            cancelField = $x("//input[@placeholder='Причина отмены вызова']"),
            cancelCall = $x("//a[@title='Отменить вызов']"),
            kto_pacient_header = $x("//*[contains(text(),'КТО ПАЦИЕНТ')]"),
            new_call_header = $x("//*[contains(text(),'Новый вызов')]"),
            male = $(By.id("sex1")),
            female = $(By.id("sex2")),
            edit_call = $x("//*[contains(text(),'Редактирование вызова')]"),
            change_call = $(By.id("change")),
            reason_cancel_call_validator = $x("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]"),
            unpin_mkab = $x("//img[@src='./assets/img/close.png']"),
            complaint = $x("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']"),
            allertCloseDialog_Yes = $x("//button/span[contains(text(),'Да')]");
    ElementsCollection close_collections = $$x("//button/span/mat-icon[contains(text(),'close')] | //svg[@height='16px']");

    CreateCallPage() {
        super();
    }

    CreateCallPage(Pacient pacient) {
        this.pacient = pacient;
    }

    @Step("create simple call")
    public CreateCallPage createCall() {
        addNewCall()
                .sourceCall()
                .address()
                .addressPlus()
                .birthDay()
                .gender()
                .complaint()
                .polis()
                .fio()
                .telephone()
                .caller()
                .saveBtn()
                .allertBtn();
        return this;
    }

    @Step("create call with MKAB")
    public CreateCallPage createCall_Mkab() {
        addNewCall()
                .sourceCall()
                .searchField()
                .addressPlus()
                .complaint()
                .telephone()
                .caller()
                .saveBtn();
        return this;
    }

    @Step("create call via API")
    public void createCall_Api() {
        try {
            new CallDoctorHttp(pacient).execute();
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Step("create authorize call via API")
    public void createCall_Api_Auth() {
        try {
            new CallDoctorHttp(pacient).executeAuth();
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Step("edit call")
    public CreateCallPage editCallPage() {
        sourceCall()
                .sourceCall()
                .address()
                .addressPlus()
                .birthDay()
                .complaint()
                .polis()
                .fio()
                .caller()
                .telephone();
        logger.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("create call with MKAB from SMP")
    public CreateCallPage editCallPage_Mkab() {
        sourceCall()
                .searchField()
                .addressPlus()
                .complaint()
                .caller()
                .telephone();
        logger.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("clear all field in card")
    public CreateCallPage setDeafult() {
        sourceReg.click();
        if (unpin_mkab.is(Condition.visible)) {
            unpin_mkab.click();
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        for (SelenideElement element : close_collections) {
            if (element.isDisplayed())
                element.click();
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        dom.clear();
        phone.clear();
        korpus.clear();
        stroenie.clear();
        kvartira.clear();
        pd.clear();
        dfon.clear();
        etazh.clear();
        seriyaPol.clear();
        nomerPol.clear();
        fam.clear();
        name.clear();
        otchestvo.clear();
        birthDateTemp.clear();
        logger.info("Card is clear!");
        return this;
    }

    @Step("add new call")
    public CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    @Step("search MKAB")
    public CreateCallPage searchField() {
        $(By.id("findPatientInput")).setValue(String.valueOf(pacient.getNumberpol()));
        $x("//mat-option/span[contains(text(),'" + pacient.getFamily() + "')]").click();
        return this;
    }

    @Step("shose source call")
    private CreateCallPage sourceCall() {
        try {
            if (pacient.getSource() == 1) {
                sourceReg.click();
            }
            if (pacient.getSource() == 2) {
                sourceSmp.click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Error. source don't find!");
        }
        return this;
    }

    @Step("enter address")
    private CreateCallPage address() {
        stAddress = new StAddress(pacient);
        stAddress.clearAddress();
        stAddress.write(pacient.getAddress1())
                .write(pacient.getAddress2(), pacient.getAddress2adv())
                .write(pacient.getAddress3(), pacient.getAddress3adv())
                .dom(pacient.getNumber());
        return this;
    }

    @Step("specify address")
    private CreateCallPage addressPlus() {
        korpus.setValue(pacient.getBuilding());
        stroenie.setValue(pacient.getConstruction());
        kvartira.setValue(pacient.getAppartment());
        pd.setValue(String.valueOf(pacient.getEntrance()));
        dfon.setValue(pacient.getCodedomophone());
        etazh.setValue(String.valueOf(pacient.getFloor()));
        return this;
    }

    @Step("enter telephone")
    private CreateCallPage telephone() {
        try {
            if (!pacient.getPhone().equals(null)) {
                phone.setValue(pacient.getPhone());
            }
            if (pacient.getPhone().equals("")) {
                $x("//label[@class='mat-checkbox-layout']").click();
            }
        } catch (Exception e) {
            throw new InvalidArgumentException("Ошибка, не найден номер телефона у профиля!");
        }
        return this;
    }

    @Step("select sex")
    private CreateCallPage gender() {
        switch (pacient.getGender()) {
            case (1):
                male.click();
            case (2):
                female.click();
        }
        return this;
    }

    @Step("complaint")
    private CreateCallPage complaint() {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].value='" + pacient.getComplaint() + "'", complaint);
//        complaint.sendKeys(Keys.ENTER);
//        complaint.sendKeys("123");
        String a = pacient.getComplaint();
        complaint.sendKeys(a);
        $x("//span[contains(text(),'диатез')]").click();
        $x("//div[contains(text(),'" + pacient.getComplaint() + "')]").shouldBe(Condition.visible);
        return this;
    }

    @Step("enter polis")
    private CreateCallPage polis() {
        if (pacient.getSeriespol() != null && pacient.getSeriespol() != "") {
            $(By.xpath("//input[@placeholder='Серия']")).setValue(String.valueOf(pacient.getSeriespol()));
        }
        if (pacient.getNumberpol() != null && pacient.getNumberpol() != "") {
            $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(String.valueOf(pacient.getNumberpol()));
        }
        return this;
    }

    @Step("fio")
    private CreateCallPage fio() {
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

    @Step("birthday")
    private CreateCallPage birthDay() {
        if (pacient.getBirthdate("") != null)
            $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(pacient.getBirthdate("dd-MM-yyyy"));
        return this;
    }

    @Step("age group")
    private CreateCallPage vozrastKat() {
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

    @Step("caller fio")
    private CreateCallPage caller() {
        if (pacient.getSource() == 2) {
            $(By.id("sourceSmp")).setValue("Супер станция");
            $(By.id("callFamily")).setValue("ФамилияВызывающего");
            $(By.id("callName")).setValue("ИмяВызывающего");
            $(By.id("callPatronymic")).setValue("ОтчествоВызывающего");
        } else {
            if (years(pacient) > 18) {
                callerType.click();
                callerType_pacient.click();
            } else {
                callerType.click();
                callerType_predstavitel.click();
            }
        }
        return this;
    }

    @Step("click save button")
    public CreateCallPage saveBtn() {
        sleep(1000);
        SelenideElement save = $(By.id("save"));
        save.click();
        return this;
    }

    @Step("Address allert dialog - Yes button")
    public CreateCallPage allertBtn() {
        sleep(2000);
        if (allertCloseDialog_Yes.is(Condition.visible))
            allertCloseDialog_Yes.click();
        return this;
    }

    @Step("click edit button")
    public CreateCallPage editCallBtn() {
        change_call.click();
        return this;
    }

    // TODO: 9/18/2019 нужно как то вынести это отдельно и унаследоваться двумя классами
    @Step("проверяю на странице редактирования корректность данных")
    public CreateCallPage verifyCallProfile1(Pacient pacient) {
        Assert.assertEquals(phone.getAttribute("value"), parseTelephone(pacient), "Номер телефона некорректный");
        Assert.assertEquals(nomerPol.getAttribute("value"), pacient.getNumberpol(), "Номер полиса некорректный");
        Assert.assertEquals(seriyaPol.getAttribute("value"), pacient.getSeriespol(), "Серия полса некорректная");
        Assert.assertEquals(fam.getAttribute("value"), pacient.getFamily(), "Фамилия некорректная");
        Assert.assertEquals(name.getAttribute("value"), pacient.getName(), "Имя некорректное");
        Assert.assertEquals(otchestvo.getAttribute("value"), pacient.getOt(), "Отчество некорректное");
        Assert.assertEquals(birthDateTemp.getAttribute("value"), pacient.getBirthdate("dd.MM.yyyy"), "Дата рождения некорректная");
//        Assert.assertEquals(age.getAttribute("value"), doctor.getAge(), "Возраст некорректный");
//        Assert.assertEquals(vKat.getAttribute("value"), doctor.getVkat(), "Возрастная категория некорректная");
        assertThat("Адрес некорректный", pacient.getAddress(), containsString(stAddress.getAddressSE().getAttribute("value")));
        Assert.assertEquals(dom.getAttribute("value"), pacient.getNumber(), "Номер дома некорректный");
        Assert.assertEquals(korpus.getAttribute("value"), pacient.getBuilding(), "Номер корпуса некорректный");
        Assert.assertEquals(stroenie.getAttribute("value"), pacient.getConstruction(), "Номер строения некорректный");
        Assert.assertEquals(kvartira.getAttribute("value"), pacient.getAppartment(), "Номер квартиры некорректный");
        Assert.assertEquals(pd.getAttribute("value"), pacient.getEntrance(), "Номер подъезда некорректный");
        Assert.assertEquals(dfon.getAttribute("value"), pacient.getCodedomophone(), "Номер домофона некорректный");
        Assert.assertEquals(etazh.getAttribute("value"), pacient.getFloor(), "Номер этажа некорректный");
        logger.info("Проверка данных на странице редактирования выполнена!");
        return this;
    }

    @Step("нажимаю на выпадающий список участков")
    public CreateCallPage selectUchastokFromNeUdalosOpredelit() {
        $x("//*[contains(text(),'Не удалось однозначно определить участок для адреса')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'Участок')]").click();
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
    public CreateCallPage verifyCancellCallValidation() {
        reason_cancel_call_validator.shouldBe(Condition.visible);
        sleep(2000);
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