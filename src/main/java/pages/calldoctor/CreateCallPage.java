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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.calldoctor.Profiles_interfaces.Profile0;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile4;
import pages.utilities.JSWaiter;

import java.io.InputStream;

import static pages.utilities.Waiter.waitVisibility;

public class CreateCallPage extends BasePage implements Profile1, Profile2, Profile0, Profile4 {

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

//    @FindBy(xpath = "//a/span[2][contains(text(),'в электронную регистратуру')]")
//    WebElement pereytiVElectrRegistr;

    @FindBy(xpath = "//a[@class='b-btn b-btn--red b-registry-form__btn c-registry-form__btn']")
    WebElement pereytiVElectrRegistr;

    @FindBy(xpath = "//a[@class='b-btn b-btn--red b-btn--login-section btn--call-doctor-at-home c-create-home-visit-popup']")
    WebElement callDoctorBtn;

    @FindBy(xpath = "//button/span[contains(text(),'Подтвердить вызов врача')]")
    WebElement podtverdVizovVracha;

    @FindBy(xpath = "//button/span[contains(text(),'Закрыть окно')]")
    WebElement closeWindowBtn;

    @FindBy(xpath = "//input[@name='nPol']")
    WebElement nPolField;

    @FindBy(xpath = "//input[@name='birthday']")
    WebElement birthdayField;

    @FindBy(id = "call_address")
    WebElement call_address;

    @FindBy(id = "call_phone")
    WebElement call_phone;

    @FindBy(id = "call_description")
    WebElement call_description;

    @FindBy(id = "sex1")
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
        sendKeys(dom, domPro1);
//        click(chkBoxTelephone);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();
        action.sendKeys(Keys.SPACE).perform();

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
        click(sex1);

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
    public void createCallProfile2(String nameGen) {
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
        click(sex1);

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

    @Step("создаю вызов через портал")
    public void createCallProfile4() {
//        Actions action = new Actions(driver);
//        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        sendKeys(nPolField, nomerPolPro4);
        sendKeys(birthdayField, birthDayPro4);
        click(pereytiVElectrRegistr);
        waitClickable(callDoctorBtn);
        click(callDoctorBtn);
        sendKeys(call_address, adressPro4);
        sendKeys(call_phone, telephonePro4);
        sendKeys(call_description, zhalobaPro4);
        click(podtverdVizovVracha);
        waitClickable(closeWindowBtn);
        click(closeWindowBtn);
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