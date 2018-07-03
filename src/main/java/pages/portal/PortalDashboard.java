package pages.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.calldoctor.Profiles_interfaces.Profile4;

public class PortalDashboard extends BasePage implements Profile4 {

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

    public PortalDashboard(WebDriver driver) {
        super(driver);
    }

    @Step("создаю вызов через портал")
    public void createCallProfile4() {
        sendKeys(nPolField, nomerPolPro4);
        sendKeys(birthdayField, birthDayPro4);
        click(pereytiVElectrRegistr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Вызвать врача')]"))).click();

        sendKeys(call_address, adressPro4);
        sendKeys(call_phone, telephonePro4);
        sendKeys(call_description, zhalobaPro4);
        click(podtverdVizovVracha);
        waitClickable(closeWindowBtn);
        click(closeWindowBtn);
    }
}
