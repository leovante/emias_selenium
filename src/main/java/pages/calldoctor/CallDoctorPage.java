package pages.calldoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utilities.JSWaiter;
import pages.Pages;

import java.util.ArrayList;


public class CallDoctorPage {
    private WebDriver webDriver;
    WebDriverWait wait;
    Pages website;
    JSWaiter jsWaiter = new JSWaiter();


    @FindBy(xpath = "//button[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//div[@class='autocomplete-list-container'")
    WebElement containerKladr;

    public CallDoctorPage(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createCall() throws InterruptedException {
        Actions action = new Actions(webDriver);

        //тут нужно что-то что даст понять драйверу что мы в новом окне
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button")));
        webDriver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span/mat-icon")));
        webDriver.findElement(By.xpath("//span/mat-icon")).click();

//        webDriver.findElement(By.id("mat-input-23")).sendKeys("Московская");
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-4")));
//        webDriver.findElement(By.id("ui-id-4")).click();

        webDriver.findElement(By.id("mat-input-23")).sendKeys("Московская");
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("circle")));
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='autocomplete-list-container'")));
//        WebElement mosObl = webDriver
//                .findElement(By.xpath("//div[@class='autocomplete-list-container'"))
//                .findElement(By.xpath("li[@data-value='Московская обл.,'"));


        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li'")));
        action.sendKeys(Keys.ENTER).perform();

        webDriver.findElement(By.id("mat-input-23")).sendKeys("Коломна");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("circle")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@data-value='Московская обл., г. Коломна,'")));
        action.sendKeys(Keys.ENTER).perform();

        webDriver.findElement(By.id("mat-input-23")).sendKeys("Первомайская");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("circle")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@data-value='Московская обл., г. Коломна, ул. Первомайская,'")));
        action.sendKeys(Keys.ENTER).perform();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span/mat-icon")));
        webDriver.findElement(By.xpath("//span/mat-icon")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).clear();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys("Московская");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).clear();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys("Московская обл., коломна");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).clear();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys("Московская обл., г. Коломна, п");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-23")));
        webDriver.findElement(By.id("mat-input-23")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-19")));
        webDriver.findElement(By.id("mat-input-19")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-19")));
        webDriver.findElement(By.id("mat-input-19")).clear();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-input-19")));
        webDriver.findElement(By.id("mat-input-19")).sendKeys("1");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-checkbox[@id='mat-checkbox-1']/label/div")));
        webDriver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']/label/div")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[2]/span/mat-icon")));
        webDriver.findElement(By.xpath("//button[2]/span/mat-icon")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-option[@id='mat-option-8']/span")));
        webDriver.findElement(By.xpath("//mat-option[@id='mat-option-8']/span")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[3]/span/span")));
        webDriver.findElement(By.xpath("//button[3]/span/span")).click();
    }

    public void switchToPage() {
        String mainWindowHandle = webDriver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        System.out.println(webDriver.getTitle());

//        for (String win : tabs) {
//            webDriver.switchTo().window(win);
//            // other operation
//            System.out.println(webDriver.getTitle());
//        }
// back to old window
//        webDriver.switchTo().window(mainWindowHandle);
//        System.out.println(webDriver.getTitle());
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitWhileVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
