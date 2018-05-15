package pages.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    static private WebDriver webDriver;
    static private WebDriverWait wait;

    public static void setDriver(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
    }

    public static void waitAllEmias () {
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
    }

    public static void waitBlockOverlay() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
    }

    public static void waitWidgetOvetlay() {
        boolean WidgetAssert = !webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
    }

    public static void waitSpacer() {
        boolean loaderLeftSpacer = !webDriver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderLeftSpacer) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
    }

    public static void waitAllC() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
    }
}