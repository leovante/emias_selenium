package test.moduls;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public ModuleTimeTable(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void sozdanieRaspisaniya() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitLoaderleftspacer();

        //удалить существующее расписание
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys("test");
        searchFieldBtn.click();//нажать поиск

        waitBlockUI();

        wait.until(ExpectedConditions.elementToBeClickable(doctorRow));
        List<WebElement> doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
        for (WebElement oneDoctor : doctorList) {
            System.out.println(oneDoctor);
            oneDoctor.click();//нажимаем на доктора

            waitBlockUI();

            wait.until(ExpectedConditions.elementToBeClickable(deleteSheadule));
            deleteSheadule.click();//кнопка удалить расписание
            wait.until(ExpectedConditions.elementToBeClickable(deleteSheaduleBtnWindow));
            deleteSheaduleBtnWindow.click();

            Thread.sleep(1000);
            keyboard.pressKey(Keys.ENTER);

            waitWidgetOverlay();
            waitBlockUI();

            //нажимаем на создать расписание
            wait.until(ExpectedConditions.elementToBeClickable(createSheadule));
            createSheadule.click();

            wait.until(ExpectedConditions.elementToBeClickable(pickTime_nach));
            pickTime_nach.sendKeys("0700");          //нажимаем на поле начала интервала
            wait.until(ExpectedConditions.elementToBeClickable(pickTime_nachClose));
            pickTime_nachClose.click();

            Thread.sleep(500);

            wait.until(ExpectedConditions.elementToBeClickable(pickTime_okon));
            pickTime_okon.sendKeys("0715");          //нажимаем на поле окончание интервала
            wait.until(ExpectedConditions.elementToBeClickable(pickTime_okonClose));
            pickTime_okonClose.click();      //нажали закрыть календарь

            wait.until(ExpectedConditions.elementToBeClickable(ddlbusytypeButton));
            ddlbusytypeButton.click();       //нажимаем на выпадающий список тип приема

            wait.until(ExpectedConditions.elementToBeClickable(priemPoOcheredi));
            priemPoOcheredi.click();                  //выбор подменю
            wait.until(ExpectedConditions.elementToBeClickable(schedule_add_button));
            schedule_add_button.click();                            //нажали кнопу добавить
            wait.until(ExpectedConditions.elementToBeClickable(pickTime_nach));
            pickTime_nach.sendKeys("0715");          //нажимаем на поле начала интервала
            wait.until(ExpectedConditions.elementToBeClickable(pickTime_nachClose));
            pickTime_nachClose.click();

            Thread.sleep(500);

            wait.until(ExpectedConditions.elementToBeClickable(pickTime_okon));
            pickTime_okon.sendKeys("0730");          //нажимаем на поле окончание интервала
            wait.until(ExpectedConditions.elementToBeClickable(pickTime_okonClose));
            pickTime_okonClose.click();      //нажали закрыть календарь

            wait.until(ExpectedConditions.elementToBeClickable(ddlbusytypeButton));
            ddlbusytypeButton.click();       //нажимаем на выпадающий список тип приема

            wait.until(ExpectedConditions.elementToBeClickable(priemNaDomu));
            priemNaDomu.click();                  //выбор подменю
            wait.until(ExpectedConditions.elementToBeClickable(schedule_add_button));
            schedule_add_button.click();                            //нажали кнопу добавить

            wait.until(ExpectedConditions.elementToBeClickable(btn_save_schedule));
            btn_save_schedule.click();      //нажимаем кнопку сохранить

            keyboard.pressKey(Keys.ENTER);
            break;
        }
        waitWidgetOverlay();
        waitBlockUI();

        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']"));
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']"));
        System.out.println("проверка ячеек с этим цветом");

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
}