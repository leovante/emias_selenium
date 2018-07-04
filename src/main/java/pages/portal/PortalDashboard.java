package pages.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import static org.testng.Assert.assertTrue;

public class PortalDashboard extends AbstractPage {

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

    @FindBy(xpath = "//div/div/div[2]/h2[contains(.,'Вы успешно вызвали врача на адрес:')]")
    WebElement uspeshnoVizvaliVracha;

    @FindBy(id = "call_address")
    WebElement call_address;

    @FindBy(id = "call_entrance")
    WebElement call_entrance;

    @FindBy(id = "call_stage")
    WebElement call_stage;

    @FindBy(id = "call_doorphone")
    WebElement call_doorphone;

    @FindBy(id = "call_phone")
    WebElement call_phone;

    @FindBy(id = "call_description")
    WebElement call_description;

    public PortalDashboard(WebDriver driver) {
        super(driver);
    }

    @Step("создаю вызов через портал")
    public void createCall(String nomPol,
                           String birthDay,
                           String adress,
                           String pod,
                           String etazh,
                           String domofon,
                           String telephone,
                           String zhaloba) {
        sendKeys(nPolField, nomPol);
        sendKeys(birthdayField, birthDay);
        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"))).click();

        sendKeys(call_address, adress);
        sendKeys(call_entrance, pod);
        sendKeys(call_stage, etazh);
        sendKeys(call_doorphone, domofon);
        sendKeys(call_phone, telephone);
        sendKeys(call_description, zhaloba);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"))).click();
        wait.until(ExpectedConditions.visibilityOf(uspeshnoVizvaliVracha));
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
    }
}
