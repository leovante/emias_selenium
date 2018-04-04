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

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div/div")
    WebElement poleZayavok;

    public ModuleTimeTable(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void sozdanieRaspisaniya() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();

        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        //удалить существующее расписание
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sinpschw_docprvdgrid1")));
        webDriver.findElement(By.id("sinpschw_docprvdgrid1")).sendKeys("test");
        webDriver.findElement(By.id("btnfindschw_docprvdgrid1")).click();//нажать поиск

        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }

        wait.until(ExpectedConditions.elementToBeClickable(doctorRow));
        List<WebElement> doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
        for (WebElement oneDoctor : doctorList) {
            oneDoctor.click();//нажимаем на доктора
            if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
                wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn_delete']/span[2]")));
            webDriver.findElement(By.xpath("//button[@id='btn_delete']/span[2]")).click();//кнопка удалить расписание
            wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_delete_schedule")));
            webDriver.findElement(By.id("btn_delete_schedule")).click();
            //webDriver.findElement(By.xpath("//button[@id='btn_delete_schedule']/span")).click();
            Thread.sleep(1000);
            keyboard.pressKey(Keys.ENTER);

            if (!webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty()) {
                wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
            }
            if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
                wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
            }
            //нажимаем на создать расписание
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn_create']/span[2]")));
            webDriver.findElement(By.xpath("//button[@id='btn_create']/span[2]")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("pickTime_nach")));
            webDriver.findElement(By.id("pickTime_nach")).sendKeys("0700");          //нажимаем на поле начала интервала
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("pickTime_okon")));
            webDriver.findElement(By.id("pickTime_okon")).sendKeys("0715");          //нажимаем на поле окончание интервала
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();      //нажали закрыть календарь
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ddlbusytype-button']/span[2]")));
            webDriver.findElement(By.xpath("//a[@id='ddlbusytype-button']/span[2]")).click();       //нажимаем на выпадающий список тип приема
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Прием по очереди")));
            webDriver.findElement(By.linkText("Прием по очереди")).click();                  //выбор подменю
            wait.until(ExpectedConditions.elementToBeClickable(By.id("schedule_add_button")));
            webDriver.findElement(By.id("schedule_add_button")).click();                            //нажали кнопу добавить

            wait.until(ExpectedConditions.elementToBeClickable(By.id("pickTime_nach")));
            webDriver.findElement(By.id("pickTime_nach")).sendKeys("0715");          //нажимаем на поле начала интервала
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("pickTime_okon")));
            webDriver.findElement(By.id("pickTime_okon")).sendKeys("0730");          //нажимаем на поле окончание интервала
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();      //нажали закрыть календарь
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ddlbusytype-button']/span[2]")));
            webDriver.findElement(By.xpath("//a[@id='ddlbusytype-button']/span[2]")).click();       //нажимаем на выпадающий список тип приема
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Прием на дому (вызов на дом)")));
            webDriver.findElement(By.linkText("Прием на дому (вызов на дом)")).click();                  //выбор подменю
            wait.until(ExpectedConditions.elementToBeClickable(By.id("schedule_add_button")));
            webDriver.findElement(By.id("schedule_add_button")).click();                            //нажали кнопу добавить

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn_save_schedule']/span")));
            webDriver.findElement(By.xpath("//button[@id='btn_save_schedule']/span")).click();      //нажимаем кнопку сохранить

            keyboard.pressKey(Keys.ENTER);
            break;
        }
        if (!webDriver.findElements(By.xpath("//div[@class='ui-widget-overlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='ui-widget-overlay']"))));
        }
        if (!webDriver.findElements(By.xpath("//div[@class='blockUI blockOverlay']")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[@class='blockUI blockOverlay']"))));
        }

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
}