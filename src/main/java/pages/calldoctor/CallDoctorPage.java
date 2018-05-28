package pages.calldoctor;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

import static org.testng.AssertJUnit.assertTrue;

public class CallDoctorPage extends BasePage {

    @FindBy(xpath = "//addCallBtn[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//span[contains(.,'СМП')]")
    WebElement SMP;

    @FindBy(xpath = "//span/mat-icon")
    WebElement cancelAdress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    WebElement placeholder_adress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container'")
    WebElement containerKladr;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    WebElement dom;

    @FindBy(xpath = "//*[@mattooltip='Добавить вызов']")
    WebElement addCallBtn;

    @FindBy(xpath = "//span/mat-icon")
    WebElement mat_icon;

    @FindBy(id = "phone")
    WebElement telephoneNumber;

    @FindBy(xpath = "//label[@class='mat-checkbox-layout']/div")
    WebElement chkBoxTelephone;

    @FindBy(xpath = "//button[2]/span/mat-icon")
    WebElement hz;

    @FindBy(xpath = "//input[@placeholder='Возр. категория']")
    WebElement vozr;

    @FindBy(xpath = "//span[contains(.,'Взрослый')]")
    WebElement hz2;

    @FindBy(xpath = "//input[@placeholder='Корпус']")
    WebElement korpus;

    @FindBy(xpath = "//input[@placeholder='Строение']")
    WebElement stroenie;

    @FindBy(xpath = "//input[@placeholder='Квартира']")
    WebElement kvartira;

    @FindBy(xpath = "//input[@placeholder='П-д']")
    WebElement pd;

    @FindBy(xpath = "//input[@placeholder='Д-фон']")
    WebElement dfon;

    @FindBy(xpath = "//input[@placeholder='Этаж']")
    WebElement etazh;

    @FindBy(xpath = "//input[@aria-label='Введите текст жалобы']")
    WebElement zhaloba;

    @FindBy(xpath = "//input[@placeholder='Серия']")
    WebElement seriyaPol;

    @FindBy(xpath = "//input[@placeholder='Номер полиса']")
    WebElement nomerPol;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    WebElement fam;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    WebElement otchestvo;

    @FindBy(xpath = "//input[@placeholder='Тип вызывающего']")
    WebElement tipVisivaushego;

    @FindBy(xpath = "//input[@placeholder='Вид вызова']")
    WebElement vidVisova;

    @FindBy(xpath = "//span[contains(.,'Пациент')]")
    WebElement pacient;

    @FindBy(xpath = "//span[contains(.,'Неотложный')]")
    WebElement neotlozhniy;

    @FindBy(xpath = "//button[3]/span/span")
    WebElement saveBtns;

    public CallDoctorPage(WebDriver driver) {
        super(driver);
    }

    public void createCallRegistratura() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

/*адрес*/
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        click(cancelAdress);
        click(placeholder_adress);

        placeholder_adress.sendKeys("Московская");
        click(list_first_container);

        placeholder_adress.sendKeys("Коломна");
        click(list_first_container);

        placeholder_adress.sendKeys("Первомайская");
        click(list_first_container);

/*обязательные поля*/
        click(dom);
        dom.sendKeys("1");

//        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//        jse1.executeScript("arguments[0].value='+79511582714';", telephoneNumber);
//        click(telephoneNumber);
//        action.sendKeys(Keys.ENTER);
        click(chkBoxTelephone);
        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        korpus.sendKeys("2");
        stroenie.sendKeys("3");
        kvartira.sendKeys("4");
        pd.sendKeys("5");
        dfon.sendKeys("6");
        etazh.sendKeys("7");

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        seriyaPol.sendKeys("111111");
        nomerPol.sendKeys("222222");
        fam.sendKeys("Автотемников");
        name.sendKeys("Автодмитрий");
        otchestvo.sendKeys("Автоолегович");

/*кто вызывает*/
        tipVisivaushego.click();
        pacient.click();
        saveBtns.click();
    }

    public void createCallSMP() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        SMP.click();//вот здесь начинаются проблемы

        /*адрес*/
        click(cancelAdress);
        click(placeholder_adress);

        placeholder_adress.sendKeys("Московская");
        click(list_first_container);

        placeholder_adress.sendKeys("Коломна");
        click(list_first_container);

        placeholder_adress.sendKeys("Первомайская");
        click(list_first_container);

/*обязательные поля*/
        click(dom);
        dom.sendKeys("1");

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='+79511582714';", telephoneNumber);
        click(telephoneNumber);
//        action.sendKeys(Keys.ENTER);
//        click(chkBoxTelephone);
        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        korpus.sendKeys("2");
        stroenie.sendKeys("3");
        kvartira.sendKeys("4");
        pd.sendKeys("5");
        dfon.sendKeys("6");
        etazh.sendKeys("7");
        click(vidVisova);
        click(neotlozhniy);
/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        seriyaPol.sendKeys("111111");
        nomerPol.sendKeys("222222");
        fam.sendKeys("Автотемников");
        name.sendKeys("Автодмитрий");
        otchestvo.sendKeys("Автоолегович");

/*кто вызывает*/
        tipVisivaushego.click();
        pacient.click();
        saveBtns.click();
    }

    public void verifyCallRegistr() throws InterruptedException {
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

    public void cancelRecord() {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Подробно о вызове')]")));

        WebElement cancelBtns = driver.findElement(By.xpath("//span[contains(text(),'Отменить вызов')]"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtns));
        cancelBtns.click();

        WebElement cancelField = driver.findElement(By.xpath("//input[@placeholder='Причина отмены вызова']"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelField));
        cancelField.sendKeys("отмена автотест");

        WebElement cancelFieldBtn = driver.findElement(By.xpath("//a[@title='Отменить вызов']"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelFieldBtn));
        cancelFieldBtn.click();
    }

    public void verifyCancelOnDashbord() {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//addCallBtn")));

        WebElement waitOperationFrame = driver.findElement(By.xpath("//span[contains(text(),'Ожидают обработки')]"));
        assertTrue("Фрейм 'Ожидают обработки' - не найден", waitOperationFrame.isDisplayed() == false);

/*
        WebElement waitOperation = driver.findElement(By.xpath("//span[contains(text(),'Ожидают обработки')]"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//span[contains(text(),'Ожидают обработки')]")));
        waitOperation.click();
*/

/*
        WebElement close = driver.findElement(By.xpath("//img[@src='assets/img/close.png']"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();

        WebElement podrobnoOVizove = driver.findElement(By.xpath("//div[contains(text(),'Подробно о вызове')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(podrobnoOVizove));
*/
    }

    public void closeRecordPage() {
        WebElement close = driver.findElement(By.xpath("//img[@src='assets/img/close.png']"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }
}