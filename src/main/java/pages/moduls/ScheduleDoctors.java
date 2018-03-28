package pages.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ScheduleDoctors {
    private WebDriver webDriver;
    private WebDriverWait wait;


    public ScheduleDoctors(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void sozdanieRaspisaniya() throws InterruptedException {
        //получаем список врачей
        //webDriver.findElement(By.linkText(bookTitle)).click();
        List<WebElement> doctorList = webDriver.findElement(By.id("schw_docprvdgrid1"))
                .findElements(By.tagName("tr"));
        for (WebElement oneDoctor : doctorList) {
            WebElement doctor = oneDoctor.findElement(By.tagName("role"));
            doctor.click();
            //нажимаем на создать расписание
            webDriver.findElement(By.xpath("//button[@id='btn_create']/span[2]")).click();
            sozdatNovoeRaspisanie();
            if (wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[24]/div[3]/div/button/span"))) != null)
            {
                webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();
                //нажимаем отмена
                webDriver.findElement(By.xpath("//div/button[3]/span")).click();
                break;
            }


        //дальше нужно перейти на другого врача из списка и сделать всё тоже самое
        /*     */
        //после создания записи, нужно проверить что появилась ячейка на это время с этим цветом
        }
    }

    public void sozdatNovoeRaspisanie(){
        //нажимаем на поле начала интервала
        webDriver.findElement(By.id("pickTime_nach")).click();
        //нажали закрыть календарь
        webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        //нажимаем на поле окончание интервала
        webDriver.findElement(By.id("pickTime_okon")).click();
        //нажали закрыть календарь
        webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        //нажимаем на выпадающий список тип приема
        webDriver.findElement(By.xpath("//a[@id='ddlbusytype-button']/span[2]")).click();
        //выбор подменю
        webDriver.findElement(By.id("ui-selectmenu-item-113")).click();
        //нажали кнопу добавить
        webDriver.findElement(By.id("schedule_add_button")).click();
        //нажимаем кнопку сохранить
        webDriver.findElement(By.xpath("//button[@id='btn_save_schedule']/span")).click();
        //подтверждаем предупреждение кнопкой - да
        webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();
    }
}
