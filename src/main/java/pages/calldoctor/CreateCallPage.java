package pages.calldoctor;

import io.qameta.allure.Step;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.Profile0;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile4;
import pages.utilities.JSWaiter;

import java.io.InputStream;


public class CreateCallPage extends AbstractPage implements Profile1, Profile2, Profile0, Profile4 {

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    @CacheLookup
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    @CacheLookup
    WebElement placeholder_adress;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    @CacheLookup
    WebElement dom;

    @FindBy(xpath = "//*[@mattooltip='Добавить вызов']")
    @CacheLookup
    WebElement addCallBtn;

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

    @FindBy(xpath = "//input[@aria-label='Введите текст жалобы']")
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

    @FindBy(xpath = "//input[@placeholder='Станция СМП']")
    @CacheLookup
    WebElement stationSMP;

    @FindBy(xpath = "//span[contains(.,'Пациент')]")
    @CacheLookup
    WebElement pacient;

    @FindBy(id = "save")
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

    @FindBy(xpath = "//div[contains(text(),'Новый вызов')]")
    @CacheLookup
    WebElement noviyVizov;

    @FindBy(xpath = "//input[@placeholder='Дата рождения']")
    @CacheLookup
    WebElement birthDay;

    @FindBy(id = "findPatientInput")
    @CacheLookup
    WebElement findPatientInput;

    @FindBy(xpath = "//div/mat-option/span[contains(text(),'" + famPro2 + "')]")
    @CacheLookup
    WebElement famPro2Xpath;

    @FindBy(id = "source0")
    @CacheLookup
    WebElement source0;

    @FindBy(xpath = "//button/span[contains(text(),'Да')]")
    @CacheLookup
    WebElement allarmaYes;

    @FindBy(id = "sex1")
    @CacheLookup
    WebElement sex1;

    public CreateCallPage(WebDriver driver) {
        super(driver);
    }

    @Step("создаю пустой вызов")
    public void createCallProfile0() {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);
        waitVisibility(noviyVizov);

/*обязательные поля*/
        sendKeysJS(dom, domPro0);
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
    public void createCallProfile1(String nameGen) {
        Actions action = new Actions(driver);
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

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
        sendKeysJS(dom, domPro1);
//        click(chkBoxTelephone);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();
        action.sendKeys(Keys.SPACE).perform();

        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        sendKeysJS(korpus, korpusPro1);
        sendKeysJS(stroenie, stroeniePro1);
        sendKeysJS(kvartira, kvartiraPro1);
        sendKeysJS(pd, pdPro1);
        sendKeysJS(dfon, dfonPro1);
        sendKeysJS(etazh, etazhPro1);
        click(sex1);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro1 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        sendKeysJS(seriyaPol, seriyaPolPro1);
        sendKeysJS(nomerPol, nomerPolPro1);
        click(fam);
        sendKeysJS(fam, famPro1);
        sendKeysJS(name, nameGen);
        sendKeysJS(otchestvo, otchestvoPro1);
        sendKeysJS(birthDay, birthDayPro1);

/*кто вызывает*/
        tipVisivaushego.click();
        pacient.click();
        saveBtns.click();
    }

    @Step("создаю вызов с МКАБ + СМП")
    public void createCallProfile2(String nameGen) {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);

/*кто пациент*/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Новый вызов')]")));
        sendKeysJS(findPatientInput, nomerPolPro2);
        clickJSext(famPro2Xpath);

/*обязательные поля*/
        click(source0);
        sendKeysJS(dom, domPro2);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();
        action.sendKeys(Keys.SPACE).perform();

/*необязательные поля*/
        sendKeysJS(pd, pdPro2);
        sendKeysJS(dfon, dfonPro2);
        sendKeysJS(etazh, etazhPro2);
        click(sex1);

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro2 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();


/*кто вызывает*/
        sendKeysJS(callFamily, famCallPro2);
        sendKeysJS(callName, nameGen);
        sendKeysJS(callPatronymic, otCallPro2);
        sendKeysJS(stationSMP, stationSMPPro2);

        saveBtns.click();
    }

    @Step("создаю вызов от СМП по api")
    public void createCallProfile3(String nameGen) {
        HttpClient httpClient = HttpClients.createDefault();
        JSONObject json = new JSONObject();
        json.put("name", nameGen);
        json.put("family", "Тестовый");
        json.put("ot", "СМП");
        json.put("birthdate", "2002-01-10");
        json.put("seriespol", "");
        json.put("numberpol", "5098799789000154");
        json.put("gender", "2");
        json.put("address", "это не формализованный адрес");
        json.put("complaint", "тестовый вызов");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+79606223551");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "12");
        json.put("floor", "5");

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    @Step("открыл страницу создания вызова")
    public void createCallBtn() {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);
        waitVisibility(noviyVizov);
        saveBtns.click();
    }
}