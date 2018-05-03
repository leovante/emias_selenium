package pages.shedule;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdmissionSchedule {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Actions action = new Actions(webDriver);

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div/div")
    WebElement RecordsArea;

    @FindBy(xpath = "//button[@id='selectPatientButton']/span")
    WebElement selectPatientButton;

    @FindBy(xpath = "//button[@id='{2}']/span")
    WebElement pervichniy;

    @FindBy(xpath = "//table[@id='mkabgrid1']/tbody/tr[2]/td[3]")
    WebElement hernya;

    @FindBy(xpath = "//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']")
    WebElement recordElement;


    public AdmissionSchedule(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

//    выбрать первого врача
//    найти новую запись - прием по очереди и создать запись пациента

/*
    public void selectDoctor(String doctorInlet) {
        wait.until(ExpectedConditions
                .elementToBeClickable(webDriver.findElement(By.xpath("/*/
/*[contains(text(),'" + doctorInlet + "')]"))));
        webDriver.findElement(By.xpath("/*/
/*[contains(text(),'" + doctorInlet + "')]")).click();
    }
*/

    public void createRecord() {
        waitAll();
        WebElement task = RecordsArea.findElement((By) recordElement);
        task.click();

        action.sendKeys(Keys.ENTER).perform();
        hernya.click();
        selectPatientButton.click();//выбрать
        pervichniy.click();//первичный
    }

    public void verifyCreatedRecord() {
        waitAll();
        webDriver.findElement((By) RecordsArea)//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']"));
        //тут нужно сделать ассертТруе
    }
    public boolean waitAll() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        boolean WidgetAssert = !webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        boolean loaderLeftSpacer = !webDriver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderLeftSpacer) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        return BlockAssert;
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
