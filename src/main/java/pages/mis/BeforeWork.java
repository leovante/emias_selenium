package pages.mis;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class BeforeWork extends AbstractPage {
    SelenideElement createShedule = $(By.xpath("//button[@id='btn_create']/span[2]"));
    SelenideElement ddlbusytypeButton = $(By.xpath("//a[@id='ddlbusytype-button']/span[2]"));
    SelenideElement pickTime_nach = $(By.id("pickTime_nach"));
    SelenideElement schedule_add_button = $(By.id("schedule_add_button"));
    SelenideElement priemNaDomu = $(By.linkText("Прием на дому (вызов на дом)"));
    SelenideElement priemPoOcheredi = $(By.linkText("Прием по очереди"));
    SelenideElement btn_save_schedule = $(By.xpath("//button[@id='btn_save_schedule']/span"));
    SelenideElement pickTime_nachClose = $(By.xpath("(//button[@type='button'])[2]"));
    SelenideElement pickTime_okon = $(By.id("pickTime_okon"));
    SelenideElement pickTime_okonClose = $(By.xpath("(//button[@type='button'])[2]"));

    public BeforeWork() {
    }

    @Step("установить время календаря")
    public void setTimeCalendar(String a, String b) throws InterruptedException {
        pickTime_nach.setValue(a);          //нажимаем на поле начала интервала
        pickTime_nachClose.click();
        Thread.sleep(500);
        pickTime_okon.setValue(b);          //нажимаем на поле окончание интервала
        pickTime_okonClose.click();      //нажали закрыть календарь
    }

    @Step("установить тип приема")
    public void setTypeOfReception(WebElement typeOfReception) {
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        typeOfReception.click();                     //выбор типа приема
        schedule_add_button.click();                 //нажали кнопу добавить
    }

    @Step("создать расписание")
    public void createShedule() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String a = "0700", b = "2344";
        String c = "2344", d = "2359";
        createShedule.click();
        setTimeCalendar(a, b);
        setTypeOfReception(priemNaDomu);
        setTimeCalendar(c, d);
        setTypeOfReception(priemPoOcheredi);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
    }
}