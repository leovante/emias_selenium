package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.pages.BasePage;
import com.pages.calldoctor.controllers.StAddress;
import com.utils.api_model.CallDoctorHttp;
import com.utils.except.NoticeException;
import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateCallPage extends BasePage {
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
    SelenideElement callerType_pacient = $(By.xpath("//span[contains(.,'Пациент')]"));
    SelenideElement callerType_predstavitel = $(By.xpath("//span[contains(.,'Представитель')]"));
    SelenideElement cancelBtn = $(By.id("cancelCall"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));
    SelenideElement cancelCall = $(By.xpath("//a[@title='Отменить вызов']"));
    SelenideElement kto_pacient_header = $x("//*[contains(text(),'КТО ПАЦИЕНТ')]");
    SelenideElement new_call_header = $x("//*[contains(text(),'Новый вызов')]");
    SelenideElement male = $(By.id("sex1"));
    SelenideElement female = $(By.id("sex2"));
    SelenideElement edit_call = $x("//*[contains(text(),'Редактирование вызова')]");
    SelenideElement change_call = $(By.id("change"));
    SelenideElement reason_cancel_call_validator = $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]"));
    SelenideElement unpin_mkab = $x("//img[@src='./assets/img/close.png']");
    SelenideElement complaint = $x("//input[@aria-label='Введите текст жалобы'] | //input[@aria-label='Добавить жалобу']");
    SelenideElement allertCloseDialog_Yes = $(By.xpath("//button/span[contains(text(),'Да')]"));
    ElementsCollection close_collections = $$(By.xpath("//button/span/mat-icon[contains(text(),'close')] | //svg[@height='16px']"));

    public CreateCallPage(Pacient pacient) throws IOException {
        this.pacient = pacient;
    }

    @Step("create simple call")
    public CreateCallPage createCall() throws InterruptedException {
        addNewCall()
                .sourceCall()
                .address()
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
    public CreateCallPage createCall_Mkab() throws InterruptedException {
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
    public void createCall_Api()   {
//        callDoctorService.cancelByNPol(pacient.getNumberpol());
        try {
            new CallDoctorHttp(pacient).execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Step("create authorize call via API")
    public void createCall_Api_Auth()   {
//        callDoctorService.cancelByNPol(pacient.getNumberpol());
        try {
            new CallDoctorHttp(pacient).executeAuth();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Step("edit call")
    public CreateCallPage editCallPage() throws InterruptedException {
        sourceCall()
                .sourceCall()
                .address()
                .birthDay()
                .addressPlus()
                .addressPlus()
                .complaint()
                .polis()
                .fio()
                .caller()
                .telephone();
        logger.info("Вызов отредактирован! " + driver.getCurrentUrl());
        return this;
    }

    @Step("create call with MKAB from SMP")
    public CreateCallPage editCallPage_Mkab() throws InterruptedException {
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
//        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        dom.clear();
        phone.clear();
//        $(By.xpath("//label[@class='mat-checkbox-layout']")).clear();
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
    private CreateCallPage complaint() throws InterruptedException {
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
        int years = (int) assistance.getDateDiff(bd, newData, TimeUnit.DAYS) / 365;
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
            if (assistance.years(pacient) > 18) {
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
    public CreateCallPage saveBtn() throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement save = $(By.id("save"));
        save.click();
        return this;
    }

    @Step("Address allert dialog - Yes button")
    public CreateCallPage allertBtn() throws InterruptedException {
        Thread.sleep(2000);
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