package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile5;
import pages.utilities.JSWaiter;

import static org.testng.Assert.assertTrue;

public class PerformCardPage extends AbstractPage implements Profile1, Profile5 {

    @FindBy(id = "4198BD84-7A21-4E38-B36B-3ECB2E956408")
    @CacheLookup
    WebElement cancelAdress;

    @FindBy(xpath = "//button[@aria-label='Clear']/span/mat-icon")
    @CacheLookup
    WebElement cancelBirthDate;

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    @CacheLookup
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    @CacheLookup
    WebElement placeholder_adress;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    @CacheLookup
    WebElement dom;

    @FindBy(id = "phone")
    @CacheLookup
    WebElement telephoneNumber;

    @FindBy(xpath = "//label[@class='mat-checkbox-layout']/div")
    @CacheLookup
    WebElement chkBoxTelephone;

    @FindBy(xpath = "//button[2]/span/mat-icon")
    @CacheLookup
    WebElement hz;

    @FindBy(xpath = "//input[@placeholder='Возр. категория']")
    @CacheLookup
    WebElement vozr;

    @FindBy(xpath = "//span[contains(.,'Взрослый')]")
    @CacheLookup
    WebElement hz2;

    @FindBy(xpath = "//input[@placeholder='Корпус']")
    @CacheLookup
    WebElement korpus;

    @FindBy(xpath = "//input[@placeholder='Строение']")
    @CacheLookup
    WebElement stroenie;

    @FindBy(xpath = "//input[@placeholder='Квартира']")
    @CacheLookup
    WebElement kvartira;

    @FindBy(xpath = "//input[@placeholder='П-д']")
    @CacheLookup
    WebElement pd;

    @FindBy(xpath = "//input[@placeholder='Д-фон']")
    @CacheLookup
    WebElement dfon;

    @FindBy(xpath = "//input[@placeholder='Этаж']")
    @CacheLookup
    WebElement etazh;

    @FindBy(xpath = "//input[@aria-label='Добавить жалобу']")
    @CacheLookup
    WebElement zhaloba;

    @FindBy(xpath = "//input[@placeholder='Серия']")
    @CacheLookup
    WebElement seriyaPol;

    @FindBy(xpath = "//input[@placeholder='Номер полиса']")
    @CacheLookup
    WebElement nomerPol;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    @CacheLookup
    WebElement fam;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    @CacheLookup
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    @CacheLookup
    WebElement otchestvo;

    @FindBy(xpath = "//input[@placeholder='Тип вызывающего']")
    @CacheLookup
    WebElement tipVisivaushego;

    @FindBy(xpath = "//span[contains(.,'Представитель')]")
    @CacheLookup
    WebElement predstav;

    @FindBy(xpath = "//span[contains(text(),'Сохранить')]")
    @CacheLookup
    WebElement saveBtns;

    @FindBy(id = "callFamily")
    @CacheLookup
    WebElement callFamily;

    @FindBy(id = "callName")
    @CacheLookup
    WebElement callName;

    @FindBy(id = "callPatronymic")
    @CacheLookup
    WebElement callPatronymic;

    @FindBy(id = "birthDateTemp")
    @CacheLookup
    WebElement birthDateTemp;

    @FindBy(id = "source0")
    @CacheLookup
    WebElement source0;

    @FindBy(id = "sourceSmp")
    @CacheLookup
    WebElement sourceSmp;

    @FindBy(id = "phone")
    @CacheLookup
    WebElement phone;

    @FindBy(xpath = "//div[contains(.,'Найдена МКАБ пациента Петров')]")
    @CacheLookup
    WebElement naidena_mkab;

    @FindBy(xpath = "//div[contains(text(),'Редактирование вызова')]")
    @CacheLookup
    WebElement redactirovanieVizova;


    public PerformCardPage(WebDriver driver) {
        super(driver);
    }

    @Step("редактирую вызов без привязывания МКАБ")
    public PerformCardPage editCallProfile5(String nameGen) {
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
        return this;
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

    @Step("проверяю на странице редактирования корректность данных")
    public PerformCardPage verifyCallProfile1() throws InterruptedException {
        JSWaiter.waitJQueryAngular();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        assertTrue(getWebElementValue(phone).equals(telephonePro1));

        /**
         * источник
         * вид вызова
         * серия
         * номер
         * фам
         * имя
         * от
         * др
         * возраст
         * возр кат
         * пол
         * адрес
         * дом
         * корпус
         * строение
         * квартира
         * п-д
         * д-фон
         * этаж
         * жалобы
         * тип вызывающего
         * фам
         * имя
         * от
         * телефон
         */

        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");
        isDisplayedOnCardPage("КТО ВЫЗЫВАЕТ");
        isDisplayedOnCardPage("Телефон");

        return this;
    }

    @Step("редактирвоать вызов")
    public PerformCardPage editCallBtn() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement editBtn = driver.findElement(By.xpath("//button[@id='change']"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
        return this;
    }
}