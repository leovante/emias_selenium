package pages.mis;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.utilities.Waiter;

public class BeforeWork extends BasePage {
    @FindBy(xpath = "//button[@id='btn_create']/span[2]")
    WebElement createShedule;

    @FindBy(xpath = "//a[@id='ddlbusytype-button']/span[2]")
    WebElement ddlbusytypeButton;

    @FindBy(id = "pickTime_nach")
    WebElement pickTime_nach;

    @FindBy(id = "schedule_add_button")
    WebElement schedule_add_button;

    @FindBy(linkText = "Прием на дому (вызов на дом)")
    WebElement priemNaDomu;

    @FindBy(linkText = "Прием по очереди")
    WebElement priemPoOcheredi;

    @FindBy(xpath = "//button[@id='btn_save_schedule']/span")
    WebElement btn_save_schedule;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement pickTime_nachClose;

    @FindBy(id = "pickTime_okon")
    WebElement pickTime_okon;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement pickTime_okonClose;

    public BeforeWork(WebDriver driver) {
        super(driver);
    }

    @Step("Установить время календаря")
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

    @Step("Установить тип приема")
    public void setTypeOfReception(WebElement typeOfReception) {
        waitWhileClickable(ddlbusytypeButton);
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        waitWhileClickable(typeOfReception);
        typeOfReception.click();                     //выбор типа приема
        waitWhileClickable(schedule_add_button);
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    @Step("Создать расписание")
    public void createShedule() throws InterruptedException {
        Waiter.waitAllEmias();

        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String a = "0700", b = "2344";
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
//        Waiter.waitAllEmias();
    }


    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
