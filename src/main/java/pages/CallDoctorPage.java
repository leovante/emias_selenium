package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallDoctorPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "tr[role='row']")
    WebElement callDoctorPatientPotition;

    public void CallDoctorPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("waitForSearchResults")));
    }
}
