package test.moduls;

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

public class ModuleVedenieRaspisaniya {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div/div")
    WebElement poleZayavok;

    public ModuleVedenieRaspisaniya(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void sozdanieRaspisaniya() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(doctorRow));
        List<WebElement> doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
        for (WebElement oneDoctor : doctorList) {
            oneDoctor.click();
/*
            Thread.sleep(3000);//это тут временно
            //нажимаем на создать расписание
            webDriver.findElement(By.xpath("//button[@id='btn_create']/span[2]")).click();
            Thread.sleep(3000);
            webDriver.findElement(By.id("pickTime_nach")).sendKeys("0700");          //нажимаем на поле начала интервала
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            //webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();             //нажали закрыть календарь
            Thread.sleep(1000);
            webDriver.findElement(By.id("pickTime_okon")).sendKeys("0715");          //нажимаем на поле окончание интервала
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            //webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();             //нажали закрыть календарь
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//a[@id='ddlbusytype-button']/span[2]")).click();       //нажимаем на выпадающий список тип приема
            Thread.sleep(1000);
            webDriver.findElement(By.linkText("Прием здорового ребенка")).click();                  //выбор подменю
            Thread.sleep(1000);
            webDriver.findElement(By.id("schedule_add_button")).click();                            //нажали кнопу добавить
            Thread.sleep(3000);
            webDriver.findElement(By.xpath("//button[@id='btn_save_schedule']/span")).click();      //нажимаем кнопку сохранить
            Thread.sleep(3000);

            Keyboard keyboard = ((HasInputDevices) webDriver).getKeyboard();
            keyboard.pressKey(Keys.ENTER);

            Thread.sleep(1000);
*/
            break;
        }
        Thread.sleep(2000);
        WebElement taskArea = webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//div[@style='background-color:#66CCCC;border-color:#66CCCC;color:#FFFFFF']"));
        System.out.println("проверка ячейки с этим цветом");

        taskArea.click();
        Actions action = new Actions(webDriver);
        action.contextClick(taskArea).perform();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//div[id='jqContextMenu']"));
                //.findElement(By.xpath("//li[id='sch_del_menu']")).click();

        //ТУТ НУЖНО УДАЛИТЬ ЭТО РАСПИСАНИЕ
    }
}