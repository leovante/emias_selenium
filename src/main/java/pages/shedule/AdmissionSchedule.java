package pages.shedule;


import org.antlr.stringtemplate.language.Expr;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.WaitAll;

public class AdmissionSchedule {
    private WebDriver webDriver;
    private WebDriverWait wait;
    WaitAll waitAll;

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
        waitAll = new WaitAll(webDriver);
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

    public void createRecord() throws InterruptedException {
        waitAll.waitBlock();
        wait.until(ExpectedConditions.elementToBeClickable(RecordsArea));
        waitAll.waitBlock();
        WebElement task = RecordsArea.findElement(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
        wait.until(ExpectedConditions.elementToBeClickable(task));
        task.click();

        wait.until(ExpectedConditions.elementToBeClickable(hernya));
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ENTER).perform();
        hernya.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectPatientButton));
        selectPatientButton.click();//выбрать
        wait.until(ExpectedConditions.elementToBeClickable(pervichniy));
        pervichniy.click();//первичный
    }

    public void verifyCreatedRecord() {
        waitAll.waitBlock();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#DB3F23;border-color:#DB3F23;color:#FFFFFF']"));
        //тут нужно сделать ассертТруе
    }
}
