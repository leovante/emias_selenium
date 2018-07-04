package pages.callcenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class LoginPageCC extends AbstractPage {
    //protected WebDriver driver;
    //protected WebDriverWait waitClickableJS;

    @FindBy(id = "USER_LOGIN")
    WebElement log;

    @FindBy(id = "USER_PASSWORD")
    WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPageCC(WebDriver driver) {
        super(driver);
    }

    public void login() {
//        driver.get("http://call.emias.mosreg.ru/call2_dev/to_work/");
        driver.get("http://call.emias.mosreg.ru/cc/?login=yes");
        enterLoginText("ccg");
        enterPasswordText("ccg123");
        clickloginButton();
    }

    public void enterLoginText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(log));
        log.clear();
        log.sendKeys(text);
    }

    public void enterPasswordText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.clear();
        pass.sendKeys(text);
    }

    public void clickloginButton() {
        loginButton.click();
    }
}