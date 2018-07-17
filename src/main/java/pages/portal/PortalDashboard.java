package pages.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.User6;

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
    WebElement address;

    @FindBy(id = "call_entrance")
    @CacheLookup
    WebElement entrance;

    @FindBy(id = "call_stage")
    @CacheLookup
    WebElement stage;

    @FindBy(id = "call_doorphone")
    @CacheLookup
    WebElement doorphone;

    @FindBy(id = "call_phone")
    @CacheLookup
    WebElement phone;

    @FindBy(id = "call_description")
    @CacheLookup
    WebElement description;

    public PortalDashboard(/*WebDriver driver*/) {
//        super(driver);
    }

    public void createCall(User6 user) {
        this.createCallHelper(user);
        //сделать цикл, который делал бы проверку всего что есть в классе профиля
        //сделать проверку
//  public class Item
//  {
//    ...
//    public virtual void CalculateCost() { ... }
//  }
//
//  public class Boots : Item
//  {
//    public override void CalculateCost() { ... }
//  }
    }

    @Step("создаю вызов через портал")
    public void createCallHelper(User6 user) {
        sendKeys(nPolField, user.getData("nPol"));
        sendKeys(birthdayField, user.getData("birthDay"));

        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"))).click();

        sendKeys(address, user.getData("adress"));
        sendKeys(entrance, user.getData("pd"));
        sendKeys(stage, user.getData("etazh"));
        sendKeys(doorphone, user.getData("dfon"));
        sendKeys(phone, user.getData("telephone"));
        sendKeys(description, user.getData("zhaloba"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(uspeshnoVizvaliVracha));
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
    }

    @Step("создаю рандомный вызов через портал")
    public PortalDashboard createRandomCall() {
//        sendKeys(nPolField, user.getNumPol());
//        sendKeys(birthdayField, user.getBirthDay());


        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"))).click();
//        sendKeys(address, adress);
//        sendKeys(entrance, pod);
//        sendKeys(stage, etazh);
//        sendKeys(doorphone, domofon);
//        sendKeys(phone, telephone);
//        sendKeys(description, zhaloba);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(uspeshnoVizvaliVracha));
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
        return this;
    }
}