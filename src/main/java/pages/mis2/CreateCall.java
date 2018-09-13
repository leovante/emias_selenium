package pages.mis2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateCall {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@id='add_doc_house_btn']/span[2]")
    @CacheLookup
    WebElement createCall;

    @FindBy(xpath = "//button[@id='openmkabbtn_dochouse']/span")
    @CacheLookup
    WebElement openMkab;

    @FindBy(id = "sinpDocHouseDLG_Call_MKABSelector")
    @CacheLookup
    WebElement searchField;

    @FindBy(id = "btnfindDocHouseDLG_Call_MKABSelector")
    @CacheLookup
    WebElement searchMkab;

    @FindBy(xpath = "//tr[@id='2467543']/td[3]")
    @CacheLookup
    WebElement mkabPosition;

    @FindBy(xpath = "//span[@class='ui-button-text'][text()='Выбрать']")
    @CacheLookup
    WebElement selectPkab;

    @FindBy(xpath = "//input[@readonly='readonly']")
    @CacheLookup
    WebElement readonly;

    @FindBy(id = "Person_DomophonCode")
    @CacheLookup
    WebElement person_DomophonCode;

    @FindBy(id = "Person_Entrance")
    @CacheLookup
    WebElement person_Entrance;

    @FindBy(id = "Person_Floor")
    @CacheLookup
    WebElement person_Floor;

    @FindBy(xpath = "//div[@id='s2id_Complaint']/ul")
    @CacheLookup
    WebElement pole_Zhalobi;

    @FindBy(id = "s2id_autogen1")
    @CacheLookup
    WebElement zhaloba;

    @FindBy(xpath = "//span[@class='select2-match'][text()='боль']")
    @CacheLookup
    WebElement waitZhaloba;

    @FindBy(xpath = "(//img[@alt='Выбор'])[3]")
    @CacheLookup
    WebElement selectDoctor;

    @FindBy(xpath = "//tr[@id='341']/td[3]")
    @CacheLookup
    WebElement doctorNarickaya;

    @FindBy(xpath = "CallDoctorType-button")
    @CacheLookup
    WebElement viewCall;

    @FindBy(linkText = "Первичный")
    @CacheLookup
    WebElement pervichniy;

    @FindBy(xpath = "//a[@id='CallDoctorStatus-button']/span")
    @CacheLookup
    WebElement statusCall;

    @FindBy(linkText = "Завершенный")
    @CacheLookup
    WebElement zavershenniy;

    @FindBy(xpath = "//button[@id='btnSave']/span")
    @CacheLookup
    WebElement saveCall;

    @FindBy(id = "ui-dialog-title-whcdialog")
    @CacheLookup
    WebElement dialogDoctorIsFull;

    @FindBy(xpath = "(//img[@alt='Выбор'])[3]")
    @CacheLookup
    WebElement dialogSelect;

    @FindBy(id = "sinpclrDocHouseDLG_Call_DoctorSelector")
    @CacheLookup
    WebElement clearFieldSearchDoctor;

    @FindBy(xpath = "//button[@id='btnSave']/span")
    @CacheLookup
    WebElement saveDialogBtn;

    public CreateCall(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createNewCall_ExistingMkab() {
        Actions action = new Actions(webDriver);

        wait.until(ExpectedConditions.elementToBeClickable(createCall));
        createCall.click();//создать вызов
        wait.until(ExpectedConditions.elementToBeClickable(openMkab));
        openMkab.click();//открыть мкаб
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys("   ");
        wait.until(ExpectedConditions.elementToBeClickable(searchMkab));
        searchMkab.click();//поиск МКАБ

        waitBlockUI();

        wait.until(ExpectedConditions.elementToBeClickable(mkabPosition));
        mkabPosition.click(); //выбрать первое из списка
        wait.until(ExpectedConditions.elementToBeClickable(selectPkab));
        selectPkab.click(); //нажимаем на выбрать в окне МКАБ

        waitBlockUI();

        wait.until(ExpectedConditions.elementToBeClickable(readonly));
        person_DomophonCode.sendKeys("123");
        wait.until(ExpectedConditions.elementToBeClickable(person_Entrance));
        person_Entrance.sendKeys("123");
        wait.until(ExpectedConditions.elementToBeClickable(person_Floor));
        person_Floor.sendKeys("123");
        //поле жалобы
        wait.until(ExpectedConditions.elementToBeClickable(pole_Zhalobi));
        pole_Zhalobi.click();//нажимаем на поле
        zhaloba.sendKeys("боль");
        wait.until(ExpectedConditions.elementToBeClickable(waitZhaloba));
        action.sendKeys(Keys.ENTER).perform();
        //выбор врача
        selectDoctor.click();

        waitBlockUI();

        wait.until(ExpectedConditions.elementToBeClickable(doctorNarickaya));
        doctorNarickaya.click();//выбрать врача
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        //заполняем поля дальше
        wait.until(ExpectedConditions.elementToBeClickable(viewCall));
        viewCall.click();//вид вызова
        wait.until(ExpectedConditions.elementToBeClickable(pervichniy));
        pervichniy.click();

        statusCall.click();//состояние вызова
        wait.until(ExpectedConditions.elementToBeClickable(zavershenniy));
        zavershenniy.click();
        saveCall.click();//кнопка сохранить

        //всплывающее окно об ошибке
        List<WebElement> doctorList;
        int i = 0;
        while (wait.until(ExpectedConditions.elementToBeClickable(dialogDoctorIsFull)).isEnabled()) {
            action.sendKeys(Keys.ENTER).perform();

            waitBlockUI();

            //выбор врача
            dialogSelect.click();
            wait.until(ExpectedConditions.elementToBeClickable(clearFieldSearchDoctor));
            clearFieldSearchDoctor.click();//очистил поле от существующего

            waitBlockUI();

//            doctorList = webDriver.findElements(By.xpath(
//                    "//tr[@role='row'][@tabindex='-1'][@class='ui-widget-content jqgrow ui-row-ltr ui-priority-secondary']/td[17]"));
            //doctorList = webDriver.findElements(By.xpath("//tr[@id='501']/td[3]"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='501']/td[3]")));
            webDriver.findElement(By.xpath("//tr[@id='501']/td[3]")).click();//выбрать врача

            //WebElement doctorOne = doctorList.get(1);

            //System.out.println("количество врачей" + doctorList.size());
            //System.out.println("первый врач" + doctorOne);
            //doctorOne = doctorList.get(2);
            //System.out.println("второй врач" + doctorOne);

            //doctorOne.click();
            action.sendKeys(Keys.TAB).perform();
            action.sendKeys(Keys.ENTER).perform();
            wait.until(ExpectedConditions.elementToBeClickable(saveDialogBtn));
            saveDialogBtn.click();//кнопка сохранить
        }
        waitWidgetOverlay();
        waitBlockUI();
    }

    public boolean waitBlockUI() {
        boolean BlockAssert = !webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty();
        if (BlockAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }
        return BlockAssert;
    }

    public boolean waitWidgetOverlay() {
        boolean WidgetAssert = !webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty();
        if (WidgetAssert) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        return WidgetAssert;
    }
}