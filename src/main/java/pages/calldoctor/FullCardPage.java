package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
//        elements.add("Пол");
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
        elements.add("Карта создана");
        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).shouldBe(Condition.visible);
        }
    }

    public void basePacient(Pacient pacient) {
        ShouldBeVisible(pacient.getAddress());
        ShouldBeVisible(pacient.getComplaint());
        ShouldBeVisible(pacient.getCodedomophone());
        ShouldBeVisible(parseTelephone(pacient));
        ShouldBeVisible(String.valueOf(pacient.getEntrance()));
        ShouldBeVisible(String.valueOf(pacient.getFloor()));
        ShouldBeVisible(pacient.getName());
        ShouldBeVisible(pacient.getFamily());
        ShouldBeVisible(pacient.getOt());
        ShouldBeVisible(String.valueOf(pacient.getBirthdate("dd.MM.yyyy")));
        ShouldBeVisible(String.valueOf(pacient.getSeriespol()));
        ShouldBeVisible(String.valueOf(pacient.getNumberpol()));
        if (pacient.getKladraddress() != null) {
            ShouldBeVisible(pacient.getAppartment());
            ShouldBeVisible(pacient.getBuilding());
            ShouldBeVisible(pacient.getConstruction());
        }
    }

    public void baseDoctor(Doctor doctor) {
        ShouldBeVisible(doctor.getName());
        ShouldBeVisible(doctor.getFamily());
        ShouldBeVisible(doctor.getOt());
        ShouldBeVisible(doctor.getDepartment());
        ShouldBeVisible(doctor.getUchastocs());
    }

    public String parseTelephone(Pacient pacient) {
        String telephone = pacient.getPhone();
        telephone = telephone.substring(0, 2) + " (" +
                telephone.substring(2, 5) + ") " +
                telephone.substring(5, 8) + "-" +
                telephone.substring(8, 10) + "-" +
                telephone.substring(10, telephone.length());
        return telephone;
    }
//    @Step("проверяю новый вызов {profile}")
//    public FullCardPage verifyCallProfile0(String profile) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        baseElements();
//
//        $(By.xpath("//*[contains(.,'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }

    @Step("проверяю новый вызов {profile}")
    public FullCardPage verifyNewCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Новый')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов {profile}")
    public FullCardPage verifyActivCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Активный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов {profile}")
    public FullCardPage verifyDoneCall(Pacient pacient, Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'Обслуженный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        baseDoctor(doctor);
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

//    @Step("проверяю новый вызов {profile}")
//    public FullCardPage verifyNewCallDash(String profile, String nameGen) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).shouldBe(Condition.visible);
////        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe()(Condition.visible);
////        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe()(Condition.visible); это есть в baseElements
//        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("age") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }
//
//    @Step("проверяю новый вызов {profile}")
//    public FullCardPage verifyNewCallDash(String profile) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).shouldBe(Condition.visible);
////        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe()(Condition.visible);
////        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe()(Condition.visible); это есть в baseElements
//        $(By.xpath("//*[contains(.,'" + "Не назначен" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("address") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("complaint") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("age") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }

//    @Step("проверяю активный вызов {profile}")
//    public FullCardPage verifyCallActivityGroup(String nameGen, String profile) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Плановое время обхода" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//span[contains(text(),'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//span[contains(text(),'" + proData.get("age") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//div/span[2][contains(text(),'" + proData.get("uchastocs") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта проверена!");
//        return this;
//    }
//
//    @Step("проверяю активный вызов {profile} {profile2}")
//    public FullCardPage verifyCallActivityGroup(String nameGen, String profile, String profile2) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        File reader2 = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile2 + ".json");
//        Map proData2 = new ObjectMapper().readValue(reader2, Map.class);
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Отменить вызов" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Новый" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Взрослые" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Стенд ЕМИАС МО" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Плановое время обхода" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//span[contains(text(),'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//span[contains(text(),'" + proData.get("age") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData2.get("doctorFam") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }
//
//    @Step("проверяю обслуженный вызов {profile}")
//    public FullCardPage verifyDoneDocGroup(String profile, String nameGen) throws IOException {
//        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
//        Selenide.refresh();
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Обслуженный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Назначенный врач" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Дата перевода в статус активный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Дата и время завершения обслуживания вызова" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("years") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }
//
//    @Step("проверяю обслуженный вызов {profile}")
//    public FullCardPage verifyDoneDocGroup(String profile) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
//        Selenide.refresh();
//        $(By.xpath("//*[contains(.,'Карта вызова')]")).shouldBe(Condition.visible);
//        baseElements();
//        $(By.xpath("//*[contains(.,'" + "Возраст" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Пол" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Обслуженный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Первичный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Карта создана" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Назначенный врач" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Дата перевода в статус активный" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'" + "Дата и время завершения обслуживания вызова" + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("department") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("whoIsCall") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("source") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("adressFull") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("zhaloba") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("pd") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("dfon") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("etazh") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("otchestvo") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("seriyaPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("nomerPol") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("birthDay") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("years") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("vKat") + "')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'" + proData.get("doctorFam") + "')]")).shouldBe(Condition.visible);
//        System.out.println("Подробная карта вызова проверена!");
//        return this;
//    }

    @Step("отменить вызов")
    public FullCardPage cancelOnFullCardBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        cancelBtn.click();
        cancelField.setValue("отмена автотестом");
        cancelCall.click();
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage cancelOnChangePageBtn() {
        $(By.xpath("//*[contains(.,'" + "Редактирование вызова" + "')]")).shouldBe(Condition.visible);
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
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//span[contains(text(),'Назначить')]")).shouldBe(Condition.visible);
        appoindDoctorBtn.hover().click();
        return this;
    }

    @Step("завершить обслуживание")
    public FullCardPage completeServiceBtn() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        completeServiceBtn.click();
        mat_calendar_header.click();

        new PressEnter();
        doneCall.click();
        Thread.sleep(1000);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage editCallBtn() {
        $(By.xpath("//*[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        change.click();
        return this;
    }

    @Step("закрыть подробную карту")
    public FullCardPage closeCardBtn() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//span/mat-icon[contains(text(),'close')]")).click();
        System.out.println("Карта закрыта!");
        return this;
    }


    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка МКАБ не активна")
    public FullCardPage verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка МКАБ активна")
    public FullCardPage verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка ТАП не активна")
    public FullCardPage verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']")).click();
        return this;
    }

    // TODO: 13.08.2018 сделать id для каждой кнопки и проверять наличие вложенного red grey
    @Step("проверяем что кнопка ТАП активна")
    public FullCardPage verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        List<SelenideElement> elements = $$(By.xpath("//span/mat-icon[contains(text(),'close')]"));
        $(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public void transferToDepartBtn() {
        toLpu.click();
    }

    // TODO: 10/9/2018 добавить проверку профиля пациента
    @Step("Проверка текущего подразделения у карты вызова")
    public FullCardPage verifyDepartment(Doctor doctor) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        $(By.xpath("//*[contains(.,'" + doctor.getDepartment() + "')]")).shouldBe(Condition.visible);
        return this;
    }

    @Step("сохранить распознанный адрес")
    public FullCardPage saveAdressAsKladr() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }

    // TODO: 10/9/2018 доработать
    @Step("проверить врача")
    public FullCardPage verifyDoctor(Doctor doctor) {
        //        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан.')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }
}