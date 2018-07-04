package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utilities.Waiter;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//span[contains(.,'ЕМИАС Московской области')]")
    @CacheLookup
    WebElement homePageBtn;

    @FindBy(xpath = "//span[contains(.,'Ведение расписания')]")
    @CacheLookup
    WebElement timeTableBtn;

    @FindBy(xpath = "//span[contains(.,'Расписание приёма')]")
    @CacheLookup
    WebElement admissionScheduleBtn;

    @FindBy(xpath = "//span[contains(.,'Перенос записей')]")
    @CacheLookup
    WebElement transferRecordsBtn;

    @FindBy(xpath = "//span[contains(.,'Диспетчер')]")
    @CacheLookup
    WebElement callDoctorBtn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Step("Захожу в ведение расписания")
    public void manageSheduleBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
        Waiter.waitAllEmias();
    }

    @Step("Захожу в расписание приема")
    public HomePage admissionScheduleBtn() {
        Waiter.waitAllEmias();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
        Waiter.waitAllEmias();
        return this;
    }

    @Step("Захожу в перенос записей")
    public HomePage transferRecordsBtn() {
        Waiter.waitAllEmias();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        Waiter.waitAllEmias();
        return this;
    }

    @Step("Нажимаю на логотип")
    public HomePage logoHomeBtn() {
        Waiter.waitAllEmias();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
        Waiter.waitAllEmias();
        return this;
    }

    @Step("Захожу в Диспетчер")
    public void callDoctorBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(callDoctorBtn);
        callDoctorBtn.click();
//        driver.get("http://109.95.224.42:2165/test/call/call_doctor_ui/call-doctor;709/board?ticket=bcNzk9MEiGwEe1JSseWBq4%2BI41Qaipq6K9uyshR50QBn1zJsAobTnQ3dJZiX8p10vS3nDLSdLkIenWZRdc8rc21FIczd%2FmQe9eHSAgKxVl8C9BS18t3q3DRl%2ByMO%2FUw1EvqtO6f%2B0gWzqXBQYR%2FlPpXi9%2FIUdctXYoHD9gMJnz0q9Qbvi%2FdF1G04Z6UssA0lwE6kMYIZQgZRqHH7x%2Bvq51aCcSgYGFM1ZVh%2FnxXLcghNdJjfMCsr4FbrB7ce0nN0MWs05RY%2BADgWMmIqR5vQOgpyNB5NxOPYXN%2F5Eo1aDITM96sI&ReturnUrl=http%3A%2F%2F192.168.7.139%2Fwhc%2FMain%2FDefault");
        Waiter.waitAllEmias();
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}