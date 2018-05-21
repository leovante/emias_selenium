package pages.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.utilities.Waiter;

import java.util.List;

public class TransferRecords extends BasePage {

    @FindBy(xpath = "//button[@id='btn_transfer']/span[2]")
    WebElement btn_transfer;

    @FindBy(xpath = "//button[@id='btn_transfer_schedule']/span")
    WebElement btn_transfer_schedule;

    @FindBy(xpath = "//table[@id='collision_grid']/tbody/tr[2]")
    WebElement doctors_recive_record;

    @FindBy(xpath = "//table[@id='collision_item_grid']/tbody/tr[2]")
    WebElement doctors_record;

    @FindBy(xpath = "//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']")
    WebElement recordElement;

    public TransferRecords(WebDriver driver) {
        super(driver);
    }

    public void trancferRecord(String name) throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String secondDoctor = name;
        Waiter.waitAllEmias();
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

        Waiter.waitBlockOverlay();
        WebElement secondFrame = driver
                .findElement(By.xpath("//table[@id='resolve_collision_grid']/tbody"))
                .findElement(By.xpath(".//td[@title='23:44']"));
        //вот здесь вместо tr[2] искать текущую дату
        wait.until(ExpectedConditions.elementToBeClickable(secondFrame));
        secondFrame.click();
        driver.findElement(By.xpath("//button[@id='btn_transfer_collision']/span")).click();//перенести
        Waiter.waitBlockOverlay();

        keyboard.pressKey(Keys.ENTER);
        Waiter.waitAllEmias();
    }

    public void selectDoctorFromTranWindow(String doctorInlet) throws InterruptedException {
        Waiter.waitBlockOverlay();
        List<WebElement> doctors = driver.findElement(By
                .xpath("//div[@id='gview_resolve_collision_docprvdgrid1']/div[3]/div/table/tbody"))
                .findElements(By.xpath("tr/td[2]/div"));
        for (WebElement doctor : doctors) {
            WebElement doctorLink = doctor.findElement(By.tagName("span"));
            String doctorLinkText = doctorLink.getText();
            if (doctorLinkText.equals(doctorInlet)) {
                doctor.click();
                break;
            }
        }
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void verifyTransferShedule() throws InterruptedException {
        Waiter.waitAllEmias();
        wait.until(ExpectedConditions.visibilityOfAllElements(recordElement));
    }
}


