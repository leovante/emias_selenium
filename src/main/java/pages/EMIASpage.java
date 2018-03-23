package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EMIASpage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "a[href='/whc/CallDoctorHouse']")
    WebElement callDoctorButton;


    public void EMIASpage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorButton() {
        callDoctorButton.click();
    }
}
