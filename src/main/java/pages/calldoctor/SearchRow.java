package pages.calldoctor;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchRow {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "searchByFilter")
    WebElement callDoctorSearchBtn;

    @FindBy(xpath = "//table[@id='call_doc_house_grid']/tbody/tr[2]/td")
    WebElement tableGrid;

    @FindBy(xpath = "//a[@id='callDoctorLpuList-button']/span")
    WebElement menuBtn;

    @FindBy(xpath = "//a[@id='callDoctorUchastokList-button']/span")
    WebElement menuBtn1;

    @FindBy(xpath = "//a[@id='callDoctorTypeList-button']/span")
    WebElement menuBtn2;

    @FindBy(xpath="//a[@id='callDoctorLpuList-button']/span")
    WebElement click_one;

    @FindBy(linkText="Взрослое поликлиническое отделение №2")
    WebElement click_two;

    @FindBy(xpath="//a[@id='callDoctorUchastokList-button']/span")
    WebElement click_three;

    @FindBy(linkText="поликл Взр-2 10 участок терапевт Взр-2")
    WebElement click_fore;

    @FindBy(xpath="//a[@id='callDoctorTypeList-button']/span")
    WebElement click_five;

    @FindBy(linkText="Первичный")
    WebElement click_six;

    public SearchRow(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void filterCallDoctor() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorSearchBtn));
        wait.until(ExpectedConditions.visibilityOfAllElements(menuBtn, menuBtn1, menuBtn2));
        wait.until(ExpectedConditions.elementToBeClickable(click_one));
        click_one.click();
        click_two.click();
        click_three.click();
        wait.until((ExpectedConditions.elementToBeClickable(click_fore)));
        click_fore.click();
        click_five.click();
        wait.until((ExpectedConditions.elementToBeClickable(click_six)));
        click_six.click();
    }

    public void clickCallDoctorSearchBtn() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void waitForSearchResults() {
        //System.out.println("wait why table appeared");
        wait.until(ExpectedConditions.elementToBeClickable(tableGrid));
        //System.out.println("the table appeared");
    }

    public void verificationTableGridNull() {
        //System.out.println("Проверка что таблицы нет");
        if (!webDriver.findElements(By.xpath("//table[@id='call_doc_house_grid']/tbody/tr[2]/td")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
    }
}