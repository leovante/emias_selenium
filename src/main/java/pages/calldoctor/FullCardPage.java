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

public class FullCardPage extends BasePage implements Profile1 {

    @FindBy(id = "doneCall")
    WebElement doneCall;

    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']")
    WebElement mat_calendar_header;

    @FindBy(xpath = "//*[contains(.,'Что изменилось')]")
    WebElement chtoIzmenilos;

    @FindBy(xpath = "//span[contains(text(),'Передать другому врачу')]")
    WebElement appoindBtn;

    public FullCardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void verifyCallProfile1(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Не назначен");
//        isDisplayedOnCardPage("Стенд ЕМИАС МО");

        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public void verifyCallProfile1Activity(String doctorFam, String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Активный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Пациент");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Назначенный врач");
        isDisplayedOnCardPage("Дата перевода в статус активный");

        //параметры профиля
        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(doctorFam);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public void verifyDoneDocGroup(String doctorFam, String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        driver.navigate().refresh();

        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement2 = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");


        isDisplayedOnCardPage("Обслуженный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Пациент");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Активный");
        isDisplayedOnCardPage("Назначенный врач");
        isDisplayedOnCardPage("Дата перевода в статус активный");
        isDisplayedOnCardPage("Дата и время завершения обслуживания вызова");

        //параметры профиля
        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(doctorFam);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public void verifyCallProfile2(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.101, корп.202, стр.303, кв.404");
        isDisplayedOnCardPage("505");
        isDisplayedOnCardPage("606");
        isDisplayedOnCardPage("707");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Афанасьева");
        isDisplayedOnCardPage("Софья");
        isDisplayedOnCardPage("Петровна");
        isDisplayedOnCardPage("Ж");
        isDisplayedOnCardPage("7854215965847521");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автодмитрий");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Не назначен");
    }

    public void verifyCallRegistrMkab2New() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("напиши тут другой адрес");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("321");
        isDisplayedOnCardPage("54321");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Петров");
        isDisplayedOnCardPage("Петр");
        isDisplayedOnCardPage("Петрович");
        isDisplayedOnCardPage("Автотемниковизменил");
        isDisplayedOnCardPage("Автодмитрийизменил");
        isDisplayedOnCardPage("Автоолеговичизменил");
        isDisplayedOnCardPage("Не назначен");

    }

    public void verifyCallRegistrMkab2Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("напиши тут другой адрес");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("321");
        isDisplayedOnCardPage("54321");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Петров");
        isDisplayedOnCardPage("Петр");
        isDisplayedOnCardPage("Петрович");
        isDisplayedOnCardPage("Автотемниковизменил");
        isDisplayedOnCardPage("Автодмитрийизменил");
        isDisplayedOnCardPage("Автоолеговичизменил");
        isDisplayedOnCardPage("Не назначен");

    }

    public void verifyCallRegistrMkab3Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("напиши тут другой адрес");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("321");
        isDisplayedOnCardPage("54321");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Петров");
        isDisplayedOnCardPage("Петр");
        isDisplayedOnCardPage("Петрович");
        isDisplayedOnCardPage("Автотемниковизменил");
        isDisplayedOnCardPage("Автодмитрийизменил");
        isDisplayedOnCardPage("Автоолеговичизменил");
        isDisplayedOnCardPage("Не назначен");

    }

    public void verifyCallRegistrMkab3Complete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("напиши тут другой адрес");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("321");
        isDisplayedOnCardPage("54321");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Петров");
        isDisplayedOnCardPage("Петр");
        isDisplayedOnCardPage("Петрович");
        isDisplayedOnCardPage("Автотемниковизменил");
        isDisplayedOnCardPage("Автодмитрийизменил");
        isDisplayedOnCardPage("Автоолеговичизменил");
        isDisplayedOnCardPage("Не назначен");

    }


    public void verifyCallSMPNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");

        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("Неотложный");
    }

    public void verifyCallSMP2New() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP2Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP3Activity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP3Complete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }


    public void verifyCallSMPMkabNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP2MkabNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP2MkabActivity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP3MkabActivity() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    public void verifyCallSMP3MkabComplete() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("СМП");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автоолегович");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("111111");
        isDisplayedOnCardPage("222222");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
    }

    /*
    public void verifyAppoindPoctor(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("Активный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Афанасьева");
        isDisplayedOnCardPage("Софья");
        isDisplayedOnCardPage("Петровна");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("7854215965847521");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автодмитрий");
        isDisplayedOnCardPage("Автоолегович");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }

    public void verifyCompleteCall(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
//        isDisplayedOnCardPage("Отменить вызов");
///        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("Обслуженный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Афанасьева");
        isDisplayedOnCardPage("Софья");
        isDisplayedOnCardPage("Петровна");
        isDisplayedOnCardPage("");
        isDisplayedOnCardPage("7854215965847521");
        isDisplayedOnCardPage("Представитель");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("автотест");
        isDisplayedOnCardPage("19.02.2016");
        isDisplayedOnCardPage("2 года");
        isDisplayedOnCardPage("Ребенок");
        isDisplayedOnCardPage("Автотемников");
        isDisplayedOnCardPage("Автодмитрий");
        isDisplayedOnCardPage("Автоолегович");

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

    @Step
    public void sendAnotherDoctorBtn() {
        click(appoindBtn);
    }

    @Step
    public void appoindDoctorBtn() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Назначить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();
    }

    @Step
    public void completeServiceBtn() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Actions action = new Actions(driver);
        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Завершить обслуживание')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

        click(mat_calendar_header);
        action.sendKeys(Keys.ENTER).perform();
        click(doneCall);
    }

    @Step
    public void closeCardBtn() {
        WebElement close = driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }
}