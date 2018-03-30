package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmiasMainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='Portlet_6']/div[2]/div/a/span")
    WebElement callDoctorButton;

    @FindBy(xpath = "//div[@id='Portlet_2']/div[2]/div[2]/a/span")
    WebElement videnieRaspisaniya;

    @FindBy(id = "loaderleftspacer")
    WebElement spiner;

    public EmiasMainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorButton() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        } else {
        }
        System.out.println("click callDoctorButton");
        WebElement myelement = webDriver.findElement(By.xpath("//div[@id='Portlet_6']/div[2]/div/a/span"));
        JavascriptExecutor jse2 = (JavascriptExecutor)webDriver;
        jse2.executeScript("arguments[0].scrollIntoView()", myelement);
        callDoctorButton.click();
    }

    //БЛОК УПРАВЛЕНИЕ ПОТОКАМИ ПАЦИЕНТОВ
    public void clickScheduleDoctors(){
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        } else {
        }
        System.out.println("click vedenie raspisaniya ");
        videnieRaspisaniya.click();
    }
}
