package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class AbstractPage {
    public WebDriver driver;

    public AbstractPage() {
        this.driver = getWebDriver();
    }

    public void ShouldBeVisible(String text) {
        $(By.xpath("//*[contains(text(),'" + text + "')]")).shouldBe(Condition.visible);

    }
}