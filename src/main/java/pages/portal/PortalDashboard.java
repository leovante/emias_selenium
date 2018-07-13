package pages.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.User;

import static org.testng.Assert.assertTrue;

public class PortalDashboard extends AbstractPage {

    @FindBy(xpath = "//a[@class='b-btn b-btn--red b-registry-form__btn c-registry-form__btn']")
    @CacheLookup
    WebElement pereytiVElectrRegistr;

    @FindBy(xpath = "//input[@name='nPol']")
    @CacheLookup
    WebElement nPolField;

    @FindBy(xpath = "//input[@name='birthday']")
    @CacheLookup
    WebElement birthdayField;

    @FindBy(xpath = "//div/div/div[2]/h2[contains(.,'Вы успешно вызвали врача на адрес:')]")
    @CacheLookup
    WebElement uspeshnoVizvaliVracha;

    @FindBy(id = "call_address")
    @CacheLookup
    WebElement call_address;

    @FindBy(id = "call_entrance")
    @CacheLookup
    WebElement call_entrance;

    @FindBy(id = "call_stage")
    @CacheLookup
    WebElement call_stage;

    @FindBy(id = "call_doorphone")
    @CacheLookup
    WebElement call_doorphone;

    @FindBy(id = "call_phone")
    @CacheLookup
    WebElement call_phone;

    @FindBy(id = "call_description")
    @CacheLookup
    WebElement call_description;

    public PortalDashboard(WebDriver driver) {
        super(driver);
    }

    @Step("создаю вызов через портал")
    public void createCall(User user) {
        //сделать цикл, который делал бы проверку всего что есть в классе профиля
        //сделать проверку
/**
 * public class Item
 * {
 *   ...
 *   public virtual void CalculateCost() { ... }
 * }
 *
 * public class Boots : Item
 * {
 *   public override void CalculateCost() { ... }
 * }
 */
//        sendKeys(nPolField, user.getProfile());
//        sendKeys(nPolField, nomPol);
//        sendKeys(birthdayField, birthDay);
        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"))).click();

//        sendKeys(call_address, adress);
//        sendKeys(call_entrance, pod);
//        sendKeys(call_stage, etazh);
//        sendKeys(call_doorphone, domofon);
//        sendKeys(call_phone, telephone);
//        sendKeys(call_description, zhaloba);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(uspeshnoVizvaliVracha));
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
    }

    @Step("создаю рандомный вызов через портал")
    public PortalDashboard createRandomCall(User user) {
        sendKeys(nPolField, user.getNumPol());
        sendKeys(birthdayField, user.getBirthDay());


        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"))).click();
//        sendKeys(call_address, adress);
//        sendKeys(call_entrance, pod);
//        sendKeys(call_stage, etazh);
//        sendKeys(call_doorphone, domofon);
//        sendKeys(call_phone, telephone);
//        sendKeys(call_description, zhaloba);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(uspeshnoVizvaliVracha));
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
        return this;
    }
}