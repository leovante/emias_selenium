package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Pages;

public class AdmissionSchedule {
    private WebDriver webDriver;
    Pages website;

    public AdmissionSchedule(WebDriver driver){
        webDriver = driver;
        website = new Pages(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void createRecord() throws InterruptedException {
        website.mainPage().logoHomeBtn();
        website.mainPage().admissionScheduleBtn();
        website.admissionSchedule().createRecord();
    }
}
