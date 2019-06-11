package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.CallDoctorCards;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class PrintFormPageBase extends PageBase {
    PacientImpl pacientImpl;
    SelenideElement doneCall = $(By.id("doneCall"));
    SelenideElement mat_calendar_header2 = $x("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']");
    SelenideElement mat_calendar_header = $(By.id(""));
    SelenideElement setAnotherDoctor = $(By.xpath("//span[contains(text(),'Передать другому врачу')]"));
    SelenideElement appoindDoctorBtn = $(By.id("toDoctor"));
    SelenideElement completeServiceBtn = $(By.id("toDone"));
    SelenideElement toLpu = $(By.id("toLpu"));
    SelenideElement cancelCall2 = $(By.xpath("//a[@title='Отменить вызов']"));
    SelenideElement change = $(By.id("change"));
    SelenideElement cancelBtn = $(By.id("cancel"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));
    SelenideElement cancelCall = $(By.id("cancelCall"));
    SelenideElement cardNumber = $(By.xpath("//div[contains(text(),'Карта вызова №')]"));

    @Autowired
    public CallDoctorCards callDoctorCards;

    public PrintFormPageBase(String testName) {
        callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
    }

    public PrintFormPageBase(PacientImpl pacientImpl, String testName) {
        this.pacientImpl = pacientImpl;
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
        if (pacientImpl.getGender() != 0)
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
        isVisibleText(pacientImpl.getAddress());
        isVisibleText(pacientImpl.getComplaint());
        isVisibleText(pacientImpl.getCodedomophone());
        isVisibleText(parseTelephone(pacientImpl));
        isVisibleText(String.valueOf(pacientImpl.getEntrance()));
        isVisibleText(String.valueOf(pacientImpl.getFloor()));
        isVisibleText(pacientImpl.getName());
        isVisibleText(pacientImpl.getFamily());
        isVisibleText(pacientImpl.getOt());
        isVisibleText(String.valueOf(pacientImpl.getBirthdate("dd.MM.yyyy")));
        isVisibleText(String.valueOf(pacientImpl.getSeriespol()));
        isVisibleText(String.valueOf(pacientImpl.getNumberpol()));
        if (pacientImpl.getKladraddress() != null) {
            isVisibleText(pacientImpl.getAppartment());
            isVisibleText(pacientImpl.getBuilding());
            isVisibleText(pacientImpl.getConstruction());
        }
    }

    @Step("проверяю наличие базовых элементов врача")
    public void baseDoctor(Doctor doctor) {
        isVisibleText(doctor.getName());
        isVisibleText(doctor.getFamily());
        isVisibleText(doctor.getOt());
        isVisibleText(doctor.getDepartment());
        isVisibleText(doctor.getUchastocs());
    }

    @Step("проверка времени")
    public void verifyTime() {
        ArrayList dateList = currentTimeList("HH:mm");
        String timeCard = $(By.xpath("//span[contains(text(),'Время')]")).$(By.xpath("../.")).$(By.xpath("./span[2]")).getText();
        assertTimeContains(dateList, timeCard);
    }

    @Step("проверяю время из списка")
    void assertTimeContains(ArrayList curTime, String expTime) {
        LOGGER.info("curTime: " + curTime + "\n" + "expTime: " + expTime);
        assertTrue(curTime.contains(expTime), "Время вызова не корректно!");
    }

    @Step("проверяю новый вызов")
    public PrintFormPageBase verifyNewCall(PacientImpl pacientImpl) throws IOException {
        $(By.xpath("//*[contains(.,'Новый')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        verifyTime();
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public PrintFormPageBase verifyActivCall(PacientImpl pacientImpl) throws IOException {
        $(By.xpath("//*[contains(.,'Активный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public PrintFormPageBase verifyDoneCall(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'Обслуженный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        baseDoctor(doctor);
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("отменить вызов")
    public PrintFormPageBase cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public PrintFormPageBase cancelOnChangePageBtn() {
        $(By.xpath("//*[contains(.,'" + "Редактирование вызова" + "')]")).shouldBe(Condition.visible);
        cancelCall.click();
        cancelField.setValue("отмена автотестом");
        cancelCall2.click();
        return this;
    }

    @Step("передать другому врачу")
    public PrintFormPageBase changeDoctorBtn() {
        setAnotherDoctor.click();
        return this;
    }

    @Step("назначить врача")
    public PrintFormPageBase chooseDoctorBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).shouldBe(Condition.visible);
        appoindDoctorBtn.hover().click();
        return this;
    }

    @Step("завершить обслуживание")
    public PrintFormPageBase completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        completeServiceBtn.click();
//        mat_calendar_header.click();
//        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public PrintFormPageBase editCallBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public PrintFormPageBase closeCardBtn() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//span/mat-icon[contains(text(),'close')]")).click();
        LOGGER.info("Карта закрыта!");
        return this;
    }

    @Step("проверяем что кнопка МКАБ не активна")
    public PrintFormPageBase verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка МКАБ активна")
    public PrintFormPageBase verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath(".//*[@class='mat-icon call-doctor-red-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП не активна")
    public PrintFormPageBase verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП активна")
    public PrintFormPageBase verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public PrintFormPageBase transferToDepartBtn() {
        toLpu.click();
        $(By.xpath("//*[contains(text(),'Выберите куда передать вызов')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public PrintFormPageBase verifyDepartment(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'" + doctor.getDepartment() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("сохранить распознанный адрес")
    public PrintFormPageBase saveAdressAsKladr() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }

    @Step("проверить врача")
    public PrintFormPageBase verifyDoctor(Doctor doctor) {
        $(By.xpath("//*[contains(.,'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на подробной странице")
    public PrintFormPageBase verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("нажимаю на кнопку печати")
    public PrintFormPageBase printBtn() throws InterruptedException {
        $x("//div[@id='viewPrint']/mat-icon").click();
        return this;
    }
}