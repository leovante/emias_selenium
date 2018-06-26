package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.calldoctor.Profiles_interfaces.Profile0;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.JSWaiter;

import static org.testng.Assert.assertTrue;
import static pages.utilities.Waiter.waitVisibility;

public class CreateCallPage extends BasePage implements Profile1, Profile2, Profile0 {
    @FindBy(xpath = "//div[contains(text(),'СМП')]")
    WebElement SMP;

    @FindBy(xpath = "//span/button/span/mat-icon")
    WebElement clearAdress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    WebElement placeholder_adress;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    WebElement dom;

    @FindBy(xpath = "//*[@mattooltip='Добавить вызов']")
    WebElement addCallBtn;

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

    @FindBy(xpath = "//input[@placeholder='Станция СМП']")
    WebElement stationSMP;

    @FindBy(xpath = "//div[contains(.,'Вид вызова')]")
    WebElement vidVisova;

    @FindBy(xpath = "//span[contains(.,'Пациент')]")
    WebElement pacient;

    @FindBy(xpath = "//*[contains(.,'Неотложный')]")
    WebElement neotlozhniy;

    @FindBy(id = "save")
    WebElement saveBtns;

    @FindBy(id = "callFamily")
    WebElement callFamily;

    @FindBy(id = "callName")
    WebElement callName;

    @FindBy(id = "callPatronymic")
    WebElement callPatronymic;

    @FindBy(xpath = "//div[contains(text(),'Новый вызов')]")
    WebElement noviyVizov;

    @FindBy(xpath = "//input[@placeholder='Дата рождения']")
    WebElement birthDay;

    @FindBy(id = "findPatientInput")
    WebElement findPatientInput;

    @FindBy(xpath = "//div/mat-option/span[contains(text(),'" + famPro2 + "')]")
    WebElement famPro2Xpath;

    @FindBy(id = "source0")
    WebElement source0;

    @FindBy(xpath = "//button/span[contains(text(),'Да')]")
    WebElement allarmaYes;

    public CreateCallPage(WebDriver driver) {
        super(driver);
    }

    @Step("создаю пустой вызов")
    public void createCallProfile0() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);
        waitVisibility(noviyVizov);

/*обязательные поля*/
        sendKeys(dom, domPro0);
        click(chkBoxTelephone);

        click(hz);
        click(vozr);
        hz2.click();

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro0 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

        saveBtns.click();

        click(allarmaYes);
    }

    @Step("создаю вызов без МКАБ + Регистратура")
    public void createCallProfile1(String nameGen) throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);
        waitVisibility(noviyVizov);

/*адрес*/
        placeholder_adress.clear();
        click(placeholder_adress);

        placeholder_adress.sendKeys(adressPro1_1);
        click(list_first_container);

        placeholder_adress.sendKeys(adressPro1_2);
        click(list_first_container);

        placeholder_adress.sendKeys(adressPro1_3);
        click(list_first_container);

/*обязательные поля*/
        sendKeys(dom, domPro1);
        click(chkBoxTelephone);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();

        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        sendKeys(korpus, korpusPro1);
        sendKeys(stroenie, stroeniePro1);
        sendKeys(kvartira, kvartiraPro1);
        sendKeys(pd, pdPro1);
        sendKeys(dfon, dfonPro1);
        sendKeys(etazh, etazhPro1);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro1 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        sendKeys(seriyaPol, seriyaPolPro1);
        sendKeys(nomerPol, nomerPolPro1);
        click(fam);
        sendKeys(fam, famPro1);
        sendKeys(name, nameGen);
        sendKeys(otchestvo, otchestvoPro1);
        sendKeys(birthDay, birthDayPro1);

/*кто вызывает*/
        tipVisivaushego.click();
        pacient.click();
        saveBtns.click();
    }

    @Step("создаю вызов с МКАБ + СМП")
    public void createCallProfile2(String nameGen) throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

/*кто пациент*/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Новый вызов')]")));
        sendKeys(findPatientInput, nomerPolPro2);
        clickJSext(famPro2Xpath);

/*обязательные поля*/
        click(source0);
        sendKeys(dom, domPro2);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();
        action.sendKeys(Keys.SPACE).perform();

/*необязательные поля*/
        sendKeys(pd, pdPro2);
        sendKeys(dfon, dfonPro2);
        sendKeys(etazh, etazhPro2);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro2 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();


/*кто вызывает*/
        sendKeys(callFamily, famCallPro2);
        sendKeys(callName, nameGen);
        sendKeys(callPatronymic, otCallPro2);
        sendKeys(stationSMP, stationSMPPro2);

        saveBtns.click();
    }

    @Step
    public void createCallSMP() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));

        /*адрес*/
        click(clearAdress);
        click(placeholder_adress);

        placeholder_adress.sendKeys("Московская");
        click(list_first_container);

        placeholder_adress.sendKeys("Коломна");
        click(list_first_container);

        placeholder_adress.sendKeys("Первомайская");
        click(list_first_container);

/*обязательные поля*/
        sendKeys(dom, "101");
        click(chkBoxTelephone);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='+7 (951) 158-27-14';", telephoneNumber);
        telephoneNumber.click();
        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        sendKeys(korpus, "202");
        sendKeys(stroenie, "303");
        sendKeys(kvartira, "404");
        sendKeys(pd, "505");
        sendKeys(dfon, "606");
        sendKeys(etazh, "707");

        click(vidVisova);
        clickJS(neotlozhniy);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        sendKeys(seriyaPol, "12345678");
        sendKeys(nomerPol, "87654321");
        click(fam);
        sendKeys(fam, "Автотемников");
        sendKeys(name, "Автодмитрий");
        sendKeys(otchestvo, "Автоолегович");

/*кто вызывает*/
        click(SMP);//не хочет выбирать СМП. Выбирает повторный

        tipVisivaushego.click();
        pacient.click();

        saveBtns.click();
    }

    @Step
    public void createCallSMPMkab() throws InterruptedException {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        SMP.click();//вот здесь начинаются проблемы

        /*адрес*/
        click(clearAdress);
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
        jse1.executeScript("arguments[0].value='+7 (951) 158-27-14';", telephoneNumber);
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


    @Step
    public void verifyCancelOnDashbord() {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//addCallBtn")));

        WebElement waitOperationFrame = driver.findElement(By.xpath("//span[contains(text(),'Ожидают обработки')]"));
        assertTrue(waitOperationFrame.isDisplayed() == false, "Фрейм 'Ожидают обработки' - не найден");

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
}