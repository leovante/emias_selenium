package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "Login")
    WebElement loginInputField;

    @FindBy(id = "Password")
    WebElement passInputField;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
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