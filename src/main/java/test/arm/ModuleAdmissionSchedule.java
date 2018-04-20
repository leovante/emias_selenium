package test.arm;


import org.apache.commons.collections.functors.ExceptionPredicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuleAdmissionSchedule {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public ModuleAdmissionSchedule(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

//    выбрать первого врача
//    найти новую запись - прием по очереди и создать запись пациента

    public void selectDoctor(String doctorInlet) {
        wait.until(ExpectedConditions
                .elementToBeClickable(webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorInlet + "')]"))));
        webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")).click();
    }

    public void createTask() {
        Actions action = new Actions(webDriver);
        waitLoaderLeftspacer();
        waitWidgetOverlay();
        waitBlockUI();
        WebElement task = webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
        task.click();

        action.sendKeys(Keys.ENTER).perform();
        webDriver.findElement(By.xpath("//table[@id='mkabgrid1']/tbody/tr[2]/td[3]")).click();
        webDriver.findElement(By.xpath("//button[@id='selectPatientButton']/span")).click();//выбрать
        webDriver.findElement(By.xpath("//button[@id='{2}']/span")).click();//первичный
    }

    public void checkCreateTask(){
        waitWidgetOverlay();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']"));

    }

    public boolean waitBlockUI() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        return BlockAssert;
    }

    public boolean waitWidgetOverlay() {
        boolean WidgetAssert = !webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        return WidgetAssert;
    }

    public boolean waitLoaderLeftspacer() {
        boolean loaderleftspacer = !webDriver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderleftspacer) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        return loaderleftspacer;
    }


}
