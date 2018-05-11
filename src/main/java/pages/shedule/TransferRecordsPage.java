package pages.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wait;

import java.util.List;

public class TransferRecordsPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Wait waitAll;

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

    public TransferRecordsPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void trancRecord(String name) throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        String secondDoctor = name;
        waitAll.waitAll();
        waitWhileClickable(btn_transfer);
        btn_transfer.click();//большая кнопка перенести
        waitWhileClickable(btn_transfer_schedule);
        btn_transfer_schedule.click();//всплывающее окно перенести
        waitWhileClickable(doctors_recive_record);
        doctors_recive_record.click();
        waitWhileClickable(doctors_record);
        doctors_record.click();

        Actions action = new Actions(webDriver).contextClick(doctors_record);
        action.build().perform();//нажал правой кнопкой на вызов пациента
        webDriver.findElement(By.xpath("(//li[@id='SCH_CollisionResolve']/a/span)[2]")).click();
        selectDoctorFromTranWindow(secondDoctor);

        waitAll.waitBlockOverlay();
        webDriver.findElement(By.xpath("//table[@id='resolve_collision_grid']/tbody/tr[3]/td")).click();
        webDriver.findElement(By.xpath("//button[@id='btn_transfer_collision']/span")).click();//перенести
        waitAll.waitBlockOverlay();

        keyboard.pressKey(Keys.ENTER);
        waitAll.waitAll();
    }

    public void selectDoctorFromTranWindow(String doctorInlet) throws InterruptedException {
        waitAll.waitBlockOverlay();
        List<WebElement> doctors = webDriver.findElement(By
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
        waitAll.waitAll();
        wait.until(ExpectedConditions.visibilityOfAllElements(recordElement));
    }
}


