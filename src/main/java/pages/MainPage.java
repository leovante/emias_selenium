package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Wait waitAll;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
    WebElement callDoctorBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[2]/a/span")
    WebElement timeTableBtn;

    @FindBy(xpath = "//div[@id='top']/a[2]/span")
    WebElement homePageBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div/a/span")
    WebElement admissionScheduleBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[5]/a/span")
    WebElement transferRecordsBtn;

    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
        waitAll = new Wait(webDriver);

    }

    public void callDoctorBtn() throws InterruptedException {
        waitWhileClickable(callDoctorBtn);
        callDoctorBtn.click();
    }

    public void manageSheduleBtn(){
        waitAll.waitAll();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
    }

    public void admissionScheduleBtn(){
        waitAll.waitAll();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
    }

    public void transferRecordsBtn(){
        waitAll.waitAll();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        waitAll.waitAll();
    }

    public void logoHomeBtn(){
        waitAll.waitAll();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
