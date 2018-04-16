package test.scheduling;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModuleTimeTable {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

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

    public void createSheadle(){
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitLoaderleftspacer();
        String a = "0700", b = "0715";
        String c = "0715", d = "0730";
        String doctorNull = null;

        //поиск уникального врача
        waitBlockUI();
        waitWhileClickable(doctorRow);
        String doctorToCreateTask = doctorUnicalFromGrid(doctorNull);
        webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorToCreateTask + "')]")).click();

        deleteSheadule();

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

    public void setSetDoNotReceiveDays(){


            webDriver.findElement(By.xpath("//button[@id='btn_busy']/span[2]")).click();//задать неприемные дни
            webDriver.findElement(By.xpath("//div[@id='radio_busy']/label[14]/span/span")).click();//выбрали форс-мажор
            webDriver.findElement(By.xpath("//button[@id='btn_busy_save']/span")).click();//нажали сохранить
            webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();//подтвердили удаление сущ. записей
            webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div/div/div/span")).click();//это название заголовка


    }

    public void copySheadle(){
        waitLoaderleftspacer();
        waitWhileClickable(searchFieldBtn);

        searchFieldBtn.click();
        waitBlockUI();

        String doctorName = null;
        String firstDoctor = doctorUnicalFromGrid(doctorName);
        String secondDoctor = doctorUnicalFromGrid(firstDoctor);

        webDriver.findElement(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();
        waitBlockUI();
        webDriver.findElement(By.xpath("//*[contains(text(),'" + secondDoctor + "')]")).click();
        waitBlockUI();

        //копировать расписание
        webDriver.findElement(By.xpath("//button[@id='btn_copy']/span[2]")).click();
        webDriver.findElement(By.xpath("(//tr[@id='1078']/td[2])[2]")).click();
        webDriver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        webDriver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        webDriver.findElement(By.xpath("//div[25]/div[3]/div/button/span")).click();
        webDriver.findElement(By.xpath("//button[@id='finish_wizcopy']/span")).click();
        waitBlockUI();
        webDriver.findElement(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();//убрать галочку с первого врача
        waitBlockUI();
    }

    public void deleteSheadule(){//удалить расписание выбранного врача
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();

        waitBlockUI();

        waitWhileClickable(deleteSheadule);
        deleteSheadule.click();                     //кнопка удалить расписание
        waitWhileClickable(deleteSheaduleBtnWindow);
        deleteSheaduleBtnWindow.click();            //подтверждение удаления

        Thread.sleep(1000);
        keyboard.pressKey(Keys.ENTER);

        waitWidgetOverlay();
        waitBlockUI();
    }


    public void setTimeCalendar(String a, String b) {
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

    public void setTypeOfReception(WebElement typeOfReception) {
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

    public String doctorUnicalFromGrid(String doctorName) {
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "testov test testovich");
        dontUseNames.add(doctorName);

        System.out.println(dontUseNames);

        waitBlockUI();

        String doctorNameNull = doctorName;
        String doctorStringName = null;

        List<WebElement> doctorList = webDriver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1']/tbody"))//наашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей

        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();
            System.out.println("Первый список: " + doctorStringName + " " + count);

            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();
                System.out.println("Второй список: " + doctorStringName2 + " " + count);

                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }

            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }

        return doctorStringName;
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