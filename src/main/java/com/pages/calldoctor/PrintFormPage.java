package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.pages.WebPage;
import com.commons.CallDoctorCards;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.commons.assistance.Assistance.*;
import static org.testng.Assert.assertTrue;

public class PrintFormPage extends WebPage {
    Pacient pacient;
    private SelenideElement
            doneCall = $(By.id("doneCall")),
            mat_calendar_header2 = $x("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']"),
            mat_calendar_header = $(By.id("")),
            setAnotherDoctor = $(By.xpath("//span[contains(text(),'Передать другому врачу')]")),
            appoindDoctorBtn = $(By.id("toDoctor")),
            completeServiceBtn = $(By.id("toDone")),
            toLpu = $(By.id("toLpu")),
            cancelCall2 = $(By.xpath("//a[@title='Отменить вызов']")),
            change = $(By.id("change")),
            cancelBtn = $(By.id("cancel")),
            cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']")),
            cancelCall = $(By.id("cancelCall")),
            cardNumber = $(By.xpath("//div[contains(text(),'Карта вызова №')]"));

    @Autowired
    public CallDoctorCards callDoctorCards;

    public PrintFormPage(String testName) throws IOException {
        callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
    }

    public PrintFormPage(Pacient pacient, String testName) {
        this.pacient = pacient;
        callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
    }

    @Step("проверяю наличие базовых элементов карты вызова")
    public void baseElements() {
        ArrayList<String> elements = new ArrayList<>();
        elements.add("Карта вызова");
        elements.add("Дата");
        elements.add("Время");
        elements.add("Статус");
        elements.add("Вид вызова");
        elements.add("Источник");
        elements.add("КТО ПАЦИЕНТ");
        elements.add("Возраст");
        if (pacient.getGender() != 0)
            elements.add("Пол");
        elements.add("АДРЕС");
        elements.add("ЖАЛОБЫ");
        elements.add("КТО ПАЦИЕНТ");
        elements.add("КТО ВЫЗВАЛ");
        elements.add("КТО ОБСЛУЖИВАЕТ");
        elements.add("Возрастная категория");
        elements.add("Телефон");
        elements.add("Врач");
        for (String element : elements) {
            $x("//*[contains(.,'" + element + "')]").shouldBe(Condition.visible);
        }
    }

    @Step("проверяю наличие базовых элементов пациента")
    public void basePacient() {
        visible(pacient.getAddress());
        visible(pacient.getComplaint());
        visible(pacient.getCodedomophone());
        visible(parseTelephone(pacient));
        visible(String.valueOf(pacient.getEntrance()));
        visible(String.valueOf(pacient.getFloor()));
        visible(pacient.getName());
        visible(pacient.getFamily());
        visible(pacient.getOt());
        visible(String.valueOf(pacient.getBirthdate("dd.MM.yyyy")));
        visible(String.valueOf(pacient.getSeriespol()));
        visible(String.valueOf(pacient.getNumberpol()));
        if (pacient.getKladraddress() != null) {
            visible(pacient.getAppartment());
            visible(pacient.getBuilding());
            visible(pacient.getConstruction());
        }
    }

    @Step("проверяю наличие базовых элементов врача")
    public void baseDoctor(Doctor doctor) {
        visible(doctor.getName());
        visible(doctor.getFamily());
        visible(doctor.getOt());
        visible(doctor.getDepartment());
        visible(doctor.getUchastocs());
    }

    @Step("проверка времени")
    public void verifyTime() {
        ArrayList dateList = currentTimeList("HH:mm");
        String timeCard = $(By.xpath("//span[contains(text(),'Время')]")).$(By.xpath("../.")).$(By.xpath("./span[2]")).getText();
        assertTimeContains(dateList, timeCard);
    }

    @Step("проверяю время из списка")
    void assertTimeContains(ArrayList curTime, String expTime) {
        logger.info("curTime: " + curTime + "\n" + "expTime: " + expTime);
        assertTrue(curTime.contains(expTime), "Время вызова не корректно!");
    }

    @Step("проверяю новый вызов")
    public PrintFormPage verifyNewCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Новый')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        verifyTime();
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public PrintFormPage verifyActivCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Активный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public PrintFormPage verifyDoneCall(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'Обслуженный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        baseDoctor(doctor);
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("отменить вызов")
    public PrintFormPage cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public PrintFormPage cancelOnChangePageBtn() {
        $(By.xpath("//*[contains(.,'" + "Редактирование вызова" + "')]")).shouldBe(Condition.visible);
        cancelCall.click();
        cancelField.setValue("отмена автотестом");
        cancelCall2.click();
        return this;
    }

    @Step("передать другому врачу")
    public PrintFormPage changeDoctorBtn() {
        setAnotherDoctor.click();
        return this;
    }

    @Step("назначить врача")
    public PrintFormPage chooseDoctorBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).shouldBe(Condition.visible);
        appoindDoctorBtn.hover().click();
        return this;
    }

    @Step("завершить обслуживание")
    public PrintFormPage completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        completeServiceBtn.click();
//        mat_calendar_header.click();
//        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public PrintFormPage editCallBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public PrintFormPage closeCardBtn() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//span/mat-icon[contains(text(),'close')]")).click();
        logger.info("Карта закрыта!");
        return this;
    }

    @Step("проверяем что кнопка МКАБ не активна")
    public PrintFormPage verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка МКАБ активна")
    public PrintFormPage verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath(".//*[@class='mat-icon call-doctor-red-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП не активна")
    public PrintFormPage verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП активна")
    public PrintFormPage verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public PrintFormPage transferToDepartBtn() {
        toLpu.click();
        $(By.xpath("//*[contains(text(),'Выберите куда передать вызов')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public PrintFormPage verifyDepartment(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'" + doctor.getDepartment() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("сохранить распознанный адрес")
    public PrintFormPage saveAdressAsKladr() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }

    @Step("проверить врача")
    public PrintFormPage verifyDoctor(Doctor doctor) {
        $(By.xpath("//*[contains(.,'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на подробной странице")
    public PrintFormPage verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("нажимаю на кнопку печати")
    public PrintFormPage printBtn() throws InterruptedException {
        $x("//div[@id='viewPrint']/mat-icon").click();
        return this;
    }
}