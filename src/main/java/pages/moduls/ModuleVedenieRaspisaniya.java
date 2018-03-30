package pages.moduls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath="//tr[@role='row'][@tabindex='-1']")
    WebElement doctorRow;

    @FindBy(xpath="//div[24]/div[3]/div/button/span")
    WebElement oknoPodtverzhdeniya;

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
        //получаем список врачей
        //webDriver.findElement(By.linkText(bookTitle)).click();
//        List<WebElement> doctorList1 = webDriver.findElement(By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table"))
//                .findElements(By.xpath("//tr[@role='row']") ); //(css = "input[value='title']") //table[@id='call_doc_house_grid']/tbody/tr[2]/td
//        List<WebElement> doctorList5 = webDriver.findElement(By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table"))
//                .findElements(By.tagName("tr") ); //(css = "input[value='title']") //table[@id='call_doc_house_grid']/tbody/tr[2]/td
//        List<WebElement> doctorList6 = webDriver.findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"))
//                .findElements(By.tagName("tr") ); //(css = "input[value='title']") //table[@id='call_doc_house_grid']/tbody/tr[2]/td
//        List<WebElement> doctorList10 = webDriver.findElements(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody/tr"));
//        List<WebElement> doctorList11 = webDriver.findElements(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']/tbody"));
        wait.until(ExpectedConditions.elementToBeClickable(doctorRow));
        List<WebElement> doctorList = webDriver.findElements(By.xpath("//tr[@role='row'][@tabindex='-1']"));
//        List<WebElement> doctorList9 = webDriver.findElements(By.xpath("//input[@role='checkbox'][@type='checkbox'][@class='cbox']"));
//        List<WebElement> doctorList8 = webDriver.findElement(By.xpath("//table[@id='schw_docprvdgrid1'][@role='grid']"))
//                .findElements(By.tagName("tr") ); //(css = "input[value='title']") //table[@id='call_doc_house_grid']/tbody/tr[2]/td
//        List<WebElement> doctorList2 = webDriver.findElements(By.xpath("//div[@id='gview_schw_docprvdgrid1']/div[3]/div/table"));
//        List<WebElement> doctorList = webDriver.findElements(By.xpath("//span[@style='font-weight: bold;']"));
//        List<WebElement> doctorList3 = webDriver.findElements(By.xpath("//tr[@role='row']"));
//        List<WebElement> doctorList4 = webDriver.findElements(By.tagName("tr"));
        for (WebElement oneDoctor : doctorList) {
//            WebElement doctor = oneDoctor.findElement(By.className("cbox")); //id = jqg_schw_docprvdgrid1_1078
            oneDoctor.click();
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



            //span[count(. | //*[contains(.,'Да')]) = count(//*[contains(.,'Да')])]
            // [count(. // | //*[contains(@class,'ui-button-text')]) = count(//*[contains(@class,'ui-button-text')])]

//            webDriver.findElement(By.tagName("span[count(. | //*[contains(.,'Да')])"));
//            webDriver.findElement(By.linkText("count(//*[contains(.,'Да')])"));
            //webDriver.findElement(By.xpath("//span[@class='ui-button-text]")).findElement(By.linkText("Да"));
                    //"count(//*[contains(.,'Да')])"));

            //List<WebElement> yesList = webDriver.findElements(By.linkText("Предупреждение"));
            Keyboard keyboard=((HasInputDevices) webDriver).getKeyboard();
            keyboard.pressKey(Keys.ENTER);

            // [count(. // | //*[contains(@class,'ui-button-text')]) = count(//*[contains(@class,'ui-button-text')])]

            /*webDriver.switchTo().frame(webDriver.findElement(By.linkText("Да")));*/
            //wait.until(ExpectedConditions.visibilityOf(oknoPodtverzhdeniya));
            /*webDriver.findElement(By.linkText("Да")).click();*/
            //wait.until(ExpectedConditions.stalenessOf(webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span"))));
            //wait.until(ExpectedConditions.elementToBeClickable(oknoPodtverzhdeniya));
            Thread.sleep(3000);
/*
            if (wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[24]/div[3]/div/button/span"))) != null) {
                webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();
                //нажимаем отмена
                webDriver.findElement(By.xpath("//div/button[3]/span")).click();
                break;
            }
*/
            //дальше нужно перейти на другого врача из списка и сделать всё тоже самое
        /*     */
            //после создания записи, нужно проверить что появилась ячейка на это время с этим цветом
        }
        WebElement a = webDriver.findElement(By.linkText("07:00 "));
        System.out.println("проверка содержимого а");
    }
}