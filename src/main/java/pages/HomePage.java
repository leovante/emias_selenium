package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends AbstractPage {

    SelenideElement homePageBtn = $(By.xpath("//span[contains(.,'ЕМИАС Московской области')]"));
    SelenideElement timeTableBtn = $(By.xpath("//span[contains(.,'Ведение расписания')]"));
    SelenideElement admissionScheduleBtn = $(By.xpath("//span[contains(.,'Расписание приёма')]"));
    SelenideElement transferRecordsBtn = $(By.xpath("//span[contains(.,'Перенос записей')]"));
    SelenideElement callDoctorBtn = $(By.xpath("//span[contains(.,'Диспетчер')]"));

    public HomePage() {
    }

    @Step("Захожу в ведение расписания")
    public void manageSheduleBtn(){
//        waitAllEmias();
//        waitClickable(timeTableBtn);
        timeTableBtn.click();
//        waitAllEmias();
    }

    @Step("Захожу в расписание приема")
    public HomePage admissionScheduleBtn() {
//        waitAllEmias();
//        waitClickable(admissionScheduleBtn);
        admissionScheduleBtn.click();
//        waitAllEmias();
        return this;
    }

    @Step("Захожу в перенос записей")
    public HomePage transferRecordsBtn() {
//        waitAllEmias();
//        waitClickable(transferRecordsBtn);
        transferRecordsBtn.click();
//        waitAllEmias();
        return this;
    }

    @Step("Нажимаю на логотип")
    public HomePage logoHomeBtn() {
//        waitAllEmias();
//        waitClickable(homePageBtn);
        homePageBtn.click();
//        waitAllEmias();
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