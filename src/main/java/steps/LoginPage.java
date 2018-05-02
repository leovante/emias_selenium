package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void loginEmias() {
        webDriver.get("http://emias.mosreg.ru/mis/test_emias");
        website.loginPage().enterLoginText("seleniumAdmin");
        website.loginPage().enterPasswordText("1212");
        //seleniumDoctor 1
        //seleniumAdmin 1212
        website.loginPage().clickLoginButton();
    }
}
