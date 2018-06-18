package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

import static org.testng.Assert.assertTrue;

public class FullCardPage extends BasePage implements Profile1 {

    @FindBy(id = "doneCall")
    WebElement doneCall;

    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']")
    WebElement mat_calendar_header;

    @FindBy(xpath = "//*[contains(.,'Что изменилось')]")
    WebElement chtoIzmenilos;

    public FullCardPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCallProfile1(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("П-д");
        containsIsDisplayed("Домофон");
        containsIsDisplayed("Этаж");
        containsIsDisplayed("ЖАЛОБЫ");

        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("Возраст");
        containsIsDisplayed("Пол");
        containsIsDisplayed("Полис");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("Не назначен");
        containsIsDisplayed("Стенд ЕМИАС МО");

        containsIsDisplayed(adressPro1);
        containsIsDisplayed(pdPro1);
        containsIsDisplayed(dfonPro1);
        containsIsDisplayed(etazhPro1);
        containsIsDisplayed(nameGen);
        containsIsDisplayed(famPro1);
        containsIsDisplayed(otchestvoPro1);
        containsIsDisplayed(seriyaPolPro1);
        containsIsDisplayed(nomerPolPro1);
        containsIsDisplayed(zhalobaPro1);
        containsIsDisplayed(birthDayPro1);
        containsIsDisplayed(goda24Pro1);
        containsIsDisplayed(vozrastKatPro1);
    }

    public void verifyCallProfile1Activity(String doctorFam, String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("П-д");
        containsIsDisplayed("Домофон");
        containsIsDisplayed("Этаж");
        containsIsDisplayed("ЖАЛОБЫ");

        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("Возраст");
        containsIsDisplayed("Пол");
        containsIsDisplayed("Полис");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Активный");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");

