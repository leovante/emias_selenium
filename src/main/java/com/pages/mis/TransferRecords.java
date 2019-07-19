package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.pages.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class TransferRecords extends PageBase {

    SelenideElement btn_transfer = $(By.xpath("//button[@id='btn_transfer']/span[2]"));
    SelenideElement btn_transfer_schedule = $(By.xpath("//button[@id='btn_transfer_schedule']/span"));
    SelenideElement doctors_recive_record = $(By.xpath("//table[@id='collision_grid']/tbody/tr[2]"));
    SelenideElement doctors_record = $(By.xpath("//table[@id='collision_item_grid']/tbody/tr[2]"));
    SelenideElement recordElement = $(By.xpath("//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']"));

    public TransferRecords() throws IOException {
    }

    @Step("перенести запись")
    public void trancferRecord(String name) {
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String secondDoctor = name;
//        waitAllEmias();
        waitWhileClickable(btn_transfer);
        btn_transfer.click();//большая кнопка перенести
        waitWhileClickable(btn_transfer_schedule);
        btn_transfer_schedule.click();//всплывающее окно перенести
        waitWhileClickable(doctors_recive_record);
        doctors_recive_record.click();
        waitWhileClickable(doctors_record);
        doctors_record.click();

        Actions action = new Actions(driver).contextClick(doctors_record);
        action.build().perform();//нажал правой кнопкой на вызов пациента
        driver.findElement(By.xpath("(//li[@id='SCH_CollisionResolve']/a/span)[2]")).click();
        selectDoctorFromTranWindow(secondDoctor);

//        waitBlockOverlay();
        $(By.xpath("//table[@id='resolve_collision_grid']/tbody"))
                .$(By.xpath(".//td[@title='23:44']")).click();
        //вот здесь вместо tr[2] искать текущую дату
        $(By.xpath("//button[@id='btn_transfer_collision']/span")).click();//перенести
//        waitBlockOverlay();
        new PressEnter();
//        keyboard.pressKey(Keys.ENTER);
//        waitAllEmias();
    }

    @Step("выбрать врача в окне переноса записей")
    public void selectDoctorFromTranWindow(String doctorInlet) {
//        waitBlockOverlay();
        List<WebElement> doctors = $(By
                .xpath("//div[@id='gview_resolve_collision_docprvdgrid1']/div[3]/div/table/tbody"))
                .findElements(By.xpath("tr/td[2]/div"));
        for (WebElement doctor : doctors) {
//            WebElement doctorLink = doctor.findElement(By.tagName("span"));
//            String doctorLinkText = doctorLink.getText();
            String doctorLinkText = doctor.findElement(By.tagName("span")).getText();
            if (doctorLinkText.equals(doctorInlet)) {
                doctor.click();
                break;
            }
        }
    }

    @Step("проверка переноса записей")
    public void verifyTransferShedule() {
//        waitAllEmias();
        recordElement.shouldBe(Condition.visible);
    }

    public void waitWhileClickable(SelenideElement webElement) {
        webElement.click();
    }
}


