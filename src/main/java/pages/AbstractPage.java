package pages;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class AbstractPage {
    public WebDriver driver;

    public AbstractPage() {
        this.driver = getWebDriver();
    }

}