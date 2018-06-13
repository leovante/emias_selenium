package pages.calldoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//mat-icon[contains(text(),'more_vert')]")
    WebElement exitToMis;

    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    WebElement exitBtn;

    @FindBy(xpath = "//*[@placeholder='ФИО']")
    WebElement fioFilter;

    @FindBy(id = "newCallOverdueFrame")
    WebElement newCallOverdueFrame;

    @FindBy(id = "newCallProgressFrame")
    WebElement newCallProgressFrame;

    @FindBy(id = "newCallAllCount")
    WebElement newCallAllCount;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void exitToMis() {
        click(exitToMis);
        click(exitBtn);
    }

    public void searchFilterFio(String doctorName) {
        clickJS(fioFilter);
        fioFilter.sendKeys(doctorName);

        WebElement oneCount = newCallAllCount.findElement(By.xpath("//div[contains(text(),'1')]"));
        clickJS(oneCount);

        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

    }

    public void verifyNewCallProgressFrame(String nameGen) throws InterruptedException {
        click(newCallProgressFrame);
        containsIsDisplayed(nameGen);

        //раскрыть только новые
        //activeCallOverdueFrame
    }

    public void clickDoctorName(String doctorFam) {
        click(doctorFam);
        //раскрыть только новые
        //activeCallOverdueFrame
    }
}
