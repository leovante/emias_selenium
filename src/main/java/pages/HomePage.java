package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

//import io.qameta.allure.Step;

public class HomePage extends AbstractPage {

    SelenideElement homePageBtn = $(By.xpath("//span[contains(.,'ЕМИАС Московской области')]"));
    SelenideElement timeTableBtn = $(By.xpath("//span[contains(.,'Ведение расписания')]"));
    SelenideElement admissionScheduleBtn = $(By.xpath("//span[contains(.,'Расписание приёма')]"));
    SelenideElement transferRecordsBtn = $(By.xpath("//span[contains(.,'Перенос записей')]"));
    SelenideElement callDoctorBtn = $(By.xpath("//span[contains(.,'Диспетчер')]"));
    SelenideElement napravlenieNaIssledovanie = $(By.xpath("//span[contains(.,'Направления на исследование')]"));

    public HomePage() {
    }

    //    @Step("Захожу в ведение расписания")
    public void manageSheduleBtn(){
        timeTableBtn.click();
    }

    //    @Step("Захожу в расписание приема")
    public HomePage admissionScheduleBtn() {
        admissionScheduleBtn.click();
        return this;
    }

    //    @Step("Захожу в перенос записей")
    public HomePage transferRecordsBtn() {
        transferRecordsBtn.click();
        return this;
    }

    //    @Step("Нажимаю на логотип")
    public HomePage logoHomeBtn() {
        homePageBtn.click();
        return this;
    }

    //    @Step("Захожу в направление на исследование")
    public HomePage napravlenieNaIssledovanie() {
        napravlenieNaIssledovanie.click();
        return this;
    }

    //    @Step("Захожу в Диспетчер")
    public void callDoctorBtn(){
        $(By.xpath("//span[contains(.,'Диспетчер')]")).click();
    }

    @Step("выход из МИС")
    public void exitBtn() {
        $(By.xpath("//span[contains(.,'Выход')]")).click();
    }
}