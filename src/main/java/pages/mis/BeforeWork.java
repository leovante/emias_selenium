package pages.mis;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class BeforeWork extends AbstractPage {
    @FindBy(xpath = "//button[@id='btn_create']/span[2]")
    @CacheLookup
    WebElement createShedule;

    @FindBy(xpath = "//a[@id='ddlbusytype-button']/span[2]")
    @CacheLookup
    WebElement ddlbusytypeButton;

    @FindBy(id = "pickTime_nach")
    @CacheLookup
    WebElement pickTime_nach;

    @FindBy(id = "schedule_add_button")
    @CacheLookup
    WebElement schedule_add_button;

    @FindBy(linkText = "Прием на дому (вызов на дом)")
    @CacheLookup
    WebElement priemNaDomu;

    @FindBy(linkText = "Прием по очереди")
    @CacheLookup
    WebElement priemPoOcheredi;

    @FindBy(xpath = "//button[@id='btn_save_schedule']/span")
    @CacheLookup
    WebElement btn_save_schedule;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    @CacheLookup
    WebElement pickTime_nachClose;

    @FindBy(id = "pickTime_okon")
    @CacheLookup
    WebElement pickTime_okon;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    @CacheLookup
    WebElement pickTime_okonClose;

    public BeforeWork(WebDriver driver) {
        super(driver);
    }

    @Step("установить время календаря")
    public void setTimeCalendar(String a, String b) throws InterruptedException {
        waitClickable(pickTime_nach);
        pickTime_nach.sendKeys(a);          //нажимаем на поле начала интервала
        waitClickable(pickTime_nachClose);
        pickTime_nachClose.click();
        Thread.sleep(500);
        waitClickable(pickTime_okon);
        pickTime_okon.sendKeys(b);          //нажимаем на поле окончание интервала
        waitClickable(pickTime_okonClose);
        pickTime_okonClose.click();      //нажали закрыть календарь
    }

    @Step("установить тип приема")
    public void setTypeOfReception(WebElement typeOfReception) {
        waitClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        waitClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
        waitClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    @Step("создать расписание")
    public void createShedule() throws InterruptedException {
        waitAllEmias();

        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String a = "0700", b = "2344";
        String c = "2344", d = "2359";
        createShedule.click();

        setTimeCalendar(a, b);
        setTypeOfReception(priemNaDomu);

        setTimeCalendar(c, d);
        setTypeOfReception(priemPoOcheredi);

        waitClickable(btn_save_schedule);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
        waitAllEmias();
//        Waiter.waitAllEmias();
    }
}