package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utilities.Waiter;

public class HomePage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Ведение расписания')]")
    WebElement timeTableBtn;

    @FindBy(xpath = "//div[@id='top']/a[2]/span")
    WebElement homePageBtn;

    @FindBy(xpath = "//span[contains(text(),'Расписание приёма')]")
    WebElement admissionScheduleBtn;

    @FindBy(xpath = "//span[contains(text(),'Перенос записей')]")
    WebElement transferRecordsBtn;

    @FindBy(xpath = "//span[contains(text(),'Диспетчер')]")
    WebElement callDoctorBtn;

//    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
//    WebElement callDoctorBtn2;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void manageSheduleBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
        Waiter.waitAllEmias();
    }

    public void admissionScheduleBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
        Waiter.waitAllEmias();
    }

    public void transferRecordsBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        Waiter.waitAllEmias();
    }

    public void logoHomeBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
        Waiter.waitAllEmias();
    }

    public void callDoctorBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(homePageBtn);
        callDoctorBtn.click();
        Waiter.waitAllEmias();
    }

//    public void callDoctorBtn2() throws InterruptedException {
//        waitWhileClickable(callDoctorBtn2);
//        callDoctorBtn2.click();
//    }


    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}