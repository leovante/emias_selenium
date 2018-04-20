package test.arm;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import static junit.framework.TestCase.assertFalse;

public class ModuleTimeTable {
    private WebDriver webDriver;
    private WebDriverWait wait;
    final String doctorNull = null;


    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    @FindBy(id = "btnfindschw_docprvdgrid1")
    WebElement searchFieldBtn;

    @FindBy(xpath = "//button[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(id = "btn_delete_schedule")
    WebElement deleteSheduleBtnWindow;

    @FindBy(xpath = "//button[@id='btn_create']/span[2]")
    WebElement createShedule;

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

    @FindBy(xpath = "//button[@id='btn_busy']/span[2]")
    WebElement btn_notReciveDays;

    @FindBy(xpath = "//div[@id='radio_busy']/label[2]/span/span")
    WebElement row_doctorOnBoln;

    @FindBy(xpath = "//button[@id='btn_busy_save']/span")
    WebElement saveBtn;

    @FindBy(xpath = "//div[24]/div[3]/div/button/span")
    WebElement yesBtn;

    @FindBy(xpath = "//button[@id='btn_copy']/span[2]")
    WebElement copyShedule;


    public ModuleTimeTable(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createShedule() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitLoaderLeftspacer();
        String a = "2230", b = "2245";
        String c = "2245", d = "2300";
        waitWhileClickable(createShedule);
        waitBlockUI();
        createShedule.click();

        setTimeCalendar(a, b);
        setTypeOfReception(priemPoOcheredi);

        setTimeCalendar(c, d);
        setTypeOfReception(priemNaDomu);

        waitWhileClickable(btn_save_schedule);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
//        /*taskArea.click();
//        Actions action = new Actions(webDriver);
//        action.contextClick(taskArea).perform();
//        //Thread.sleep(1000);
//        //webDriver.findElement(By.xpath("//div[id='jqContextMenu']"));
//        //.findElement(By.xpath("//li[id='sch_del_menu']")).click();
//*/
//  /*      Воспользоваться классом Wait и ждать пока Selenium#isElementPresent не вернёт true для нужного option'а.
//        Этот способ уже лучше, но всё равно не должен применяться, в будущем напишу подробно почему. Лучше вместо
//        класса Wait использовать метод Selenium#waitForCondition, в котором и ждать появления требуемого элемента.
//  */
//
//
///*  https://habrahabr.ru/post/111649/
//        Selenium.prototype.doWaitForJqueryAjaxRequests = function(timeout) {
//            return Selenium.decorateFunctionWithTimeout(function() {
//                return selenium.browserbot.getUserWindow().jQuery.active == 0;
//            }, timeout);
//        };
//        */
    }

    public void selectDoctor(String doctorInlet) throws InterruptedException {
        waitLoaderLeftspacer();
        waitWidgetOverlay();
        waitBlockUI();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")));
        webDriver.findElement(By.xpath("//*[contains(text(),'" + doctorInlet + "')]")).click();
        waitBlockUI();
        waitWidgetOverlay();
    }

    public void searchFiled() {
        waitWidgetOverlay();
        waitBlockUI();

        searchFieldBtn.click();

        waitWidgetOverlay();
        waitBlockUI();
    }


    public void setDoNotReceiveDays() {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitLoaderLeftspacer();
        String firstDoctor = getUnicalDoctor(null);
        webDriver.findElement(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();
        waitBlockUI();

        waitWhileClickable(btn_notReciveDays);
        btn_notReciveDays.click();//задать неприемные дни

        waitWhileClickable(row_doctorOnBoln);
        row_doctorOnBoln.click();//выбрали форс-мажор

        waitWhileClickable(saveBtn);
        saveBtn.click();//нажали сохранить

        keyboard.pressKey(Keys.ENTER);
    }

    public void copyShedule(String docName) throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();

        waitLoaderLeftspacer();
        waitBlockUI();
//        String doctorOne = getUnicalDoctor(null);
//        String doctorTwo = getUnicalDoctor(doctorOne);

//        selectDoctor(doctorOne);
//        selectDoctor(doctorTwo);


//        String firstDoctor = newUnicalDoctor();
//        String secondDoctor = newUnicalDoctor();

//        webDriver.findElement(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();
//        waitBlockUI();
//        webDriver.findElement(By.xpath("//*[contains(text(),'" + secondDoctor + "')]")).click();
//        waitBlockUI();

        //копировать расписание
        waitWhileClickable(copyShedule);
        copyShedule.click();

        webDriver.findElement(By.xpath("//table[@id='copy_selected_grid']/tbody/tr[2]/td[2]")).click();
        webDriver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        webDriver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        List<WebElement> closeBtnList = webDriver.findElements(By.xpath("//span[contains(text(),'Закрыть')]"));
        for (WebElement closeBtn : closeBtnList) {
            try{
                closeBtn.click();
            }
            catch (ElementNotVisibleException ex){}
        }
        webDriver.findElement(By.xpath("//button[@id='finish_wizcopy']/span")).click();
        waitBlockUI();
    }

    public void deleteShedule() throws InterruptedException {//удалить расписание выбранного врача
        Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
        waitBlockUI();

        waitWhileClickable(deleteShedule);
        deleteShedule.click();                     //кнопка удалить расписание
        waitWhileClickable(deleteSheduleBtnWindow);
        deleteSheduleBtnWindow.click();            //подтверждение удаления

        Thread.sleep(1000);
        keyboard.pressKey(Keys.ENTER);

        waitWidgetOverlay();
        waitBlockUI();
    }

    //========
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

    public void setTypeOfReception(WebElement typeOfReception) {
        waitWhileClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        waitWhileClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
        waitWhileClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    public void checkCreateShedule() {
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']"));
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']"));
    }

    public void checkDoNotReceiveDays() {
        waitBlockUI();
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div"))
                .findElements(By.xpath("span[contains(text(),'Врач на больничном')]"));//это название заголовка
        System.out.println("Проверка наличия заголовка форс-мажора");
    }

    public void checkDeletedShedle() {
        if (!webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
        if (!webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
    }

    public String getUnicalDoctor(String docName) {
        waitBlockUI();
        waitWhileClickable(doctorRow);
        List<String> dontUseNames = new ArrayList<String>();
        Collections.addAll(dontUseNames, "Ай Бо Лит", "Ар Ти Шок", "test test testovych", "null");
        dontUseNames.add(docName);


        System.out.println(dontUseNames);

        waitBlockUI();

        //String doctorNameNull = doctorName;
        String doctorStringName = docName;

        List<WebElement> doctorList = webDriver
                .findElement(By.xpath("//table[@id='schw_docprvdgrid1']/tbody"))//наашел таблицу
                .findElements(By.xpath("tr[@role='row'][@tabindex='-1']/td[3]/div/span[1]"));//нашел строки врачей

        for (WebElement doctor : doctorList) {
            int count = 0;
            doctorStringName = doctor.getText();
            //System.out.println("Первый список: " + doctorStringName + " " + count);

            for (WebElement doctorCount : doctorList) {
                String doctorStringName2 = doctorCount.getText();
                //System.out.println("Второй список: " + doctorStringName2 + " " + count);

                if (doctorStringName.equals(doctorStringName2))
                    count++;
                if (count > 1)
                    break;
            }

            if (count == 1 && !dontUseNames.contains(doctorStringName))
                break;
        }
        dontUseNames.add(doctorStringName);//чот не срабатывает
        return doctorStringName;
    }

    //========
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

    public boolean waitLoaderLeftspacer() {
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