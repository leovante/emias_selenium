package test.moduls;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement callRow;

    public ModuleCallDoctor(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void filterCallDoctor() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(callDoctorSearchBtn));
        wait.until(ExpectedConditions.visibilityOfAllElements(menuBtn, menuBtn1, menuBtn2));

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
    }

    public void clickCallDoctorSearchBtn() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
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
        }
    }

    public void createNewCall_ExistingMkab() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add_doc_house_btn']/span[2]")));
        webDriver.findElement(By.xpath("//button[@id='add_doc_house_btn']/span[2]")).click();//создать вызов

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='openmkabbtn_dochouse']/span")));
        webDriver.findElement(By.xpath("//button[@id='openmkabbtn_dochouse']/span")).click();//открыть мкаб
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sinpDocHouseDLG_Call_MKABSelector")));
        webDriver.findElement(By.id("sinpDocHouseDLG_Call_MKABSelector")).sendKeys("   ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnfindDocHouseDLG_Call_MKABSelector")));
        webDriver.findElement(By.id("btnfindDocHouseDLG_Call_MKABSelector")).click();//поиск МКАБ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id='2467543']/td[3]")));

        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(
                    By.xpath("//div[@class='blockUI blockOverlay']"))));
        }

        webDriver.findElement(By.xpath("//tr[@id='2467543']/td[3]")).click(); //выбрать первое из списка

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ui-button-text']")));

        webDriver.findElement(By.xpath("//span[@class='ui-button-text'][text()='Выбрать']")).click(); //нажимаем на выбрать в окне МКАБ
        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(
                    By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@readonly='readonly']")));
        webDriver.findElement(By.id("Person_DomophonCode")).sendKeys("123");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Person_Entrance")));
        webDriver.findElement(By.id("Person_Entrance")).sendKeys("123");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Person_Floor")));
        webDriver.findElement(By.id("Person_Floor")).sendKeys("123");

        //поле жалобы
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='s2id_Complaint']/ul")));
        webDriver.findElement(By.xpath("//div[@id='s2id_Complaint']/ul")).click();//нажимаем на поле

        webDriver.findElement(By.id("s2id_autogen1")).sendKeys("боль");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-match'][text()='боль']")));
        new Actions(webDriver).sendKeys(Keys.ENTER).perform();

        //выбор врача
        webDriver.findElement(By.xpath("(//img[@alt='Выбор'])[3]")).click();
        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='341']/td[3]")));
        webDriver.findElement(By.xpath("//tr[@id='341']/td[3]")).click();//выбрать врача
        new Actions(webDriver).sendKeys(Keys.TAB).perform();
        new Actions(webDriver).sendKeys(Keys.ENTER).perform();

        //заполняем поля дальше
        wait.until(ExpectedConditions.elementToBeClickable(By.id("CallDoctorType-button")));
        webDriver.findElement(By.id("CallDoctorType-button")).click();//вид вызова
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Первичный")));
        webDriver.findElement(By.linkText("Первичный")).click();

        webDriver.findElement(By.xpath("//a[@id='CallDoctorStatus-button']/span")).click();//состояние вызова
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Завершенный")));
        webDriver.findElement(By.linkText("Завершенный")).click();

        //webDriver.findElement(By.id("btnIsFinalize")).click();//кнопка вызов выполнен
        webDriver.findElement(By.xpath("//button[@id='btnSave']/span")).click();//кнопка сохранить

        //всплывающее окно об ошибке
        List<WebElement> doctorList;
        int i = 0;
        while (wait.until(ExpectedConditions.elementToBeClickable(
                By.id("ui-dialog-title-whcdialog"))).isEnabled()) {
            new Actions(webDriver).sendKeys(Keys.ENTER).perform();
            if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
                wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
            }
            //выбор врача
            webDriver.findElement(By.xpath("(//img[@alt='Выбор'])[3]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("sinpclrDocHouseDLG_Call_DoctorSelector")));
            webDriver.findElement(By.id("sinpclrDocHouseDLG_Call_DoctorSelector")).click();//очистил поле от существующего
            if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
                wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
            }
            doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
            WebElement doctorOne = doctorList.get(i++);
            doctorOne.click();
            new Actions(webDriver).sendKeys(Keys.TAB).perform();
            new Actions(webDriver).sendKeys(Keys.ENTER).perform();
            webDriver.findElement(By.xpath("//button[@id='btnSave']/span")).click();//кнопка сохранить
        }
        if (!webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
    }
}