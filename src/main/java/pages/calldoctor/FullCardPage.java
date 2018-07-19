package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class FullCardPage extends AbstractPage implements Profile {
    SelenideElement doneCall = $(By.id("doneCall"));
    SelenideElement mat_calendar_header = $(By.xpath("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']"));
    SelenideElement appoindBtn = $(By.xpath("//span[contains(text(),'Передать другому врачу')]"));
    SelenideElement appoindBtns = $(By.xpath("//span[contains(text(),'Завершить обслуживание')]"));
    SelenideElement cancelBtn = $(By.id("cancel"));
    SelenideElement cancelCall = $(By.id("cancelCall"));
    SelenideElement cancelCall2 = $(By.xpath("//a[@title='Отменить вызов']"));
    SelenideElement change = $(By.id("change"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));

    public FullCardPage() {

    }

    public void baseElements() {
        ArrayList<String> elements = null;
        elements.add("Карта вызова");
        elements.add("Дата");
        elements.add("Время");
        elements.add("Статус");
        elements.add("Вид вызова");
        elements.add("Источник");
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
        elements.add("Новый");
        elements.add("Первичный");
        elements.add("Регистратура");
        elements.add("Взрослые");
        elements.add("Карта создана");
        elements.add("Не назначен");

        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }

    public void baseElementsNewCall() {
        ArrayList<String> elements = null;
        elements.add("Карта вызова");
        elements.add("Дата");
        elements.add("Время");
        elements.add("Статус");
        elements.add("Вид вызова");
        elements.add("Источник");
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
        elements.add("Новый");
        elements.add("Первичный");
        elements.add("Регистратура");
        elements.add("Взрослые");
        elements.add("Карта создана");
        elements.add("Не назначен");

        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }

    public void baseElementsActivityCall() {
        ArrayList<String> elements = null;
        elements.add("Карта вызова");
        elements.add("Дата");
        elements.add("Время");
        elements.add("Статус");
        elements.add("Вид вызова");
        elements.add("Источник");
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
        elements.add("Новый");
        elements.add("Первичный");
        elements.add("Регистратура");
        elements.add("Взрослые");
        elements.add("Карта создана");
        elements.add("Не назначен");

        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }

    public void baseElementsDoneCall() {
        ArrayList<String> elements = null;
        elements.add("Карта вызова");
        elements.add("Дата");
        elements.add("Время");
        elements.add("Статус");
        elements.add("Вид вызова");
        elements.add("Источник");
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
        elements.add("Новый");
        elements.add("Первичный");
        elements.add("Регистратура");
        elements.add("Взрослые");
        elements.add("Карта создана");
        elements.add("Не назначен");

        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }


    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfile0(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();

        $(By.xpath("//*[contains(.,'" + proData.get(adressFull) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(zhaloba) + "')]")).should(Condition.visible);
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfile1(String nameGen, String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();

        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Регистратура" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Взрослые" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пациент" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Стенд ЕМИАС МО" + "')]")).should(Condition.visible);

        $(By.xpath("//*[contains(.,'" + proData.get(adressFull) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(zhaloba) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(pd) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(dfon) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(etazh) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nameGen) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(fam) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(otchestvo) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(seriyaPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nomerPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(birthDay) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(age) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(vKat) + "')]")).should(Condition.visible);
        return this;
    }

    @Step("проверяю активный вызов")
    public FullCardPage verifyCallProfile1Activity(String nameGen, String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();

        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Регистратура" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Взрослые" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пациент" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Стенд ЕМИАС МО" + "')]")).should(Condition.visible);

        $(By.xpath("//*[contains(.,'" + proData.get(adressFull) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(zhaloba) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(pd) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(dfon) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(etazh) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nameGen) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(fam) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(otchestvo) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(seriyaPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nomerPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(birthDay) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(age) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(vKat) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(doctorFam) + "')]")).should(Condition.visible);
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPage verifyDoneDocGroup(String nameGen, String profile) throws IOException {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        Selenide.refresh();
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();

        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Активный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Регистратура" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Взрослые" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пациент" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Стенд ЕМИАС МО" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Назначенный врач" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата перевода в статус активный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата и время завершения обслуживания вызова" + "')]")).should(Condition.visible);

        $(By.xpath("//*[contains(.,'" + proData.get(adressFull) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(zhaloba) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(pd) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(dfon) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(etazh) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nameGen) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(fam) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(otchestvo) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(seriyaPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(nomerPol) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(birthDay) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(age) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(vKat) + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get(doctorFam) + "')]")).should(Condition.visible);
        return this;
    }


    @Step("отменить вызов")
    public FullCardPage cancelRecordOnFullCardPage() {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        cancelBtn.click();
        cancelField.setValue("отмена автотестом");
        cancelCall.click();
        return this;
    }

    @Step("передать другому врачу")
    public void sendAnotherDoctorBtn() {
        appoindBtn.click();
    }

    @Step("назначить врача")
    public FullCardPage appoindDoctorBtn() {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).should(Condition.visible);
        appoindBtns.click();
        return this;
    }

    @Step("завершить обслуживание")
    public FullCardPage completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        appoindBtns.click();
        mat_calendar_header.click();

        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }


    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage cancelRecordOnChangePage() {
        $(By.xpath("//*[contains(.,'" + "Редактирование вызова" + "')]")).should(Condition.visible);
        cancelCall.click();
        cancelField.setValue("отмена автотестом");
        cancelCall2.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage editCallBtn() {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public FullCardPage closeCardBtn() {
        $(By.xpath("//*[contains(.,'" + "Карта вызова" + "')]")).should(Condition.visible);
        $(By.xpath("//mat-icon[contains(text(),'close')]")).click();
        return this;
    }
}