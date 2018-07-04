package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginInputField;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement passInputField;

    @FindBy(id = "loginBtn")
    @CacheLookup
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String site, String login, String pass) {
        driver.get(site);
        enterLoginText(login);
        enterPasswordText(pass);
        clickLoginButton();
    }

    public void enterLoginText(String text) {
        loginInputField.clear();
        loginInputField.sendKeys(text);
    }

    public void enterPasswordText(String text) {
        passInputField.clear();
        passInputField.sendKeys(text);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}