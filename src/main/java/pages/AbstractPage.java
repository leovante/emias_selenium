package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.calldoctor.profiles_interfaces.Pacient;

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

    public String parseTelephone(Pacient pacient) {
        String telephone = pacient.getPhone();
        telephone = telephone.substring(0, 2) + " (" +
                telephone.substring(2, 5) + ") " +
                telephone.substring(5, 8) + "-" +
                telephone.substring(8, 10) + "-" +
                telephone.substring(10, telephone.length());
        return telephone;
    }

}