package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;

    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
        website = new Pages(webDriver);
    }

    public void clickManageShedule(){
        website.mainPage().clickManageShedule();
    }
}
