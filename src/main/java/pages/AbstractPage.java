package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class AbstractPage {
    public WebDriver driver = getWebDriver();
    public JavascriptExecutor jse = (JavascriptExecutor) driver;

    public AbstractPage() {

    }
}