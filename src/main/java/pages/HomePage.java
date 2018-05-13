package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[2]/a/span")
    WebElement timeTableBtn;

    @FindBy(xpath = "//div[@id='top']/a[2]/span")
    WebElement homePageBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div/a/span")
    WebElement admissionScheduleBtn;

//    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[5]/a/span")
//    WebElement transferRecordsBtn;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[5]/a/span")
    WebElement transferRecordsBtn;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div[2]/a/span")
    WebElement callDoctorBtn;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
    WebElement callDoctorBtn2;

    public HomePage(WebDriver driver){
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);

    }

    public void manageSheduleBtn(){
        website.waiter().waitAllEmias();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
        website.waiter().waitAllEmias();
    }

    public void admissionScheduleBtn(){
        website.waiter().waitAllEmias();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
        website.waiter().waitAllEmias();
    }

    public void transferRecordsBtn(){
        website.waiter().waitAllEmias();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        website.waiter().waitAllEmias();
    }

    public void logoHomeBtn(){
        website.waiter().waitAllEmias();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
        website.waiter().waitAllEmias();
    }

    public void callDoctorBtn(){
        website.waiter().waitAllEmias();
        waitWhileClickable(homePageBtn);
        callDoctorBtn.click();
        website.waiter().waitAllEmias();
    }

    public void callDoctorBtn2() throws InterruptedException {
        waitWhileClickable(callDoctorBtn2);
        callDoctorBtn2.click();
    }


    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
