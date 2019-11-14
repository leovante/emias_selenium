package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VedenieRaspisaniyaBasePage extends BasePage {
    SelenideElement deleteShedule = $(By.xpath("//button[@id='btn_delete']/span[2]"));
    SelenideElement deleteSheduleBtnWindow = $(By.id("btn_delete_schedule"));
    SelenideElement createShedule = $(By.xpath("//button[@id='btn_create']/span[2]"));
    SelenideElement pickTime_nach = $(By.id("pickTime_nach"));
    SelenideElement pickTime_nachClose = $(By.xpath("(//button[@type='button'])[2]"));
    SelenideElement pickTime_okon = $(By.id("pickTime_okon"));
    SelenideElement pickTime_okonClose = $(By.xpath("(//button[@type='button'])[2]"));
    SelenideElement ddlbusytypeButton = $(By.xpath("//a[@id='ddlbusytype-button']/span[2]"));
    SelenideElement priemPoOcheredi = $(By.linkText("Прием по очереди"));
    SelenideElement priemNaDomu = $(By.linkText("Прием на дому (вызов на дом)"));
    SelenideElement schedule_add_button = $(By.id("schedule_add_button"));
    SelenideElement btn_save_schedule = $(By.xpath("//button[@id='btn_save_schedule']/span"));
    SelenideElement btn_notReciveDays = $(By.xpath("//button[@id='btn_busy']/span[2]"));
    SelenideElement row_doctorOnBoln = $(By.xpath("//div[@id='radio_busy']/label[2]/span/span"));
    SelenideElement saveBtn = $(By.xpath("//button[@id='btn_busy_save']/span"));
    SelenideElement copyShedule = $(By.xpath("//button[@id='btn_copy']/span[2]"));

    public VedenieRaspisaniyaBasePage() {
    }

    @Step("Создать расписание")
    public void createShedule() {
//        waitAllEmias();

        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String a = "2330", b = "2344";
        String c = "2344", d = "2359";
        createShedule.click();

        setTimeCalendar(a, b);
        setTypeOfReception(priemNaDomu);

        setTimeCalendar(c, d);
        setTypeOfReception(priemPoOcheredi);

//        waitWhileClickable(btn_save_schedule);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
//        waitAllEmias();
//        Waiter.waitAllEmias();
    }

    @Step("задать неприемные дни")
    public VedenieRaspisaniyaBasePage setNotReceiveDays(String firstDoctor) {
//        waitAllEmias();
//        Keyboard keyboard = ((HasInputDevices) remoteDriver).getKeyboard();

        $(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();
//        waitAllEmias();

//        waitWhileClickable(btn_notReciveDays);
        btn_notReciveDays.click();//задать неприемные дни

//        waitWhileClickable(row_doctorOnBoln);
        row_doctorOnBoln.click();//выбрали форс-мажор

//        waitWhileClickable(saveBtn);
        saveBtn.click();//нажали сохранить

        new PressEnter();
//        keyboard.pressKey(Keys.ENTER);
        return this;
    }

    @Step("копировать расисание")
    public void copyShedule(String docName) {
//        waitAllEmias();
//        waitWhileClickable(copyShedule);
        copyShedule.click();

        $(By.xpath("//table[@id='copy_selected_grid']/tbody/tr[2]/td[2]")).click();
        $(By.xpath("//button[@id='next_wizcopy']/span")).click();
        $(By.xpath("//button[@id='next_wizcopy']/span")).click();
        List<WebElement> closeBtnList = driver.findElements(By.xpath("//span[contains(text(),'Закрыть')]"));
        for (WebElement closeBtn : closeBtnList) {
            try {
                closeBtn.click();
            } catch (ElementNotVisibleException ex) {
            }
        }
        $(By.xpath("//button[@id='finish_wizcopy']/span")).click();
//        waitAllEmias();
    }

    @Step("удалить расписание")
    public VedenieRaspisaniyaBasePage deleteShedule() {//удалить расписание выбранного врача
//        Keyboard keyboard = ((HasInputDevices) remoteDriver).getKeyboard();
//        waitAllEmias();

//        waitWhileClickable(deleteShedule);
        deleteShedule.click();                     //кнопка удалить расписание
//        waitWhileClickable(deleteSheduleBtnWindow);
        deleteSheduleBtnWindow.click();            //подтверждение удаления

        sleep(1000);
        new PressEnter();
//        keyboard.pressKey(Keys.ENTER);
//        waitAllEmias();
        return this;
    }

    @Step("устанвотиь время в календаре")
    public void setTimeCalendar(String a, String b)  {
//        waitWhileClickable(pickTime_nach);
        pickTime_nach.sendKeys(a);          //нажимаем на поле начала интервала
//        waitWhileClickable(pickTime_nachClose);
        pickTime_nachClose.click();
        sleep(500);
//        waitWhileClickable(pickTime_okon);
        pickTime_okon.sendKeys(b);          //нажимаем на поле окончание интервала
//        waitWhileClickable(pickTime_okonClose);
        pickTime_okonClose.click();      //нажали закрыть календарь
    }

    @Step("установить тип приема")
    public void setTypeOfReception(SelenideElement typeOfReception) {
//        waitWhileClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
//        waitWhileClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
//        waitWhileClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    @Step("проверить неприемные дни")
    public VedenieRaspisaniyaBasePage verifyNotReceiveDays() {
//        waitAllEmias();
        $(By.xpath("//div[@id='schedule']/div/div/div"))
                .$(By.xpath("span[contains(text(),'Врач на больничном')]"))
                .shouldBe(Condition.visible);//это название заголовка
        logger.info("Проверка наличия заголовка форс-мажора");
        return this;
    }

    @Step("проверить удаление расписания")
    public VedenieRaspisaniyaBasePage verifyDeletedShedle() {
        if (!$(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
        if (!$(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
        return this;
    }

    @Step("получить фамилию")
    public static String getSecondName(String name) {
        if(name.contains(" ")){
            name= name.substring(0, name.indexOf(" "));
        }
        return name;
    }

    @Step("проверка создания распсиания")
    public VedenieRaspisaniyaBasePage verifyCreatedShedule(String nameDoctor)  {
        sleep(2000);
        $(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .$(By.xpath("//*[contains(text(),'23:44 ')]"));
        logger.info("Проверил что для доктора " + nameDoctor + " создано расписание!");
        return this;
    }
}