package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utilities.JSWaiter;
import pages.utilities.NameOfElement;

import java.lang.reflect.Field;
import java.util.List;

import static org.testng.Assert.assertTrue;

abstract public class AbstractPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void hoverByAction(WebElement element) {
        //Asynchronous waitClickableJS
        JSWaiter.waitJQueryAngular();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void click(WebElement element) {
        waitComplete();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(String name) {
        waitComplete();
        JSWaiter.waitJQueryAngular();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[contains(text(),'" + name + "')]")));
        driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).click();
    }

    public void clickJS(WebElement element) {
        waitComplete();
        JSWaiter.waitJQueryAngular();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickJSext(WebElement element) {
        JSWaiter.waitJQueryAngular();
        waitComplete();
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
        waitComplete();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + name + "')]")));
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));//не убирай спан
        assertTrue(element.isDisplayed());
    }

    public void isDisplayedJS(String name) {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]"));//не убирай спан
        assertTrue(element.isDisplayed());
    }

    public void isDisplayed(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]"));
        assertTrue(element.isDisplayed());
    }

    public void sendKeys(WebElement element, String text) {
        waitComplete();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysJS(WebElement element, String text) {
        waitComplete();
        JSWaiter.waitJQueryAngular();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void waitClickableJS(WebElement webElement) {
        waitComplete();
        JSWaiter.waitJQueryAngular();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitClickable(WebElement webElement) {
        waitComplete();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitComplete() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public SelenideElement get(String cucumberElementName) {
        Class<?> clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NameOfElement.class)) {
                NameOfElement nameOfElementAnnotation = field.getAnnotation(NameOfElement.class);
                if (nameOfElementAnnotation.value().equals(cucumberElementName)) {
                    try {
                        return (SelenideElement) field.get(this);

                    } catch (IllegalAccessException e) {
                        System.out.println("ERROR: element with name " + cucumberElementName + " at page " + this.getClass().getName() + " is not public");
                    }
                }
            }
        }
        Selenide.screenshot("No_element");
        throw new IllegalArgumentException("ERROR: there is no such element with name " + cucumberElementName + " at page " + this.getClass().getName());
    }

    public void waitAllEmias() {
        boolean WidgetAssert = !driver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        boolean BlockAssert = !driver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        boolean loaderLeftSpacer = !driver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderLeftSpacer) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("loaderleftspacer"))));
        }
    }

    public void waitBlockOverlay() {
        boolean BlockAssert = !driver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
    }

    public void waitWidgetOverlay() {
        boolean WidgetAssert = !driver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
    }

    public void waitSpacer() {
        boolean loaderLeftSpacer = !driver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderLeftSpacer) {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("loaderleftspacer"))));
        }
    }

    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}