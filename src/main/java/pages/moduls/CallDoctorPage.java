package pages.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallDoctorPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "searchByFilter")
    WebElement callDoctorSearchBtn;

    @FindBy(id = "call_doc_house_grid")
    WebElement tableGrid;

//    @FindBy(css = "tr[role='row']")
//    WebElement callDoctorPatientPotition;

    public CallDoctorPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCallDoctorSearchBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorSearchBtn));
        Thread.sleep(3000);
        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void filterCallDoctorSearchBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorSearchBtn));
        Thread.sleep(3000);
        System.out.println("wait until filter is load");
        System.out.println("click 1");
        webDriver.findElement(By.xpath("//a[@id='callDoctorLpuList-button']/span")).click();

        System.out.println("click 2 выбор Акушерское отделение");
        //webDriver.findElement(By.id("ui-selectmenu-item-991")).click();
        webDriver.findElement(By.xpath("xpath=(//a[contains( text(),'Акушерское отделение')])[2]&nbsp")).click();

        System.out.println("click 3");
        webDriver.findElement(By.xpath("//a[@id='callDoctorUchastokList-button']/span")).click();

        System.out.println("click 4");
        webDriver.findElement(By.id("ui-selectmenu-item-77")).click();

        System.out.println("click 5");
        webDriver.findElement(By.xpath("//a[@id='callDoctorTypeList-button']/span")).click();

        System.out.println("click 6");
        webDriver.findElement(By.id("ui-selectmenu-item-138")).click();

        System.out.println("click callDoctorSearchBtn");
        callDoctorSearchBtn.click();
    }

    public void waitForSearchResults() {
        System.out.println("wait why table appeared");
        wait.until(ExpectedConditions.elementToBeClickable(tableGrid));
        System.out.println("the table appeared");
    }
}