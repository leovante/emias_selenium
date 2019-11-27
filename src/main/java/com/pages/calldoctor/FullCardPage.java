package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.utils.assistance.Assistance.*;
import static org.testng.Assert.assertTrue;

public class FullCardPage extends WebPage {
    Pacient pacient;
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
    SelenideElement status_new = $x("//*[contains(.,'Новый')]");
    SelenideElement status_active = $(By.xpath("//*[contains(.,'Активный')]"));
    SelenideElement status_done = $(By.xpath("//*[contains(.,'Обслуженный')]"));
    SelenideElement timeField = $x("//input[@placeholder='Время']");
    SelenideElement card = $x("//*[contains(text(),'Карта вызова')]");

    public FullCardPage(String testName) {
        callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
        logger.info("Open card with url: " + url());
    }

    FullCardPage(Pacient pacient, String testName) {
        this.pacient = pacient;
        try {
            callDoctorCards.setCardMap(testName, cardNumberParser(cardNumber.getText()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        logger.info("Открыл карту вызова url " + url());
    }

    FullCardPage(Pacient pacient) {
        this.pacient = pacient;
        logger.info("Открыл карту вызова url " + url());
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
        logger.info("curTime: " + curTime + " " + "expTime: " + expTime);
        assertTrue(curTime.contains(expTime), "Время вызова не корректно!");
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyNewCall() {
        status_new.shouldBe(Condition.visible);
        baseElements();
        basePacient();
        verifyTime();
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyActivCall(Pacient pacient) {
        status_active.shouldBe(Condition.visible);
        baseElements();
        basePacient();
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPage verifyDoneCall(Doctor doctor) {
        refresh();
        status_done.shouldBe(Condition.visible);
        baseElements();
        basePacient();
        baseDoctor(doctor);
        logger.info("Подробная карта вызова проверена!");
        return this;
    }

    @Step("отменить вызов")
    public FullCardPage cancelOnFullCardBtn(String reason) {
        card.shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue(reason);
        cancelCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage cancelOnChangePageBtn() {
        visible("Редактирование вызова");
        cancelCall.click();
        cancelField.setValue("отмена автотестом");
        cancelCall2.click();
//        visible("Данный вызов был отменён");
        return this;
    }

    @Step("передать другому врачу")
    public FullCardPage changeDoctorBtn() {
        setAnotherDoctor.click();
        return this;
    }

    @Step("назначить врача")
    public FullCardPage chooseDoctorBtn() {
        card.shouldBe(Condition.visible);
        $x("//span[contains(text(),'Назначить')]").shouldBe(Condition.visible);
        appoindDoctorBtn.hover().click();
        return this;
    }

    @Step("завершить обслуживание")
    public FullCardPage completeServiceBtn() {
        card.shouldBe(Condition.visible);
        completeServiceBtn.click();
        doneCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage editCallBtn() {
        card.shouldBe(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public FullCardPage closeCardBtn() {
        card.shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $x("//span/mat-icon[contains(text(),'close')]").click();
        logger.info("Карта закрыта!");
        return this;
    }

    @Step("проверяем что кнопка МКАБ не активна")
    public FullCardPage verifyMkabIconDisable() {
        card.shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка МКАБ активна")
    public FullCardPage verifyMkabIconEnable() {
        card.shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath(".//*[@class='mat-icon call-doctor-red-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП не активна")
    public FullCardPage verifyTapIconDisable() {
        card.shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП активна")
    public FullCardPage verifyTapIconEnable() {
        card.shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public FullCardPage transfer_to_depart() {
        toLpu.click();
        $(By.xpath("//*[contains(text(),'Выберите куда передать вызов')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public FullCardPage verifyDepartment(Doctor doctor) {
        $(By.xpath("//*[contains(.,'" + doctor.getDepartment() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("сохранить распознанный адрес")
    public FullCardPage saveAdressAsKladr() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }

    @Step("проверить врача")
    public FullCardPage verifyDoctor(Doctor doctor) {
        $(By.xpath("//*[contains(.,'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("валидация что вызов не отменился на подробной странице")
    public FullCardPage verifyCancellCallValidation() {
        $(By.xpath("//*[contains(text(),'Причина отмены вызова не указана, либо слишком коротка')]")).shouldBe(Condition.visible);
        sleep(2000);
        $(By.xpath("//*[contains(text(),'КТО ПАЦИЕНТ')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("нажимаю на кнопку печати")
    public FullCardPage printBtn() {
        $x("//div[@id='viewPrint']/mat-icon").click();
        return this;
    }
}