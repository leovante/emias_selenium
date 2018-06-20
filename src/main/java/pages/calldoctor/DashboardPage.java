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

    @FindBy(xpath = "//img[@src='assets/img/call-doctor-logo.svg']")
    WebElement logoType;

    @FindBy(xpath = "//*[@placeholder='ФИО']")
    WebElement fioFilter;

    @FindBy(id = "newCallOverdueFrame")
    WebElement newCallOverdueFrame;

    @FindBy(id = "newCallProgressFrame")
    WebElement newCallProgressFrame;

    @FindBy(id = "activeCallProgressFrame")
    WebElement activeCallProgressFrame;

    @FindBy(id = "doneCallProgressFrame")
    WebElement doneCallProgressFrame;

    @FindBy(id = "newCallAllCount")
    WebElement newCallAllCount;

    @FindBy(id = "cardSpace")
    WebElement cardSpace;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void exitToMis() {
        click(exitToMis);
        click(exitBtn);
    }

    @Step
    public void clickLogoType() {
        click(logoType);
        wait(cardSpace);
    }

    @Step
    public void searchFilterFio(String doctorName) throws InterruptedException {
        clickJS(fioFilter);
        sendKeys(fioFilter, doctorName);
        Thread.sleep(4000);
    }

    @Step
    public void clearFilterFio() {
        fioFilter.clear();
    }

    @Step
    public void verifyNewCallProgressFrame(String nameGen) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='newCallAllCount']/div[contains(text(),'1')]")));

        click(newCallProgressFrame);
        click(adressPro1_3);

        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(nameGen);
        //потом ещё добавить проверку номера телефона
    }

    @Step
    public void verifyActiveDocGroup(String doctorFam, String nameGen) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='activeCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(activeCallProgressFrame);
        click(adressPro1_3);

        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(nameGen);
        //потом ещё добавить проверку номера телефона
    }

    @Step
    public void verifyDoneDocGroup(String doctorFam, String nameGen) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='doneCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(doneCallProgressFrame);
        click(adressPro1_3);

        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(nameGen);
        //потом ещё добавить проверку номера телефона
    }


}