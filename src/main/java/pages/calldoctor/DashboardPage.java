package pages.calldoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//mat-icon[contains(text(),'more_vert')]")
    WebElement exitToMis;

    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    WebElement exitBtn;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void exitToMis() {
        click(exitToMis);
        click(exitBtn);
    }
}
