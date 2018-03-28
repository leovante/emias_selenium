/*eto pattern proektirovania facad
*echo patterni
* singleton - bil tolko odin instance odnogo klassa po vsey sisteme
* bilder - sobrat config testa. Sobrat' nogo url s raznimi parametrami u kazhdogo
* bridge
* proxy
* factory method -
* factory class
*patternov mnogo i oni delyatca po tipam
* page object
*
*
*
*
* */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EmiasSite;

import java.util.List;

public class EMIAStest {
    WebDriver webDriver;
    EmiasSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 60, 500);
        website = new EmiasSite(webDriver);

        webDriver.get("http://mis.softrust.ru/whc/Home");
        //System.out.println("привет");
        System.out.println("Step 1: Enter login");
        website.loginPage().enterLoginText("admin");

        System.out.println("Step 2: Enter password");
        website.loginPage().enterPasswordText("11");

        System.out.println("Step 3: Press Login Button");
        website.loginPage().clickLoginButton();
    }

    @Test
    public void testCallDoctorPage() throws InterruptedException {
        System.out.println("KEYS 1: Enter CallDoctor Page");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().waitForSearchResults();
    }

    @Test
    public void testCallDoctorPageWithFilter() throws InterruptedException {
        System.out.println("KEYS 2: Enter CallDoctor Page with filter");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().filterCallDoctorSearchBtn();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().verificationTableGridNull();
    }

    @Test
    public void  testVedenieRaspisaniya() throws InterruptedException {
        System.out.println("KEYS 3: Enter in doctor's schedule and create task");


        //заходим в расписание
        webDriver.findElement(By.xpath("//div[@id='Portlet_2']/div[2]/div[2]/a/span")).click();
        //получаем список врачей


        //webDriver.findElement(By.linkText(bookTitle)).click();
        List<WebElement> doctorList = webDriver.findElement(By.id("schw_docprvdgrid1"))
                .findElements(By.tagName("tr"));
        for (WebElement oneDoctor : doctorList) {
            WebElement doctor = oneDoctor.findElement(By.tagName("role"));
        //тут выбрать врача и ссылку на метод который делает расписание

//            if (doctor.getLocation() getTagName("tr").contains("row")) {
//                doctor.click();
//                break;
//            }

        }

        //нажимаем на флажок врача
        webDriver.findElement(By.id("jqg_schw_docprvdgrid1_4398")).click();
        //нажимаем на создать расписание
        webDriver.findElement(By.xpath("//button[@id='btn_create']/span[2]")).click();
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

        //тут нужно сделать условие, если появилось окошко с ошибкой,то нажимаем - закрыть
        webDriver.findElement(By.xpath("//div[24]/div[3]/div/button/span")).click();
        //нажимаем отмена
        webDriver.findElement(By.xpath("//div/button[3]/span")).click();
        //дальше нужно перейти на другого врача из списка и сделать всё тоже самое
        /*     */
        //после создания записи, нужно проверить что появилась ячейка на это время с этим цветом

/*
-открыть емиас http://emias.mosreg.ru/mis/test_emias
-ввести логин и пароль
-нажать ведение расписания
-выбрать врача нажатием галочки (врач без расписания)
-нажать кнопку создать расписание
-нажать на поле дата
-в календаре ничего не выбирать
-начало интервала выбрать как следующий час от текущего времени.
-окончание интервала на 15 мин после начала
-изменить время приема
-выбрать без разбивки на интервалы
-выбрать живая очередь
-выбрать из выпадающего списка тип приема - прием детей до одного года
-нажать добавить в правой верхней части окна
-нажать кнопку сохранить
-во всплывающем окне нажать кнопку - да
-найти ячейку по времени и проверить что она изменила цвет на фиолетовый.
*/
    }
    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}