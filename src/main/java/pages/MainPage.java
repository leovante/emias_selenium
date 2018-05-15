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
    Waiter waiterAll;

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
        waiterAll = new Waiter(webDriver);

    }

    public void callDoctorBtn() throws InterruptedException {
        waitWhileClickable(callDoctorBtn);
        callDoctorBtn.click();
    }

    public void manageSheduleBtn(){
        waiterAll.waitAll();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
    }

    public void admissionScheduleBtn(){
        waiterAll.waitAll();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
    }

    public void transferRecordsBtn(){
        waiterAll.waitAll();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        waiterAll.waitAll();
    }

    public void logoHomeBtn(){
        waiterAll.waitAll();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
