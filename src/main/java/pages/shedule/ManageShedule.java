package pages.shedule;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.utilities.Waiter;

import java.util.List;

public class ManageShedule extends BasePage {
    final String doctorNull = null;

    DoctorMethods doctorMethods;

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

    @FindBy(xpath = "//button[@id='btn_copy']/span[2]")
    WebElement copyShedule;

    public ManageShedule(WebDriver driver) {
        super(driver);
    }

    public void createShedule() throws InterruptedException {
        Waiter.waitAllEmias();

        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String a = "2330", b = "2344";
        String c = "2344", d = "2359";
        createShedule.click();

        setTimeCalendar(a, b);
        setTypeOfReception(priemNaDomu);

        setTimeCalendar(c, d);
        setTypeOfReception(priemPoOcheredi);

        waitWhileClickable(btn_save_schedule);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
        Waiter.waitAllEmias();
        Waiter.waitAllEmias();
    }

    public void setNotReceiveDays() {
        Waiter.waitAllEmias();
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();


        String firstDoctor = doctorMethods.getUnicalDoctor2(null);
        driver.findElement(By.xpath("//*[contains(text(),'" + firstDoctor + "')]")).click();
        Waiter.waitAllEmias();

        waitWhileClickable(btn_notReciveDays);
        btn_notReciveDays.click();//задать неприемные дни

        waitWhileClickable(row_doctorOnBoln);
        row_doctorOnBoln.click();//выбрали форс-мажор

        waitWhileClickable(saveBtn);
        saveBtn.click();//нажали сохранить

        keyboard.pressKey(Keys.ENTER);
    }

    public void copyShedule(String docName) throws InterruptedException {
        Waiter.waitAllEmias();
        waitWhileClickable(copyShedule);
        copyShedule.click();

        driver.findElement(By.xpath("//table[@id='copy_selected_grid']/tbody/tr[2]/td[2]")).click();
        driver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        driver.findElement(By.xpath("//button[@id='next_wizcopy']/span")).click();
        List<WebElement> closeBtnList = driver.findElements(By.xpath("//span[contains(text(),'Закрыть')]"));
        for (WebElement closeBtn : closeBtnList) {
            try {
                closeBtn.click();
            } catch (ElementNotVisibleException ex) {
            }
        }
        driver.findElement(By.xpath("//button[@id='finish_wizcopy']/span")).click();
        Waiter.waitAllEmias();
    }

    public void deleteShedule() throws InterruptedException {//удалить расписание выбранного врача
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        Waiter.waitAllEmias();

        waitWhileClickable(deleteShedule);
        deleteShedule.click();                     //кнопка удалить расписание
        waitWhileClickable(deleteSheduleBtnWindow);
        deleteSheduleBtnWindow.click();            //подтверждение удаления

        Thread.sleep(1000);
        keyboard.pressKey(Keys.ENTER);
        Waiter.waitAllEmias();
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

    public void setTypeOfReception(WebElement typeOfReception) {
        waitWhileClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        waitWhileClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
        waitWhileClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    public void verifyNotReceiveDays() {
        Waiter.waitAllEmias();
        driver.findElement(By.xpath("//div[@id='schedule']/div/div/div"))
                .findElements(By.xpath("span[contains(text(),'Врач на больничном')]"));//это название заголовка
        System.out.println("Проверка наличия заголовка форс-мажора");
    }

    public void verifyDeletedShedle() {
        if (!driver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#83B465;border-color:#83B465;color:#FFFFFF']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
        if (!driver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElements(By.xpath("//div[@style='background-color:#FFFF99;border-color:#FFFF99;color:#979797']")).isEmpty()) {
            throw new NullPointerException("Ошибка, Таблица загрузилась!");
        }
    }

    public String getSecondName(String name){
        if(name.contains(" ")){
            name= name.substring(0, name.indexOf(" "));
        }
        return name;
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void verifyCreatedShedule()  throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//*[contains(text(),'23:44 ')]"));
    }
}