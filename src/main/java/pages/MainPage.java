package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends  WaitLoader {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
    WebElement callDoctorBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[2]/a/span")
    WebElement timeTableBtn;

    @FindBy(xpath = "//div[@id='top']/a[2]/span")
    WebElement homePageBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div/a/span")
    WebElement admissionScheduleBtn;

    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorButton() throws InterruptedException {
        waitAll();
        waitWhileClickable(callDoctorBtn);
        callDoctorBtn.click();
    }

    public void clickManageShedule(){
        waitAll();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
    }

    public void clickAdmissionSchedule(){
        waitAll();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
    }

    public void clickLogoHome(){
        waitAll();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
    }
}
