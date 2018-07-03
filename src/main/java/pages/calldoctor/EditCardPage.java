package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.calldoctor.Profiles_interfaces.Profile5;
import pages.utilities.JSWaiter;

import static org.testng.Assert.assertTrue;
import static pages.utilities.Waiter.waitVisibility;

public class EditCardPage extends BasePage implements Profile5 {

    @FindBy(xpath = "//addCallBtn[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//span[contains(.,'СМП')]")
    WebElement SMP;

    @FindBy(id = "4198BD84-7A21-4E38-B36B-3ECB2E956408")
    WebElement cancelAdress;

    @FindBy(xpath = "//button[@aria-label='Clear']/span/mat-icon")
    WebElement cancelBirthDate;

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

    @FindBy(xpath = "//input[@aria-label='Добавить жалобу']")
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

    @FindBy(xpath = "//span[contains(.,'Представитель')]")
    WebElement predstav;

    @FindBy(xpath = "//span[contains(.,'Неотложный')]")
    WebElement neotlozhniy;

    @FindBy(xpath = "//span[contains(text(),'Сохранить')]")
    WebElement saveBtns;

    @FindBy(id = "callFamily")
    WebElement callFamily;

    @FindBy(id = "callName")
    WebElement callName;

    @FindBy(id = "callPatronymic")
    WebElement callPatronymic;

    @FindBy(id = "birthDateTemp")
    WebElement birthDateTemp;

    @FindBy(id = "source0")
    WebElement source0;

    @FindBy(id = "sourceSmp")
    WebElement sourceSmp;

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(23, 150, 112);']")
    WebElement thisDayLoadGreen;

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(252, 194, 54);']")
    WebElement thisDayLoadYellow;

    @FindBy(xpath = "//span[contains(.,'Назначить на сегодня')]")
    WebElement appenOnThisDay;

    @FindBy(xpath = "//div[contains(.,'Найдена МКАБ пациента Петров')]")
    WebElement naidena_mkab;

    @FindBy(xpath = "//div[contains(text(),'Редактирование вызова')]")
    WebElement redactirovanieVizova;


    public EditCardPage(WebDriver driver) {
        super(driver);
    }

    @Step("редактирую вызов без привязывания МКАБ")
    public void editCallProfile5(String nameGen) {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        waitVisibility(redactirovanieVizova);

/*адрес*/
        click(cancelAdress);
        click(placeholder_adress);
        placeholder_adress.clear();

        placeholder_adress.sendKeys(adressPro5_1);
        click(list_first_container);

        placeholder_adress.sendKeys(adressPro5_2);
        click(list_first_container);

        placeholder_adress.sendKeys(adressPro5_3);
        click(list_first_container);

/*обязательные поля*/
        sendKeysJS(dom, domPro5);
        click(cancelBirthDate);
        sendKeysJS(birthDateTemp, birthDayPro5);

        telephoneNumber.clear();
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro5 + "';", telephoneNumber);
        telephoneNumber.click();
        action.sendKeys(Keys.SPACE).perform();

/*необязательные поля*/
        click(source0);
        sendKeysJS(korpus, korpusPro5);
        sendKeysJS(stroenie, stroeniePro5);
        sendKeysJS(kvartira, kvartiraPro5);
        sendKeysJS(pd, pdPro5);
        sendKeysJS(dfon, dfonPro5);
        sendKeysJS(etazh, etazhPro5);
        sendKeysJS(sourceSmp, stationSMPPro5);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro5 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        sendKeysJS(seriyaPol, seriyaPolPro5);
        sendKeysJS(nomerPol, nomerPolPro5);
        click(fam);
        sendKeysJS(fam, famPro5);
        sendKeysJS(name, nameGen);
        sendKeysJS(otchestvo, otchestvoPro5);

/*кто вызывает*/
//        tipVisivaushego.click();
//        pacient.click();
        sendKeysJS(sourceSmp, stationSMPPro5);
        sendKeysJS(callFamily, famCallPro5);
        sendKeysJS(callName, nameCallPro5);
        sendKeysJS(callPatronymic, otCallPro5);

        click(saveBtns);
    }


    public void editCallToMkab2() {
        Actions action = new Actions(driver);
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
        dom.clear();
        click(dom);
        dom.sendKeys("1");

//        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//        jse1.executeScript("arguments[0].value='+7 (951) 158-27-14';", telephoneNumber);
//        click(telephoneNumber);
//        action.sendKeysJS(Keys.ENTER);
        click(chkBoxTelephone);
        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        korpus.clear();
        korpus.sendKeys("2");
        stroenie.clear();
        stroenie.sendKeys("3");
        kvartira.clear();
        kvartira.sendKeys("4");
        pd.clear();
        pd.sendKeys("5");
        dfon.clear();
        dfon.sendKeys("6");
        etazh.clear();
        etazh.sendKeys("7");

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        seriyaPol.clear();
        seriyaPol.sendKeys("321");
        nomerPol.clear();
        nomerPol.sendKeys("54321");
//        click(fam);
//        fam.sendKeysJS("Автотемников");
//        name.sendKeysJS("Автодмитрий");
//        otchestvo.sendKeysJS("Автоолегович");

/*кто вызывает*/
        tipVisivaushego.click();
        predstav.click();
//        click(callFamily);
        callFamily.clear();
        callFamily.sendKeys("Автотемниковизменил");
        callName.clear();
        callName.sendKeys("Автодмитрийизменил");
        callPatronymic.clear();
        callPatronymic.sendKeys("Автоолеговичизменил");

        assertTrue(naidena_mkab.isEnabled());
    }

    public void verifyCallMkabNew() throws InterruptedException {
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

        isDisplayedOnCardPage("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        isDisplayedOnCardPage("Новый");
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
        isDisplayedOnCardPage("Не назначен");

    }

    @Step("редактирвоать вызов")
    public void editCallBtn() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement editBtn = driver.findElement(By.xpath("//button[@id='change']"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
    }
}