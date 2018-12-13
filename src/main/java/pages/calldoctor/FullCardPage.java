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
import static org.testng.Assert.assertTrue;

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
//        elements.add("Карта создана");
        for (String element : elements) {
            $(By.xpath("//*[contains(.,'" + element + "')]")).shouldBe(Condition.visible);
        }
    }

    @Step("проверяю наличие базовых элементов пациента")
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

    @Step("проверяю наличие базовых элементов врача")
    public void baseDoctor(Doctor doctor) {
        ShouldBeVisible(doctor.getName());
        ShouldBeVisible(doctor.getFamily());
        ShouldBeVisible(doctor.getOt());
        ShouldBeVisible(doctor.getDepartment());
        ShouldBeVisible(doctor.getUchastocs());
    }

    @Step("проверка времени")
    public void verifyTime() {
        ArrayList dateList = currentTimeList("HH:mm");
        String timeCard = $(By.xpath("//span[contains(text(),'Время')]")).$(By.xpath("../.")).$(By.xpath("./span[2]")).getText();
        assertTimeContains(dateList, timeCard);
    }

    @Step("проверяю наличие базовых элементов")
    void assertTimeContains(ArrayList curTime, String expTime) {
        System.out.println("curTime: " + curTime);
        System.out.println("expTime: " + expTime);
        assertTrue(curTime.contains(expTime), "Время вызова не корректно!");
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyNewCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Новый')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        verifyTime();
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyActivCall(Pacient pacient) throws IOException {
        $(By.xpath("//*[contains(.,'Активный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyDoneCall(Pacient pacient, Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(.,'Обслуженный')]")).shouldBe(Condition.visible);
        baseElements();
        basePacient(pacient);
        baseDoctor(doctor);
        System.out.println("Подробная карта вызова проверена!");
        return this;
    }

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

    @Step("проверяем что кнопка МКАБ не активна")
    public FullCardPage verifyMkabIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка МКАБ активна")
    public FullCardPage verifyMkabIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement mkabTxt = $(By.xpath("//div[contains(text(),'МКАБ')]"));
        mkabTxt.$(By.xpath("../.")).$(By.xpath(".//*[@class='mat-icon call-doctor-red-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП не активна")
    public FullCardPage verifyTapIconDisable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-gray-text material-icons']"));
        return this;
    }

    @Step("проверяем что кнопка ТАП активна")
    public FullCardPage verifyTapIconEnable() {
        $(By.xpath("//div[contains(text(),'" + "Карта вызова" + "')]")).shouldBe(Condition.visible);
        SelenideElement tapTxt = $(By.xpath("//div[contains(text(),'ТАП')]"));
        tapTxt.$(By.xpath("../.")).$(By.xpath("//*[@class='mat-icon call-doctor-red-text material-icons']")).click();
        return this;
    }

    @Step("передать в другое ЛПУ через подробную карту вызова")
    public void transferToDepartBtn() {
        toLpu.click();
        $(By.xpath("//*[contains(text(),'Выберите куда передать вызов')]")).shouldBe(Condition.visible);
    }

    @Step("Проверка текущего подразделения у карты вызова")
    public FullCardPage verifyDepartment(Doctor doctor) throws IOException {
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
}