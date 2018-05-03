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
        website = new Pages(webDriver);
    }

    public void loginEmias() throws InterruptedException {
        webDriver.get("http://emias.mosreg.ru/mis/test_emias");
        website.loginPage().enterLoginText("seleniumAdmin");
        website.loginPage().enterPasswordText("1212");
        website.loginPage().clickLoginButton();
    }
    public void loginEmias2() throws InterruptedException {
        webDriver.get("http://mis.softrust.ru/whc/Home");
        website.loginPage().enterLoginText("admin");
        website.loginPage().enterPasswordText("11");
        website.loginPage().clickLoginButton();
    }
    public void loginEmias3() throws InterruptedException {
        webDriver.get("http://emias.mosreg.ru/mis/test_emias");
        website.loginPage().enterLoginText("seleniumDoctor");
        website.loginPage().enterPasswordText("1");
        website.loginPage().clickLoginButton();
    }
}
