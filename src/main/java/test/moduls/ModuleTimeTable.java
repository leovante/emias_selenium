package test.moduls;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class ModuleTimeTable {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Logger logger;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    @FindBy(id = "sinpschw_docprvdgrid1")
    WebElement searchField;

    @FindBy(id = "btnfindschw_docprvdgrid1")
    WebElement searchFieldBtn;

    @FindBy(xpath = "//button[@id='btn_delete']/span[2]")
    WebElement deleteSheadule;

    @FindBy(id = "btn_delete_schedule")
    WebElement deleteSheaduleBtnWindow;

    @FindBy(xpath = "//button[@id='btn_create']/span[2]")
    WebElement createSheadule;

    @FindBy(id = "pickTime_nach")
    WebElement pickTime_nach;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement pickTime_nachClose;

    @FindBy(id = "pickTime_okon")
    WebElement pickTime_okon;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement pickTime_okonClose;

    @FindBy(xpath = "//a[@id='ddlbusytype-button']/span[2]")
    WebElement ddlbusytypeButton;

    @FindBy(linkText = "Прием по очереди")
    WebElement priemPoOcheredi;

    @FindBy(linkText = "Прием на дому (вызов на дом)")
    WebElement priemNaDomu;

    @FindBy(id = "schedule_add_button")
    WebElement schedule_add_button;

    @FindBy(xpath = "//button[@id='btn_save_schedule']/span")
    WebElement btn_save_schedule;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement firstDoctor;

    public ModuleTimeTable(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createSheadle() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitLoaderleftspacer();
        String a = "0700", b = "0715";
        String c = "0715", d = "0730";
        //поиск врача test
        waitWhileClickable(searchField);
        searchField.sendKeys("test");
        searchFieldBtn.click();//нажать поиск
        waitBlockUI();
        waitWhileClickable(doctorRow);
        //ЗДЕСЬ ЗАМЕНЯЕМ ВЫБОР ВРАЧА TEST НА ВЫБОР ЕДИНСТВЕННОГО ВРАЧА ЧЕРЕЗ МЕТОД
        firstDoctor.click();

        waitBlockUI();

        waitWhileClickable(deleteSheadule);
        deleteSheadule.click();                     //кнопка удалить расписание
        waitWhileClickable(deleteSheaduleBtnWindow);
        deleteSheaduleBtnWindow.click();            //подтверждение удаления

        Thread.sleep(1000);
        keyboard.pressKey(Keys.ENTER);

        waitWidgetOverlay();
        waitBlockUI();

        //нажимаем на создать расписание
        waitWhileClickable(createSheadule);
        createSheadule.click();

        setTimeCalendar(a, b);
        setTypeOfReception(priemPoOcheredi);

        setTimeCalendar(c, d);
        setTypeOfReception(priemNaDomu);

        waitWhileClickable(btn_save_schedule);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);

        waitWidgetOverlay();
        waitBlockUI();

        /*taskArea.click();
        Actions action = new Actions(webDriver);
        action.contextClick(taskArea).perform();
        //Thread.sleep(1000);
        //webDriver.findElement(By.xpath("//div[id='jqContextMenu']"));
        //.findElement(By.xpath("//li[id='sch_del_menu']")).click();
*/
  /*      Воспользоваться классом Wait и ждать пока Selenium#isElementPresent не вернёт true для нужного option'а.
        Этот способ уже лучше, но всё равно не должен применяться, в будущем напишу подробно почему. Лучше вместо
        класса Wait использовать метод Selenium#waitForCondition, в котором и ждать появления требуемого элемента.
  */


/*  https://habrahabr.ru/post/111649/
        Selenium.prototype.doWaitForJqueryAjaxRequests = function(timeout) {
            return Selenium.decorateFunctionWithTimeout(function() {
                return selenium.browserbot.getUserWindow().jQuery.active == 0;
            }, timeout);
        };
        */
    }

    public void setTimeCalendar(String a, String b) throws InterruptedException {
        waitWhileClickable(pickTime_nach);
        pickTime_nach.sendKeys(a);          //нажимаем на поле начала интервала
        waitWhileClickable(pickTime_nachClose);
        pickTime_nachClose.click();
        Thread.sleep(500);
        waitWhileClickable(pickTime_okon);
        pickTime_okon.sendKeys(b);          //нажимаем на поле окончание интервала
        waitWhileClickable(pickTime_okonClose);
        pickTime_okonClose.click();      //нажали закрыть календарь
    }

    public void setTypeOfReception(WebElement typeOfReception){
        waitWhileClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        waitWhileClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
        waitWhileClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    public void checkCreateSheadle() {
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']"));
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']"));
        System.out.println("проверка ячеек с этим цветом");
    }


    public void doctorGrid() {
        //выполнить пустой поиск и получить список всех врачей
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(" ");
        searchFieldBtn.click();//нажать поиск

        waitBlockUI();

        List<WebElement> doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
        Iterator<WebElement> i = doctorList.iterator();
        while(i.hasNext()){
            WebElement row = i.next();
            System.out.println(row.getText());
        }

        //вытащить имя первого врача и вставить его в строку поиска

        //проверить что в гриде только один врач, если нет - в строку поиска вставить второго врача
        //запомнить id врача
        //выполнить пустой поиск и выбрать врача test и второго по id

        for (WebElement oneDoctor : doctorList) {

            oneDoctor.click();//нажимаем на доктора
        }
    }


    public void copySheadle() {

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

    public boolean waitLoaderleftspacer() {
        boolean loaderleftspacer = !webDriver.findElements(By.id("loaderleftspacer")).isEmpty();
        if (loaderleftspacer) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        return loaderleftspacer;
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}