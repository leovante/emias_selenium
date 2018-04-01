package test.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuleCallDoctor {
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

    @FindBy(id = "loaderleftspacer")
    WebElement spiner;

    public ModuleCallDoctor(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void filterCallDoctorSearchBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorSearchBtn));
        wait.until(ExpectedConditions.visibilityOfAllElements(menuBtn, menuBtn1, menuBtn2));

        //Thread.sleep(3000);
        System.out.println("click 1");
        wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='callDoctorLpuList-button']/span"))));
        webDriver.findElement(By.xpath("//a[@id='callDoctorLpuList-button']/span")).click();
        System.out.println("click 2");
        webDriver.findElement(By.linkText("Взрослое поликлиническое отделение №2")).click();

        System.out.println("click 3");
        webDriver.findElement(By.xpath("//a[@id='callDoctorUchastokList-button']/span")).click();
        System.out.println("click 4");
        wait.until((ExpectedConditions.elementToBeClickable(By.linkText("поликл Взр-2 10 участок терапевт Взр-2"))));
        webDriver.findElement(By.linkText("поликл Взр-2 10 участок терапевт Взр-2")).click();

        System.out.println("click 5");
        webDriver.findElement(By.xpath("//a[@id='callDoctorTypeList-button']/span")).click();
        System.out.println("click 6");
        wait.until((ExpectedConditions.elementToBeClickable(By.linkText("Первичный"))));
        webDriver.findElement(By.linkText("Первичный")).click();

        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void clickCallDoctorSearchBtn() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        } else {
        }
        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void waitForSearchResults() {
        System.out.println("wait why table appeared");
        wait.until(ExpectedConditions.elementToBeClickable(tableGrid));
        System.out.println("the table appeared");
    }

    public void verificationTableGridNull() {
        System.out.println("Проверка что таблицы нет");
        if (!webDriver.findElements(By.xpath("//table[@id='call_doc_house_grid']/tbody/tr[2]/td")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        } else {

        }
    }
}