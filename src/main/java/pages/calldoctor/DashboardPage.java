package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DashboardPage extends BasePage implements Profile1 {

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

    @Step
    public void exitToMis() {
        click(exitToMis);
        click(exitBtn);
    }

    @Step
    public void searchFilterFio(String doctorName) throws InterruptedException {
        clickJS(fioFilter);
        sendKeys(fioFilter, doctorName);
        Thread.sleep(4000);
    }

    @Step
    public void verifyNewCallProgressFrame(String nameGen) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='newCallAllCount']/div[contains(text(),'1')]")));

        click(newCallProgressFrame);
        click(adressPro1_3);

        containsIsDisplayed(famPro1);
        containsIsDisplayed(otchestvoPro1);
        containsIsDisplayed(nameGen);
        //потом ещё добавить проверку номера телефона
    }

    @Step
    public void clickDoctorName(String doctorFam) {
        click(doctorFam);
        //раскрыть только новые
        //activeCallOverdueFrame
    }
}