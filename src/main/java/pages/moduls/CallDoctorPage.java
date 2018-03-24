package pages.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CallDoctorPage {
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(id = "searchByFilter")
    WebElement callDoctorSearchBtn;

//    @FindBy(css = "tr[role='row']")
//    WebElement callDoctorPatientPotition;

    public CallDoctorPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorSearchBtn(){
        PageFactory.initElements(webDriver, this);
        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void waitForSearchResults() {
        PageFactory.initElements(webDriver, this);
        System.out.println("табличка появилась");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tr")));

//        List<WebElement> books = webDriver.findElement(By.className("ui-jqgrid-btable"))
//                .findElements(By.tagName("tr"));
        /*for (WebElement book : books) {
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getAttribute("title").contains(bookTitle)) {
                bookLink.click();
                break;
            }
        }*/
    }
}