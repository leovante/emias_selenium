package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utilities.Waiter;

public class HomePage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'ЕМИАС Московской области')]")
    WebElement homePageBtn;

    @FindBy(xpath = "//span[contains(text(),'Ведение расписания')]")
    WebElement timeTableBtn;

    @FindBy(xpath = "//span[contains(text(),'Расписание приёма')]")
    WebElement admissionScheduleBtn;

    @FindBy(xpath = "//span[contains(text(),'Перенос записей')]")
    WebElement transferRecordsBtn;

    @FindBy(xpath = "//span[contains(text(),'Диспетчер')]")
    WebElement callDoctorBtn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Step("Заходим в ведение расписания")
    public void manageSheduleBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(timeTableBtn);
        timeTableBtn.click();
        Waiter.waitAllEmias();
    }

    @Step("Заходим в расписание приема")
    public void admissionScheduleBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
        Waiter.waitAllEmias();
    }

    @Step("Заходим в перенос записей")
    public void transferRecordsBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        Waiter.waitAllEmias();
    }

    @Step("Нажимаю на логотип")
    public void logoHomeBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(homePageBtn);
        homePageBtn.click();
        Waiter.waitAllEmias();
    }

    @Step
    public void callDoctorBtn(){
        Waiter.waitAllEmias();
        waitWhileClickable(homePageBtn);
        callDoctorBtn.click();
        Waiter.waitAllEmias();
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}