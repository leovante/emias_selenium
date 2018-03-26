package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DTemnikov on 23.03.2018.
 */
public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "Login")
    WebElement loginInpuField;

    @FindBy(id = "Password")
    WebElement passwordInpuField;

    @FindBy(id = "loginBtn")
    WebElement loginBtn;


    public LoginPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void enterLoginText(String text){
        loginInpuField.clear();
        loginInpuField.sendKeys(text);
    }

    public void enterPassText(String text){
        passwordInpuField.clear();
        passwordInpuField.sendKeys(text);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }
}
