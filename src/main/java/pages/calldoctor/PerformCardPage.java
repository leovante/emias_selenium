package pages.calldoctor;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;
import pages.utilities.JSWaiter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class PerformCardPage extends AbstractPage implements Profile {

    SelenideElement cancelAdress = $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
    SelenideElement cancelBirthDate = $(By.xpath("//button[@aria-label='Clear']/span/mat-icon"));
    SelenideElement list_first_container = $(By.xpath("//div[@class='autocomplete-list-container']/ul/li"));
    SelenideElement placeholder_adress = $(By.xpath("//input[@placeholder='Адрес']"));
    SelenideElement dom = $(By.xpath("//input[@placeholder='Дом']"));
    SelenideElement telephoneNumber = $(By.id("phone"));
    SelenideElement chkBoxTelephone = $(By.xpath("//label[@class='mat-checkbox-layout']/div"));
    SelenideElement hz = $(By.xpath("//button[2]/span/mat-icon"));
    SelenideElement vozr = $(By.xpath("//input[@placeholder='Возр. категория']"));
    SelenideElement hz2 = $(By.xpath("//span[contains(.,'Взрослый')]"));
    SelenideElement korpus = $(By.xpath("//input[@placeholder='Корпус']"));
    SelenideElement stroenie = $(By.xpath("//input[@placeholder='Строение']"));
    SelenideElement kvartira = $(By.xpath("//input[@placeholder='Квартира']"));
    SelenideElement pd = $(By.xpath("//input[@placeholder='П-д']"));
    SelenideElement dfon = $(By.xpath("//input[@placeholder='Д-фон']"));
    SelenideElement etazh = $(By.xpath("//input[@placeholder='Этаж']"));
    SelenideElement zhaloba = $(By.xpath("//input[@aria-label='Добавить жалобу']"));
    SelenideElement seriyaPol = $(By.xpath("//input[@placeholder='Серия']"));
    SelenideElement nomerPol = $(By.xpath("//input[@placeholder='Номер полиса']"));
    SelenideElement fam = $(By.xpath("//input[@placeholder='Фамилия']"));
    SelenideElement name = $(By.xpath("//input[@placeholder='Имя']"));
    SelenideElement otchestvo = $(By.xpath("//input[@placeholder='Отчество']"));
    SelenideElement tipVisivaushego = $(By.xpath("//input[@placeholder='Тип вызывающего']"));
    SelenideElement predstav = $(By.xpath("//span[contains(.,'Представитель')]"));
    SelenideElement saveBtns = $(By.xpath("//span[contains(text(),'Сохранить')]"));
    SelenideElement callFamily = $(By.id("callFamily"));
    SelenideElement callName = $(By.id("callName"));
    SelenideElement callPatronymic = $(By.id("callPatronymic"));
    SelenideElement birthDateTemp = $(By.id("birthDateTemp"));
    SelenideElement source0 = $(By.id("source0"));
    SelenideElement sourceSmp = $(By.id("sourceSmp"));
    SelenideElement phone = $(By.id("phone"));
    SelenideElement age = $(By.id("age"));
    SelenideElement naidena_mkab = $(By.xpath("//div[contains(.,'Найдена МКАБ пациента Петров')]"));
    SelenideElement redactirovanieVizova = $(By.xpath("//div[contains(text(),'Редактирование вызова')]"));

    public PerformCardPage() {
    }

    @Step("редактирую вызов без привязывания МКАБ")
    public PerformCardPage editCallProfile5(String nameGen) {
        Actions action = new Actions(driver);
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        waitVisibility(redactirovanieVizova);

/*адрес*/
        cancelAdress.click();
        placeholder_adress.click();

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
    public PerformCardPage verifyCallProfile1(String nameGen) throws IOException {

        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\Profile1.json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        for (Object entry : proData.entrySet()) {

        }

        assertTrue(getWebElementValue(phone).equals(telephonePro1));
        assertTrue(getWebElementValue(seriyaPol).equals(seriyaPolPro1));
        assertTrue(getWebElementValue(nomerPol).equals(nomerPolPro1));
        assertTrue(getWebElementValue(fam).equals(famPro1));
        assertTrue(getWebElementValue(name).equals(nameGen));
        assertTrue(getWebElementValue(otchestvo).equals(otchestvoPro1));
        assertTrue(getWebElementValue(birthDateTemp).equals(birthDayPro1));
        assertTrue(getWebElementValue(age).equals(goda24Pro1));
        assertTrue(getWebElementValue(vozr).equals(vozrastKatPro1));
        assertTrue(getWebElementValue(placeholder_adress).equals(adressPro1editPage));
        assertTrue(getWebElementValue(dom).equals(domPro1));
        assertTrue(getWebElementValue(korpus).equals(korpusPro1));
        assertTrue(getWebElementValue(stroenie).equals(stroeniePro1));
        assertTrue(getWebElementValue(kvartira).equals(kvartiraPro1));
        assertTrue(getWebElementValue(pd).equals(pdPro1));
        assertTrue(getWebElementValue(dfon).equals(dfonPro1));
        assertTrue(getWebElementValue(etazh).equals(etazhPro1));
        isDisplayed(zhalobaPro1);
        assertTrue(getWebElementValue(tipVisivaushego).equals("Представитель"));
        assertTrue(getWebElementValue(telephoneNumber).equals(telephonePro1));
        //фио представителя нехватает

        isDisplayed("Источник");
        isDisplayed("Вид вызова");
        isDisplayed("КТО ПАЦИЕНТ");
        isDisplayed("АДРЕС");
        isDisplayed("ЖАЛОБЫ");
        isDisplayed("КТО ВЫЗЫВАЕТ");
        isDisplayed("Телефон");

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