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

    public void createNewCall_ExistingMkab(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='add_doc_house_btn']/span[2]")));
        webDriver.findElement(By.xpath("//button[@id='add_doc_house_btn']/span[2]")).click();//создать вызов
//        webDriver.findElement(By.id("Person_Family")).clear();
//        webDriver.findElement(By.id("Person_Family")).sendKeys("123");
//        webDriver.findElement(By.id("Person_Name")).click();
//        webDriver.findElement(By.id("Person_Name")).clear();
//        webDriver.findElement(By.id("Person_Name")).sendKeys("123");
//        webDriver.findElement(By.id("Person_Patronymic")).click();
//        webDriver.findElement(By.id("Person_Patronymic")).clear();
//        webDriver.findElement(By.id("Person_Patronymic")).sendKeys("123");
//        webDriver.findElement(By.id("Person_Sex-button")).click();
//        webDriver.findElement(By.id("ui-selectmenu-item-448")).click();
//        webDriver.findElement(By.id("Person_BirthDate")).click();
//        webDriver.findElement(By.id("Person_Polis_Series")).click();
//        webDriver.findElement(By.id("Person_BirthDate")).click();
//        webDriver.findElement(By.id("Person_Polis_Series")).click();
//        webDriver.findElement(By.id("Person_Polis_Series")).clear();
//        webDriver.findElement(By.id("Person_Polis_Series")).sendKeys("1111111111");
//        webDriver.findElement(By.id("Person_Polis_Number")).click();
//        webDriver.findElement(By.id("Person_Polis_Number")).clear();
//        webDriver.findElement(By.id("Person_Polis_Number")).sendKeys("111111111111111");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='openmkabbtn_dochouse']/span")));
        webDriver.findElement(By.xpath("//button[@id='openmkabbtn_dochouse']/span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sinpDocHouseDLG_Call_MKABSelector")));
        webDriver.findElement(By.id("sinpDocHouseDLG_Call_MKABSelector")).clear();
        webDriver.findElement(By.id("sinpDocHouseDLG_Call_MKABSelector")).sendKeys("   ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnfindDocHouseDLG_Call_MKABSelector")));
        webDriver.findElement(By.id("btnfindDocHouseDLG_Call_MKABSelector")).click();//поиск МКАБ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id='2467543']/td[3]")));

        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(
                    By.xpath("//div[@class='blockUI blockOverlay']"))));
        }

        webDriver.findElement(By.xpath("//tr[@id='2467543']/td[3]")).click(); //выбрать первое из списка
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[28]/div[3]/div/button/span")));
        webDriver.findElement(By.xpath("//div[28]/div[3]/div/button/span")).click(); //ПАДАЕТ

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Person_DomophonCode")));
        webDriver.findElement(By.id("Person_DomophonCode")).click();
        webDriver.findElement(By.id("Person_DomophonCode")).clear();
        webDriver.findElement(By.id("Person_DomophonCode")).sendKeys("123");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Person_Entrance")));
        webDriver.findElement(By.id("Person_Entrance")).click();
        webDriver.findElement(By.id("Person_Entrance")).clear();
        webDriver.findElement(By.id("Person_Entrance")).sendKeys("123");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Person_Floor")));
        webDriver.findElement(By.id("Person_Floor")).click();
        webDriver.findElement(By.id("Person_Floor")).clear();
        webDriver.findElement(By.id("Person_Floor")).sendKeys("123");
        //блок
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='s2id_Complaint']/ul")));
        webDriver.findElement(By.xpath("//div[@id='s2id_Complaint']/ul")).click();
        webDriver.findElement(By.id("s2id_autogen2")).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s2id_autogen2")));
        webDriver.findElement(By.id("s2id_autogen2")).sendKeys("боль");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CallDoctorForm")));
        webDriver.findElement(By.id("CallDoctorForm")).submit();
        webDriver.findElement(By.id("Mkb_Name")).click();//что это?
        webDriver.findElement(By.xpath("//img[@alt='Выбор']")).click();//выбор диагноза
        webDriver.findElement(By.xpath("//tr[@id='26344']/td[2]")).click();
        webDriver.findElement(By.xpath("//div[34]/div[3]/div/button/span")).click();

        webDriver.findElement(By.xpath("(//img[@alt='Выбор'])[3]")).click();//выбор подразделения МО
        webDriver.findElement(By.xpath("//tr[@id='341']/td[2]/div")).click();
        webDriver.findElement(By.xpath("//div[37]/div[3]/div/button/span")).click();

        webDriver.findElement(By.xpath("(//img[@alt='Выбор'])[4]")).click();//выбор врача
        webDriver.findElement(By.xpath("//tr[@id='2616451']/td[8]")).click();
        webDriver.findElement(By.xpath("//div[39]/div[3]/div/button[2]/span")).click();

        webDriver.findElement(By.id("CallDoctorType-button")).click();//вид вызова
        webDriver.findElement(By.id("ui-selectmenu-item-884")).click();

        webDriver.findElement(By.xpath("//a[@id='CallDoctorStatus-button']/span")).click();//состояние вызова
        webDriver.findElement(By.id("ui-selectmenu-item-160")).click();

        webDriver.findElement(By.id("Comment")).click();//поле примечание
        webDriver.findElement(By.id("btnIsFinalize")).click();//кнопка вызов выполнен

        webDriver.findElement(By.xpath("(//img[@alt='Выбор'])[5]")).click();//выбор ТАП
        webDriver.findElement(By.xpath("(//tr[@id='341']/td[2]/div/span)[3]")).click();
        webDriver.findElement(By.xpath("//div[41]/div[3]/div/button/span")).click();
        webDriver.findElement(By.xpath("//button[@id='btnSave']/span")).click();

        webDriver.findElement(By.xpath("//tr[@id='51446']/td[3]")).click();

        webDriver.findElement(By.id("fio")).click();
        webDriver.findElement(By.id("fio")).clear();
        webDriver.findElement(By.id("fio")).sendKeys("нарницкая екатерина двитриевна");
    }
}