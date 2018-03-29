package pages.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Timer;
import java.util.List;

public class ModuleVedenieRaspisaniya {
    private WebDriver webDriver;
    private WebDriverWait wait;


    public ModuleVedenieRaspisaniya(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void sozdanieRaspisaniya() throws InterruptedException {
        if (!webDriver.findElements(By.id("loaderleftspacer")).isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.id("loaderleftspacer"))));
        }
        //получаем список врачей
        //webDriver.findElement(By.linkText(bookTitle)).click();
        List<WebElement> doctorList1 = webDriver.findElement(By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table"))
                .findElements(By.xpath("//tr[@role='row']") ); //(css = "input[value='title']") //table[@id='call_doc_house_grid']/tbody/tr[2]/td

        webDriver.findElement(By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table"));

        List<WebElement> doctorList = webDriver.findElements(By.xpath("//span[@style='font-weight: bold;']"));
        List<WebElement> doctorList3 = webDriver.findElements(By.xpath("//tr[@role='row']"));
        // "tr[role='row']" //By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table")

        for (WebElement oneDoctor : doctorList) {
            WebElement doctor = oneDoctor.findElement(By.className("cbox")); //id = jqg_schw_docprvdgrid1_1078
            doctor.click();
            //нажимаем на создать расписание
            webDriver.findElement(By.xpath("//button[@id='btn_create']/span[2]")).click();
            Thread.sleep(5000);
            webDriver.findElement(By.id("pickTime_nach")).sendKeys("0700");          //нажимаем на поле начала интервала
            //webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();             //нажали закрыть календарь
            webDriver.findElement(By.id("pickTime_okon")).sendKeys("0715");          //нажимаем на поле окончание интервала
            //webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();             //нажали закрыть календарь
            webDriver.findElement(By.xpath("//a[@id='ddlbusytype-button']/span[2]")).click();       //нажимаем на выпадающий список тип приема
            webDriver.findElement(By.linkText("Прием здорового ребенка")).click();                  //выбор подменю
            webDriver.findElement(By.id("schedule_add_button")).click();                            //нажали кнопу добавить
            webDriver.findElement(By.xpath("//button[@id='btn_save_schedule']/span")).click();      //нажимаем кнопку сохранить
            webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();            //подтверждаем предупреждение кнопкой - да

            if (wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[24]/div[3]/div/button/span"))) != null) {
                webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();
                //нажимаем отмена
                webDriver.findElement(By.xpath("//div/button[3]/span")).click();
                break;
            }
            //дальше нужно перейти на другого врача из списка и сделать всё тоже самое
        /*     */
            //после создания записи, нужно проверить что появилась ячейка на это время с этим цветом
        }
        WebElement a = webDriver.findElement(By.linkText("07:00 "));
        System.out.println("проверка содержимого а");
    }
}