        containsIsDisplayed(adressPro1);
        containsIsDisplayed(pdPro1);
        containsIsDisplayed(dfonPro1);
        containsIsDisplayed(etazhPro1);
        containsIsDisplayed(nameGen);
        containsIsDisplayed(doctorFam);
        containsIsDisplayed(famPro1);
        containsIsDisplayed(otchestvoPro1);
        containsIsDisplayed(seriyaPolPro1);
        containsIsDisplayed(nomerPolPro1);
        containsIsDisplayed(zhalobaPro1);
        containsIsDisplayed(birthDayPro1);
        containsIsDisplayed(goda24Pro1);
        containsIsDisplayed(vozrastKatPro1);

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + nameGen + "')]")).isDisplayed());
    }

    public void verifyCallRegistr2Activity(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("Не назначен");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }

    public void verifyCallRegistr3Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("Не назначен");
    }

    public void verifyCallRegistr3Complete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("Не назначен");
    }

    @Step
    public void verifyCallProfile2(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.101, корп.202, стр.303, кв.404");
        containsIsDisplayed("505");
        containsIsDisplayed("606");
        containsIsDisplayed("707");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Афанасьева");
        containsIsDisplayed("Софья");
        containsIsDisplayed("Петровна");
        containsIsDisplayed("Ж");
        containsIsDisplayed("7854215965847521");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автодмитрий");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Не назначен");
    }

    public void verifyCallRegistrMkab2New() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("напиши тут другой адрес");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("");
        containsIsDisplayed("321");
        containsIsDisplayed("54321");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Петров");
        containsIsDisplayed("Петр");
        containsIsDisplayed("Петрович");
        containsIsDisplayed("Автотемниковизменил");
        containsIsDisplayed("Автодмитрийизменил");
        containsIsDisplayed("Автоолеговичизменил");
        containsIsDisplayed("Не назначен");

    }

    public void verifyCallRegistrMkab2Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("напиши тут другой адрес");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("");
        containsIsDisplayed("321");
        containsIsDisplayed("54321");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Петров");
        containsIsDisplayed("Петр");
        containsIsDisplayed("Петрович");
        containsIsDisplayed("Автотемниковизменил");
        containsIsDisplayed("Автодмитрийизменил");
        containsIsDisplayed("Автоолеговичизменил");
        containsIsDisplayed("Не назначен");

    }

    public void verifyCallRegistrMkab3Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("напиши тут другой адрес");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("");
        containsIsDisplayed("321");
        containsIsDisplayed("54321");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Петров");
        containsIsDisplayed("Петр");
        containsIsDisplayed("Петрович");
        containsIsDisplayed("Автотемниковизменил");
        containsIsDisplayed("Автодмитрийизменил");
        containsIsDisplayed("Автоолеговичизменил");
        containsIsDisplayed("Не назначен");

    }

    public void verifyCallRegistrMkab3Complete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("напиши тут другой адрес");
        containsIsDisplayed("Новый");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("");
        containsIsDisplayed("321");
        containsIsDisplayed("54321");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Петров");
        containsIsDisplayed("Петр");
        containsIsDisplayed("Петрович");
        containsIsDisplayed("Автотемниковизменил");
        containsIsDisplayed("Автодмитрийизменил");
        containsIsDisplayed("Автоолеговичизменил");
        containsIsDisplayed("Не назначен");

    }


    public void verifyCallSMPNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("П-д");
        containsIsDisplayed("Домофон");
        containsIsDisplayed("Этаж");

        containsIsDisplayed("ЖАЛОБЫ");

        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("Возраст");
        containsIsDisplayed("Пол");
        containsIsDisplayed("Полис");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("Неотложный");
    }

    public void verifyCallSMP2New() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP2Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP3Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP3Complete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }


    public void verifyCallSMPMkabNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP2MkabNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP2MkabActivity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP3MkabActivity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }

    public void verifyCallSMP3MkabComplete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("СМП");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автоолегович");
        containsIsDisplayed("Взрослый");
        containsIsDisplayed("111111");
        containsIsDisplayed("222222");
        containsIsDisplayed("Пациент");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
    }


    /*
    public void verifyAppoindPoctor(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
        containsIsDisplayed("Отменить вызов");
        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("Активный");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Афанасьева");
        containsIsDisplayed("Софья");
        containsIsDisplayed("Петровна");
        containsIsDisplayed("");
        containsIsDisplayed("7854215965847521");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автодмитрий");
        containsIsDisplayed("Автоолегович");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }

    public void verifyCompleteCall(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsIsDisplayed("Дата");
        containsIsDisplayed("Время");
        containsIsDisplayed("Статус");
        containsIsDisplayed("Вид вызова");
        containsIsDisplayed("Источник");
        containsIsDisplayed("АДРЕС");
        containsIsDisplayed("ЖАЛОБЫ");
        containsIsDisplayed("Возрастная категория");
        containsIsDisplayed("КТО ПАЦИЕНТ");
        containsIsDisplayed("КТО ВЫЗВАЛ");
        containsIsDisplayed("КТО ОБСЛУЖИВАЕТ");
        containsIsDisplayed("Телефон");
        containsIsDisplayed("Врач");
        containsIsDisplayed("ИСТОРИЯ ВЫЗОВА");
        containsIsDisplayed("АВТОР");
        containsIsDisplayed("ЧТО ИЗМЕНИЛОСЬ");
        containsIsDisplayed("ИЗМЕНЕНИЕ");
//        containsIsDisplayed("Отменить вызов");
///        containsIsDisplayed("Изменить");
        containsIsDisplayed("Передать в другое ЛПУ");

        containsIsDisplayed("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsIsDisplayed("Обслуженный");
        containsIsDisplayed("Первичный");
        containsIsDisplayed("Регистратура");
        containsIsDisplayed("Афанасьева");
        containsIsDisplayed("Софья");
        containsIsDisplayed("Петровна");
        containsIsDisplayed("");
        containsIsDisplayed("7854215965847521");
        containsIsDisplayed("Представитель");
        containsIsDisplayed("Карта создана");
        containsIsDisplayed("автотест");
        containsIsDisplayed("19.02.2016");
        containsIsDisplayed("2 года");
        containsIsDisplayed("Ребенок");
        containsIsDisplayed("Автотемников");
        containsIsDisplayed("Автодмитрий");
        containsIsDisplayed("Автоолегович");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }

*/
    public void cancelBtn() {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Отменить вызов')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

    }

    public void editBtn() {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Изменить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

    }

    public void sendAnotherLPUBtn() {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Передать в другое ЛПУ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

    }

    public void sendAnotherDoctorBtn() {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Передать в другое ЛПУ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

    }

    public void appoindDoctorBtn() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Назначить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();
    }

    public void completeServiceBtn() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Завершить обслуживание')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

        click(mat_calendar_header);
        action.sendKeys(Keys.ENTER).perform();
        click(doneCall);
    }

    public void closeCardBtn() {
        WebElement close = driver.findElement(By.xpath("//img[@src='assets/img/close.png']"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }


}