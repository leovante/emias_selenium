package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;
    int urlNum = 1;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
        website = new Pages(webDriver);
    }

    public void loginEmias() throws InterruptedException {
        selectUrl(urlNum);
        website.loginPage().clickLoginButton();
    }

    public String selectUrl(int stendNum) {
        switch (stendNum) {
            case 1:
                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
                website.loginPage().enterLoginText("seleniumAdmin");
                website.loginPage().enterPasswordText("1212");
                break;
            case 2:
                webDriver.get("http://mis.softrust.ru/whc/Home");
                website.loginPage().enterLoginText("admin");
                website.loginPage().enterPasswordText("11");
                break;
            case 3:
                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
                website.loginPage().enterLoginText("seleniumDoctor");
                website.loginPage().enterPasswordText("1");
                break;
        }
        return null;
    }

    public int getCurrentUrlNum() {
        return this.urlNum;
    }
}
