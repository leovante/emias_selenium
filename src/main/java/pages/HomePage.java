package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

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

    public HomePage(/*WebDriver driver*/) {
        //super(driver);
    }

    @Step("Захожу в ведение расписания")
    public void manageSheduleBtn(){
        waitAllEmias();
        waitClickable(timeTableBtn);
        timeTableBtn.click();
        waitAllEmias();
    }

    @Step("Захожу в расписание приема")
    public HomePage admissionScheduleBtn() {
        waitAllEmias();
        waitClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
        waitAllEmias();
        return this;
    }

    @Step("Захожу в перенос записей")
    public HomePage transferRecordsBtn() {
        waitAllEmias();
        waitClickable(transferRecordsBtn);
        transferRecordsBtn.click();
        waitAllEmias();
        return this;
    }

    @Step("Нажимаю на логотип")
    public HomePage logoHomeBtn() {
        waitAllEmias();
        waitClickable(homePageBtn);
        homePageBtn.click();
        waitAllEmias();
        return this;
    }

    @Step("Захожу в Диспетчер")
    public void callDoctorBtn(){
        $(By.xpath("//span[contains(.,'Диспетчер')]")).click();
//        waitAllEmias();
//        waitClickable(callDoctorBtn);
//        callDoctorBtn.click();
//        waitAllEmias();
    }
}