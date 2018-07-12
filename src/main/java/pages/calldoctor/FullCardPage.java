package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.*;
import pages.utilities.JSWaiter;

import static org.testng.Assert.assertTrue;

public class FullCardPage extends AbstractPage implements
        Profile0,
        Profile1,
        Profile2,
        Profile3,
        Profile4,
        Profile5,
        Profile6 {

    @FindBy(id = "doneCall")
    @CacheLookup
    WebElement doneCall;

    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']")
    @CacheLookup
    WebElement mat_calendar_header;

    @FindBy(xpath = "//span[contains(text(),'Передать другому врачу')]")
    @CacheLookup
    WebElement appoindBtn;

    @FindBy(xpath = "//span[contains(text(),'Завершить обслуживание')]")
    @CacheLookup
    WebElement appoindBtns;

    @FindBy(id = "cancel")
    @CacheLookup
    WebElement cancelBtn;

    @FindBy(id = "cancelCall")
    @CacheLookup
    WebElement cancelCall;

    @FindBy(xpath = "//a[@title='Отменить вызов']")
    @CacheLookup
    WebElement cancelCall2;

    @FindBy(id = "change")
    @CacheLookup
    WebElement change;

    @FindBy(xpath = "//input[@placeholder='Причина отмены вызова']")
    @CacheLookup
    WebElement cancelField;


    public FullCardPage(WebDriver driver) {
        super(driver);
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfile0() throws InterruptedException {
        isDisplayedJS("Карта вызова");
        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Взрослые");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Не назначен");

        isDisplayedOnCardPage(adressPro0);
        isDisplayedOnCardPage(zhalobaPro0);
        return this;
    }

    @Step("проверяю новый вызов")
    public FullCardPage verifyCallProfile1(String nameGen) throws InterruptedException {
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
        isDisplayedOnCardPage("Взрослые");
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
        return this;
    }

    @Step("проверяю активный вызов")
    public FullCardPage verifyCallProfile1Activity(String doctorFam, String nameGen) throws InterruptedException {
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
        isDisplayedOnCardPage("Плановое время обхода");

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
        return this;
    }

    @Step("проверяю обслуженный вызов")
    public FullCardPage verifyDoneDocGroup(String doctorFam, String nameGen) throws InterruptedException {
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
        return this;
    }

    @Step("проверяю новый вызов")
    public String verifyCallProfile2(String nameGen) throws InterruptedException {
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
        isDisplayedOnCardPage("Тип вызывающего");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("СМП");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");

        //параметры профиля
        isDisplayedOnCardPage(adressPro2);
        isDisplayedOnCardPage(pdPro2);
        isDisplayedOnCardPage(dfonPro2);
        isDisplayedOnCardPage(etazhPro2);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(famPro2);
        isDisplayedOnCardPage(namePro2);

        isDisplayedOnCardPage(otchestvoPro2);
        isDisplayedOnCardPage(nomerPolPro2);
        isDisplayedOnCardPage(zhalobaPro2);
        isDisplayedOnCardPage(birthDayPro2);
        isDisplayedOnCardPage(goda24Pro2);
        isDisplayedOnCardPage(vozrastKatPro2);

        isDisplayedOnCardPage(telephonePro2);
        isDisplayedOnCardPage(genderPro2);

        isDisplayedOnCardPage(nameCallPro2);
        isDisplayedOnCardPage(famCallPro2);
        isDisplayedOnCardPage(otCallPro2);

        isDisplayedOnCardPage(stationSMPPro2);
        return famPro2;
    }

    @Step("проверяю новый вызов от api СМП без МКАБ")
    public FullCardPage verifyCallProfile3(String nameGen) throws InterruptedException {
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

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Неотложный");
        isDisplayedOnCardPage("СМП");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Стенд ЕМИАС МО");

        //параметры профиля
        assertTrue(makeWebelement(adressPro3).isDisplayed());
        assertTrue(makeWebelement(pdPro3).isDisplayed());
        assertTrue(makeWebelement(dfonPro3).isDisplayed());
        assertTrue(makeWebelement(etazhPro3).isDisplayed());

        assertTrue(makeWebelement(nomerPolPro3).isDisplayed());
        assertTrue(makeWebelement(zhalobaPro3).isDisplayed());
        assertTrue(makeWebelement(birthDayPro3).isDisplayed());
        assertTrue(makeWebelement(goda24Pro3).isDisplayed());
        assertTrue(makeWebelement(vozrastKatPro3).isDisplayed());

        assertTrue(makeWebelement(telephonePro3).isDisplayed());
        assertTrue(makeWebelement(genderPro3).isDisplayed());
        assertTrue(makeWebelement(nameGen).isDisplayed());
        return this;
    }

    @Step("проверяю новый вызов от api СМП без МКАБ")
    public FullCardPage verifyCallProfile6(String nameGen) throws InterruptedException {
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
//        isDisplayedOnCardPage("Тип вызывающего");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Неотложный");
        isDisplayedOnCardPage("СМП");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Стенд ЕМИАС МО");

        //параметры профиля
        assertTrue(makeWebelement(adressPro6).isDisplayed());
        assertTrue(makeWebelement(pdPro6).isDisplayed());
        assertTrue(makeWebelement(dfonPro6).isDisplayed());
        assertTrue(makeWebelement(etazhPro6).isDisplayed());

        assertTrue(makeWebelement(nomerPolPro6).isDisplayed());
        assertTrue(makeWebelement(zhalobaPro6).isDisplayed());
        assertTrue(makeWebelement(birthDayPro6).isDisplayed());
        assertTrue(makeWebelement(goda24Pro6).isDisplayed());
        assertTrue(makeWebelement(vozrastKatPro6).isDisplayed());

        assertTrue(makeWebelement(telephonePro6).isDisplayed());
        assertTrue(makeWebelement(genderPro6).isDisplayed());
        assertTrue(makeWebelement(nameGen).isDisplayed());
        return this;
    }

    @Step("проверяю новый вызов через Портал")
    public FullCardPage verifyCallProfile4(String nameGen) throws InterruptedException {
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

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Интернет");

        //в истории вызова
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Стенд ЕМИАС МО");

        //параметры профиля
        assertTrue(makeWebelement(adressPro4).isDisplayed());
        assertTrue(makeWebelement(pdPro4).isDisplayed());
        assertTrue(makeWebelement(etazhPro4).isDisplayed());
        assertTrue(makeWebelement(dfonPro4).isDisplayed());
        assertTrue(makeWebelement(famPro4).isDisplayed());
        assertTrue(makeWebelement(otchestvoPro4).isDisplayed());

        assertTrue(makeWebelement(nomerPolPro4).isDisplayed());
        assertTrue(makeWebelement(zhalobaPro4).isDisplayed());
        assertTrue(makeWebelement(birthDayPro4).isDisplayed());
        assertTrue(makeWebelement(goda24Pro4).isDisplayed());
        assertTrue(makeWebelement(vozrastKatPro4).isDisplayed());

        isDisplayedOnCardPage("+7 (951) 158-27-14");
        assertTrue(makeWebelement(genderPro4).isDisplayed());
        return this;
    }

    @Step("проверяю отредактированный вызов")
    public FullCardPage verifyCallProfile5(String nameGen) throws InterruptedException {
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
        isDisplayedOnCardPage("Тип вызывающего");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("СМП");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("ЖАЛОБЫ");
//        isDisplayedOnCardPage("Серия полиса");
        isDisplayedOnCardPage("Номер полиса");
        isDisplayedOnCardPage("Имя вызывающего");

        //адрес
        isDisplayedOnCardPage(adressPro5);
        isDisplayedOnCardPage(pdPro5);
        isDisplayedOnCardPage(dfonPro5);
        isDisplayedOnCardPage(etazhPro5);
        //кто пациент
        isDisplayedOnCardPage(famPro5);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(otchestvoPro5);
        isDisplayedOnCardPage(birthDayPro5);
        isDisplayedOnCardPage(goda24Pro5);
        isDisplayedOnCardPage(vozrastKatPro5);
        isDisplayedOnCardPage(nomerPolPro5);
        isDisplayedOnCardPage(seriyaPolPro5);
        isDisplayedOnCardPage(genderPro5);
        //жалобы
        isDisplayedOnCardPage(zhalobaPro5);
        isDisplayedOnCardPage(zhalobaPro1);
        //кто вызвал
        isDisplayedOnCardPage(telephonePro5);
        isDisplayedOnCardPage(nameCallPro5);
        isDisplayedOnCardPage(famCallPro5);
        isDisplayedOnCardPage(otCallPro5);
        isDisplayedOnCardPage(stationSMPPro5);
        //кто обслуживает
        isDisplayedOnCardPage("Не назначен");
        return this;
    }


    @Step("отмена вызов на странице подробной карты вызова")
    public FullCardPage cancelRecordOnFullCardPage() {
        isDisplayedJS("Карта вызова");
        click(cancelBtn);
        sendKeysJS(cancelField, "отмена автотестом");
        click(cancelCall);
        return this;
    }

    @Step("нажимаю на передать другому врачу")
    public void sendAnotherDoctorBtn() {
        click(appoindBtn);
    }

    @Step("нажимаю на назначить врача")
    public FullCardPage appoindDoctorBtn() {
        isDisplayedJS("Карта вызова");
        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Назначить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();
        return this;
    }

    @Step("нажимаю на завершить обслуживание")
    public FullCardPage completeServiceBtn() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        isDisplayedJS("Карта вызова");
        Actions action = new Actions(driver);
        click(appoindBtns);

        click(mat_calendar_header);
        action.sendKeys(Keys.ENTER).perform();
        click(doneCall);
        Thread.sleep(1000);
        return this;
    }


    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage cancelRecordOnChangePage() {
        isDisplayedJS("Редактирование вызова");
        click(cancelCall);
        sendKeysJS(cancelField, "отмена автотестом");
        click(cancelCall2);
        return this;
    }

    @Step("отмена вызов на странице редактирвоания")
    public FullCardPage editCallBtn() {
        isDisplayedJS("Карта вызова");
        click(change);
        return this;
    }


    @Step("закрыть подробную карту")
    public FullCardPage closeCardBtn() {
        isDisplayedJS("Карта вызова");
        clickJS(driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]")));
        return this;
    }
}