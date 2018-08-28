package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FullCardPage extends AbstractPage {
    SelenideElement doneCall = $(By.id("doneCall"));
    SelenideElement mat_calendar_header = $(By.xpath("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']"));
    SelenideElement setAnotherDoctor = $(By.xpath("//span[contains(text(),'Передать другому врачу')]"));
    SelenideElement appoindDoctorBtn = $(By.id("toDoctor"));
    SelenideElement completeServiceBtn = $(By.id("toDone"));
    SelenideElement cancelBtn = $(By.id("cancel"));
    SelenideElement toLpu = $(By.id("toLpu"));
    SelenideElement cancelCall = $(By.id("cancelCall"));
    SelenideElement cancelCall2 = $(By.xpath("//a[@title='Отменить вызов']"));
    SelenideElement change = $(By.id("change"));
    SelenideElement cancelField = $(By.xpath("//input[@placeholder='Причина отмены вызова']"));

    public FullCardPage() {
    }

    public void baseElements() {
        ArrayList<String> elements = new ArrayList<>();
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
        elements.add("Карта создана");
        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }

    public void baseElementsEditPage() {
        ArrayList<String> elements = new ArrayList<>();
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
//        elements.add("Карта создана");
        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).should(Condition.visible);
        }
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfile0(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();

        $(By.xpath("//*[contains(.,'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfileDetkina(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElementsEditPage();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible); это есть в baseElements
        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("age") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("department") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallNewCallGroup(String profile, String nameGen) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElementsEditPage();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("source") + "')]")).should(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible); это есть в baseElements
        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("age") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + proData.get("department") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю активный вызов")
    public FullCardPage verifyCallActivityGroup(String nameGen, String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'" + proData.get("age") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю активный вызов")
    public FullCardPage verifyCallActivityGroup(String nameGen, String profile, String profile2) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        File reader2 = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile2 + ".json");
        Map proData2 = new ObjectMapper().readValue(reader2, Map.class);
        baseElements();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Взрослые" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Стенд ЕМИАС МО" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'" + proData.get("age") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData2.get("doctorFam") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPage verifyDoneDocGroup(String profile, String nameGen) throws IOException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        Selenide.refresh();
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        baseElements();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Обслуженный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Назначенный врач" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата перевода в статус активный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата и время завершения обслуживания вызова" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("years") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPage verifyDoneDocGroup(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        Selenide.refresh();
        baseElements();
        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Обслуженный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Назначенный врач" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата перевода в статус активный" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + "Дата и время завершения обслуживания вызова" + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("dfon") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("years") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).should(Condition.visible);
        System.out.println("Подробная карта вызова проверена! " + driver.getCurrentUrl());
        return this;
    }

    @Step("отменить вызов")
    public FullCardPage cancelRecordOnFullCardPage() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        cancelBtn.click();
        cancelField.setValue("отмена автотестом");
        cancelCall.click();
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


    @Step("передать другому врачу")
    public FullCardPage changeDoctorBtn() {
        setAnotherDoctor.click();
        return this;
    }

    @Step("назначить врача")
    public FullCardPage chooseDoctorBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).should(Condition.visible);
        appoindDoctorBtn.click();
        return this;
    }

    @Step("завершить обслуживание")
    public FullCardPage completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        completeServiceBtn.click();
        mat_calendar_header.click();

        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage editCallBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public FullCardPage closeCardBtn() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//span/mat-icon[contains(text(),'close')]")).click();
        System.out.println("Карта закрыта!");
        return this;
    }


    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка МКАБ не активна")
    public FullCardPage verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка МКАБ активна")
    public FullCardPage verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка ТАП не активна")
    public FullCardPage verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка ТАП активна")
    public FullCardPage verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).should(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public void transferToDepartBtn() {
        toLpu.click();
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public FullCardPage verifyDepart(String currDepart) {
        $(By.xpath("//*[contains(.,'" + currDepart + "')]")).shouldBe(Condition.visible);
        return this;
    }
}