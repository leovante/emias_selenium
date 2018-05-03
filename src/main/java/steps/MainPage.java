/*
этот класс я создал что бы в кейсах писать первой ссылкой pages, вместо website
 */

package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.shedule.AdmissionSchedule;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
        website = new Pages(webDriver);
    }

    public void clickManageShedule() {
        website.mainPage().clickManageShedule();
    }

    public void clickLogoHome() {
        website.mainPage().clickLogoHome();
    }

    public void admissionSchedule() {
        website.mainPage().admissionSchedule();
    }
}
