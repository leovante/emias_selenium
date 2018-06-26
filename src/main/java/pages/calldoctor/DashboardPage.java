package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DashboardPage extends BasePage {
    Actions action = new Actions(driver);
    @FindBy(xpath = "//mat-icon[contains(text(),'more_vert')]")
    WebElement exitToMis;

    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    WebElement exitBtn;

    @FindBy(xpath = "//img[@src='assets/img/call-doctor-logo.svg']")
    WebElement logoType;

    @FindBy(xpath = "//*[@placeholder='ФИО']")
    WebElement fioFilter;

    @FindBy(xpath = "//*[@placeholder='Врач']")
    WebElement docFilter;

    @FindBy(id = "newCallProgressFrame")
    WebElement newCallProgressFrame;

    @FindBy(id = "activeCallProgressFrame")
    WebElement activeCallProgressFrame;

    @FindBy(id = "doneCallProgressFrame")
    WebElement doneCallProgressFrame;

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
    public void searchFilterFio(String fioName) throws InterruptedException {
        clickJS(fioFilter);
        sendKeys(fioFilter, fioName);
        Thread.sleep(4000);
    }

    @Step
    public void searchFilterDoctor(String fioName) throws InterruptedException {
        clickJS(docFilter);
        sendKeys(docFilter, fioName);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
    }

    @Step
    public void verifyNewCallProgressFrame(String name, String adress, String telephone) throws InterruptedException {
        clickJSext(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        click(adress);
        isDisplayedOnCardPage(name);
        isDisplayedOnCardPage(telephone);
    }

    @Step
    public void verifyActiveDocGroup(String doctorFam, String nameGen, String adress, String telephone) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='activeCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(activeCallProgressFrame);
        click(adress);

        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(telephone);
    }

    @Step
    public void verifyDoneDocGroup(String doctorFam, String nameGen, String adress, String telephone) throws InterruptedException {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='doneCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(doneCallProgressFrame);
        click(adress);

        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(telephone);
    }
}