package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

import java.util.List;

import static org.testng.Assert.assertFalse;

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

    @FindBy(xpath = "//*[@placeholder='Вид вызова']")
    WebElement typeCall;

    @FindBy(id = "newCallProgressFrame")
    WebElement newCallProgressFrame;

    @FindBy(xpath = "//*[@id='newCallProgressFrame']/mat-expansion-panel/div")
    WebElement matexpansionpanel;

    @FindBy(xpath = "//*[@id='newCallProgressFrame']/mat-expansion-panel/div/div/div/app-call-doctor-short-card/div/div/div[3]")
    WebElement smallMenu;

    @FindBy(xpath = "//a[@title='Открыть карту вызова']")
    WebElement openCard;

    @FindBy(xpath = "//span[contains(text(),'Неотложный')]")
    WebElement typeCallFilterNeotlozhniy;

    @FindBy(id = "activeCallProgressFrame")
    WebElement activeCallProgressFrame;

    @FindBy(id = "doneCallProgressFrame")
    WebElement doneCallProgressFrame;

    @FindBy(id = "cardSpace")
    WebElement cardSpace;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("вышел в мис")
    public void exitToMis() {
        click(exitToMis);
        click(exitBtn);
    }

    @Step("нажать на логотип")
    public void clickLogoType() {
        click(logoType);
        waitClickable(cardSpace);
    }

    @Step("поиск в фильтре ФИО")
    public void searchFilterFio(String fioName) {
        clickJS(fioFilter);
        sendKeysJS(fioFilter, fioName);
    }

    @Step("поиск в фильтре врача")
    public void searchFilterDoctor(String fioName) throws InterruptedException {
        clickJS(docFilter);
        sendKeysJS(docFilter, fioName);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
    }

    @Step("поиск в фильтре врача")
    public void searchFilterTypeCallNeotlozhniy() throws InterruptedException {
        clickJS(typeCall);
        clickJS(typeCallFilterNeotlozhniy);
        Thread.sleep(4000);
    }



    @Step("очистить фильтр подразделение")
    public void clearFilterDepart() {
        List<WebElement> closeList = driver.findElements(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (WebElement closeBtn : closeList) {
            click(closeBtn);
        }
    }


    @Step("проверяю на дашборде запись в группе новые")
    public void verifyNewCallProgressFrame(String name, String adress, String telephone) throws InterruptedException {
        Thread.sleep(4000);
        clickJSext(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        click(adress);
        isDisplayedOnCardPage(name);
        isDisplayedOnCardPage(telephone);
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public void verifyActiveDocGroup(String doctorFam, String nameGen, String adress, String telephone) throws InterruptedException {
        Thread.sleep(4000);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='activeCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(activeCallProgressFrame);
        click(adress);

        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(telephone);
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(String doctorFam, String nameGen, String adress, String telephone) throws InterruptedException {
        Thread.sleep(4000);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='doneCallAllCount'][contains(text(),'1')]")));

        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        click(doneCallProgressFrame);
        click(adress);

        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(telephone);
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyRecordIsCancelFromDashboard() throws InterruptedException {
        Thread.sleep(4000);
        assertFalse(newCallProgressFrame.findElement(By.id("order")).isDisplayed());
    }

    @Step("открываю фрейм ожидают обработки")
    public void openNewCallProgressFrame(String nameGen) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        waitClickable(newCallProgressFrame);
        clickJSext(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        hoverByAction(matexpansionpanel);
        clickJSext(smallMenu);
        clickJSext(openCard);
    }
}