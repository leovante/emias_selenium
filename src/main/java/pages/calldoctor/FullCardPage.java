package pages.calldoctor;

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

import static org.testng.AssertJUnit.assertTrue;

public class FullCardPage extends BasePage {

    @FindBy(id = "doneCall")
    WebElement doneCall;

    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']")
    WebElement mat_calendar_header;

    public FullCardPage(WebDriver driver) {
        super(driver);
    }

    public void appoindDoctor() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Назначить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();
    }

    public void completeService() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Завершить обслуживание')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

        click(mat_calendar_header);
        action.sendKeys(Keys.ENTER).perform();
        click(doneCall);
    }


    public void verifyCallRegistr() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
        containsClickable("Отменить вызов");
        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Новый");
        containsClickable("Первичный");
        containsClickable("Регистратура");
        containsClickable("Автотемников");
        containsClickable("Автоолегович");
        containsClickable("Взрослый");
        containsClickable("111111");
        containsClickable("222222");
        containsClickable("Пациент");
        containsClickable("Карта создана");
        containsClickable("автотест");
        containsClickable("Не назначен");
    }

    public void verifyCallMkab() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
        containsClickable("Отменить вызов");
        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Новый");
        containsClickable("Первичный");
        containsClickable("Регистратура");
        containsClickable("Афанасьева");
        containsClickable("Софья");
        containsClickable("Петровна");
        containsClickable("");
        containsClickable("7854215965847521");
        containsClickable("Представитель");
        containsClickable("Карта создана");
        containsClickable("автотест");
        containsClickable("19.02.2016");
        containsClickable("2 года");
        containsClickable("Ребенок");
        containsClickable("Автотемников");
        containsClickable("Автодмитрий");
        containsClickable("Автоолегович");
        containsClickable("Не назначен");
    }

    public void verifyCallSMP() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
        containsClickable("Отменить вызов");
        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Регистратура");
        containsClickable("Автотемников");
        containsClickable("Автоолегович");
        containsClickable("Взрослый");
        containsClickable("111111");
        containsClickable("222222");
        containsClickable("Пациент");
        containsClickable("Карта создана");
        containsClickable("автотест");
    }

    public void verifyAppoindPoctor(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
        containsClickable("Отменить вызов");
        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Активный");
        containsClickable("Первичный");
        containsClickable("Регистратура");
        containsClickable("Афанасьева");
        containsClickable("Софья");
        containsClickable("Петровна");
        containsClickable("");
        containsClickable("7854215965847521");
        containsClickable("Представитель");
        containsClickable("Карта создана");
        containsClickable("автотест");
        containsClickable("19.02.2016");
        containsClickable("2 года");
        containsClickable("Ребенок");
        containsClickable("Автотемников");
        containsClickable("Автодмитрий");
        containsClickable("Автоолегович");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }

    public void verifyCompleteCall(String doctorFam) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
//        containsClickable("Отменить вызов");
///        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Обслуженный");
        containsClickable("Первичный");
        containsClickable("Регистратура");
        containsClickable("Афанасьева");
        containsClickable("Софья");
        containsClickable("Петровна");
        containsClickable("");
        containsClickable("7854215965847521");
        containsClickable("Представитель");
        containsClickable("Карта создана");
        containsClickable("автотест");
        containsClickable("19.02.2016");
        containsClickable("2 года");
        containsClickable("Ребенок");
        containsClickable("Автотемников");
        containsClickable("Автодмитрий");
        containsClickable("Автоолегович");

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")).isDisplayed());
    }
}