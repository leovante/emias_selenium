package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class FullCardPageBase extends PageBase {
    Pacient pacientImpl;
    SelenideElement doneCall = $(By.id("doneCall"));
    SelenideElement mat_calendar_header2 = $x("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']");
    SelenideElement mat_calendar_header = $(By.id(""));
    SelenideElement setAnotherDoctor = $x("//span[contains(text(),'Передать другому врачу')]");
    SelenideElement appoindDoctorBtn = $(By.id("toDoctor"));
    SelenideElement completeServiceBtn = $(By.id("toDone"));
    SelenideElement toLpu = $(By.id("toLpu"));
    SelenideElement cancelCall2 = $x("//a[@title='Отменить вызов']");
    SelenideElement change = $(By.id("change"));
    SelenideElement cancelBtn = $(By.id("cancel"));
    SelenideElement cancelField = $x("//input[@placeholder='Причина отмены вызова']");
    SelenideElement cancelCall = $(By.id("cancelCall"));
    SelenideElement cardNumber = $x("//div[contains(text(),'Карта вызова №')]");

    public FullCardPageBase(String testName) {
        callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
    }

    public FullCardPageBase(Pacient pacientImpl, String testName) {
        this.pacientImpl = pacientImpl;
        try {
            callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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
        elements.add("ИСТОРИЯ ВЫЗОВА");
        elements.add("АВТОР");
        elements.add("ЧТО ИЗМЕНИЛОСЬ");
        elements.add("ИЗМЕНЕНИЕ");
//        elements.add("Карта создана");
        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).shouldBe(Condition.visible);
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
    public FullCardPageBase verifyNewCall() throws IOException {
        $(By.xpath("//*[contains(.,'Новый')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        verifyTime();
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPageBase verifyActivCall(PacientImpl pacientImpl) throws IOException {
        $(By.xpath("//*[contains(.,'Активный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPageBase verifyDoneCall(Doctor doctor) throws IOException {
        refresh();
        $(By.xpath("//*[contains(.,'Обслуженный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient();
        baseDoctor(doctor);
        LOGGER.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("отменить вызов")
    public FullCardPageBase cancelOnFullCardBtn(String reason) {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPageBase cancelOnChangePageBtn() {
        $(By.xpath("//*[contains(.,'" + "Редактирование вызова" + "')]")).shouldBe(Condition.visible);
        cancelCall.click();
        cancelField.setValue("отмена автотестом");
        cancelCall2.click();
        return this;
    }

    @Step("передать другому врачу")
    public FullCardPageBase changeDoctorBtn() {
        setAnotherDoctor.click();
        return this;
    }

    @Step("назначить врача")
    public FullCardPageBase chooseDoctorBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).shouldBe(Condition.visible);
        appoindDoctorBtn.hover().click();
        return this;
    }

    @Step("завершить обслуживание")
    public FullCardPageBase completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        completeServiceBtn.click();
//        mat_calendar_header.click();
//        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPageBase editCallBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public FullCardPageBase closeCardBtn() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//span/mat-icon[contains(text(),'close')]")).click();
        LOGGER.info("Карта закрыта!");
        return this;
    }

    @Step("проверяем что кнопка МКАБ не активна")
    public FullCardPageBase verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка МКАБ активна")
    public FullCardPageBase verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath(".//*[@class='mat-icon call-doctor-red-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП не активна")
    public FullCardPageBase verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП активна")
    public FullCardPageBase verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public FullCardPageBase transferToDepartBtn() {
        toLpu.click();
        $(By.xpath("//*[contains(text(),'Выберите куда передать вызов')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public FullCardPageBase verifyDepartment(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'" + doctor.getDepartment() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("сохранить распознанный адрес")
    public FullCardPageBase saveAdressAsKladr() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }

    @Step("проверить врача")
    public FullCardPageBase verifyDoctor(Doctor doctor) {
        $(By.xpath("//*[contains(.,'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на подробной странице")
    public FullCardPageBase verifyCancellCallValidation() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("нажимаю на кнопку печати")
    public FullCardPageBase printBtn() throws InterruptedException {
        $x("//div[@id='viewPrint']/mat-icon").click();
        return this;
    }
}