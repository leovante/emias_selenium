package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;

public class ManageShedule{
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    public ManageShedule(WebDriver driver){
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createShedule() throws InterruptedException, ClassNotFoundException {
        waitAll();
        String docFullName = website.manageShedule().getUnicalDoctor(null);
        String secondName = website.manageShedule().getSecondName(docFullName);
        sql.deleteShedule(secondName);
        website.manageShedule().selectDoctor(docFullName);
        website.manageShedule().createShedule();
    }

    public void verifyCreatedShedule()  throws InterruptedException{
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//*[contains(text(),'07:00 ')]"));
    }

    public void setNotReciveDays(){
        website.manageShedule().setNotReceiveDays();
    }

    public void verifyNotReciveDays(){
        website.manageShedule().checkNotReceiveDays();
    }

    public void copyShedule() throws InterruptedException {
        String docName = website.manageShedule().getUnicalDoctor(null);
        website.manageShedule().selectDoctor(docName);
        website.manageShedule().createShedule();
        String docNameTwo = website.manageShedule().getUnicalDoctor(docName);
        website.manageShedule().selectDoctor(docNameTwo);
        website.manageShedule().copyShedule(docName);
        website.manageShedule().selectDoctor(docName);
        verifyCreatedShedule();
    }

    public void deleteShedule() throws InterruptedException {
        website.manageShedule().deleteShedule();
    }

    public void verifyDeletedShedule(){
        website.manageShedule().checkDeletedShedle();
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
