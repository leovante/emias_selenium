package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utilities.JSWaiter;

import java.util.List;

import static org.testng.Assert.assertTrue;


abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void hoverByAction(WebElement element) {
        //Asynchronous waitClickable
        JSWaiter.waitJQueryAngular();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

//    public void click(By by) {
//        JSWaiter.waitJQueryAngular();
//        waitClickable.until(ExpectedConditions.elementToBeClickable(by)).click();
//    }

    public void click(WebElement element) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

//        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(String name) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[contains(text(),'" + name + "')]")));
        driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).click();
    }

    public void clickJS(WebElement element) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickJSext(WebElement element) {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    //Close popup if exists
    public void handlePopup(By by) {
        JSWaiter.waitJQueryAngular();
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            JSWaiter.sleep(200);
        }
    }

    public void isDisplayedOnCardPage(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + name + "')]")));
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));//не убирай спан
        assertTrue(element.isDisplayed());
    }

    public void isDisplayed(String name) {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]"));//не убирай спан
        assertTrue(element.isDisplayed());
    }

    public void sendKeys(WebElement element, String text) {
        JSWaiter.waitJQueryAngular();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void waitClickable(WebElement webElement) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
//        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}