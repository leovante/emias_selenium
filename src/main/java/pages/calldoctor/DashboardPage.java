package pages.calldoctor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;
import pages.utilities.JSWaiter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertFalse;

public class DashboardPage extends AbstractPage implements Profile {
    Map proData;
    Actions action = new Actions(driver);

    @FindBy(xpath = "//mat-icon[contains(text(),'more_vert')]")
    @CacheLookup
    WebElement exitToMis;

    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    @CacheLookup
    WebElement exitBtn;

    @FindBy(xpath = "//img[@src='assets/img/call-doctor-logo.svg']")
    @CacheLookup
    WebElement logoType;

    @FindBy(xpath = "//*[@placeholder='ФИО']")
    @CacheLookup
    WebElement fioFilter;

    @FindBy(xpath = "//*[@placeholder='Врач']")
    @CacheLookup
    WebElement docFilter;

    @FindBy(xpath = "//*[@placeholder='Вид вызова']")
    @CacheLookup
    WebElement typeCall;

    @FindBy(id = "newCallProgressFrame")
    @CacheLookup
    WebElement newCallProgressFrame;

    @FindBy(xpath = "//*[@id='newCallProgressFrame']/mat-expansion-panel/div")
    @CacheLookup
    WebElement matexpansionpanel;

    @FindBy(xpath = "//*[@id='newCallProgressFrame']/mat-expansion-panel/div/div/div/app-call-doctor-short-card/div/div/div[3]")
    @CacheLookup
    WebElement smallMenu;

    @FindBy(xpath = "//a[@title='Открыть карту вызова']")
    @CacheLookup
    WebElement openCard;

    @FindBy(xpath = "//span[contains(text(),'Неотложный')]")
    @CacheLookup
    WebElement typeCallFilterNeotlozhniy;

    @FindBy(id = "activeCallProgressFrame")
    @CacheLookup
    WebElement activeCallProgressFrame;

    @FindBy(id = "doneCallProgressFrame")
    @CacheLookup
    WebElement doneCallProgressFrame;

    @FindBy(id = "cardSpace")
    @CacheLookup
    WebElement cardSpace;

    @FindBy(id = "activeDocGroup")
    WebElement activeDocGroup;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("вышел в мис")
    public DashboardPage exitToMis() {
        click(exitToMis);
        click(exitBtn);
        return this;
    }

    @Step("нажать на логотип")
    public DashboardPage clickLogoType() {
        click(logoType);
        waitClickableJS(cardSpace);
        return this;
    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio(String fioName) {
        clickJS(fioFilter);
        sendKeysJS(fioFilter, fioName);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(String fioName) throws InterruptedException {
        clickJS(docFilter);
        sendKeysJS(docFilter, fioName);
        Thread.sleep(1000);
//        waitClickable(driver.findElement(By.xpath("//call-doctor-board/st-autocompile/mat-form-field/div/div/div/div/ul/li[@data-value='" + fioName + "']")));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterTypeCallNeotlozhniy() throws InterruptedException {
        clickJS(typeCall);
        clickJS(typeCallFilterNeotlozhniy);
        Thread.sleep(4000);
        return this;
    }



    @Step("очистить фильтр подразделение")
    public DashboardPage clearFilterDepart() {
        List<WebElement> closeList = driver.findElements(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (WebElement closeBtn : closeList) {
            click(closeBtn);
        }
        return this;
    }


    @Step("проверяю на дашборде запись в группе новые")
    public DashboardPage verifyNewCallProgressFrame(String name, String adress, String telephone) throws InterruptedException {
        Thread.sleep(4000);
        clickJS(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        click(adress);
        isDisplayedOnCardPage(name);
        isDisplayedOnCardPage(telephone);
        return this;
    }

    @Step("проверяю на дашборде запись в группе новые")
    public DashboardPage verifyNewCallProgressFrame(String name) throws InterruptedException, IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + name + ".json");
        this.proData = new ObjectMapper().readValue(reader, Map.class);

        Thread.sleep(4000);
        clickJS(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        click((String) proData.get(adressDashboard));
        isDisplayedOnCardPage(name);
        isDisplayedOnCardPage((String) proData.get(telephone));
        return this;
    }



    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPage verifyActiveDocGroup(String doctorFam, String nameGen, String adress, String telephone) throws InterruptedException {
        Thread.sleep(4000);
        activeDocGroup.findElement(By.xpath("//*[contains(text(),'" + doctorFam + "')]")).click();
//        click(driver.findElement(By.xpath("//span[contains(text(),'" + doctorFam + "')]")));
        clickJS(activeCallProgressFrame.findElement(By.id("order")));
        click(activeCallProgressFrame);
        click(adress);

        assertTextIsVisible(nameGen);
        assertTextIsVisible(telephone);
        return this;
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
    public DashboardPage verifyRecordIsCancelFromDashboard() throws InterruptedException {
        Thread.sleep(4000);
        assertFalse(newCallProgressFrame.findElement(By.id("order")).isDisplayed());
        return this;
    }

    @Step("открываю фрейм ожидают обработки")
    public DashboardPage openNewCallProgressFrame(String nameGen) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        JSWaiter.waitJQueryAngular();

        waitClickableJS(newCallProgressFrame);
        clickJS(newCallProgressFrame.findElement(By.id("order")));
        click(newCallProgressFrame);

        hoverByAction(matexpansionpanel);
        clickJS(smallMenu);
        clickJS(openCard);
        return this;
    }
}