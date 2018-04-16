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

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.EmiasSite;
import org.apache.log4j.Logger;

public class EMIAStest {
    WebDriver webDriver;
    EmiasSite website;
    WebDriverWait wait;
    Logger logger;

    @Before
    public void setUp() {
        logger = Logger.getLogger("emias_selenium");
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.setLevel(Level.FATAL);
//        LoggingPreferences logs = new LoggingPreferences();
//        logs.enable(LogType.BROWSER, Level.ALL);
//        logs.enable(LogType.CLIENT, Level.ALL);
//        logs.enable(LogType.DRIVER, Level.ALL);
//        logs.enable(LogType.PERFORMANCE, Level.ALL);
//        logs.enable(LogType.PROFILER, Level.ALL);
//        logs.enable(LogType.SERVER, Level.ALL);
//
//        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
//        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 60, 500);
        website = new EmiasSite(webDriver);
        //webDriver.manage().window().maximize();
        webDriver.get("http://mis.softrust.ru/whc/Home");
        logger.info("Step 1: Enter login");
        website.loginPage().enterLoginText("admin");
        logger.info("Step 2: Enter password");
        website.loginPage().enterPasswordText("11");
        logger.info("Step 3: Press Login Button");
        website.loginPage().clickLoginButton();
        logger.fatal("Before: Done");
    }

    @Test// KEYS 1.1
    public void testCreateDoctorTimeTables() throws InterruptedException {
        logger.info("KEYS 1.1: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        website.scheduleDoctors().createSheadle();
        website.scheduleDoctors().checkCreateSheadle();
        logger.error("KEYS 1.1: Done");
    }

    @Test//KEYS 1.2
    public void testCopyDoctorTimeTables() throws InterruptedException {
        logger.info("KEYS 1.2: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        website.scheduleDoctors().createSheadle();
        website.scheduleDoctors().copySheadle();
        website.scheduleDoctors().checkCreateSheadle();
    }

    @Test//KEYS 1.3
    public void testSetDoNotReceiveDays() throws InterruptedException {
        logger.info("KEYS 1.3: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        website.scheduleDoctors().setDoNotReceiveDays();
        website.scheduleDoctors().checkDoNotReceiveDays();
        //website.scheduleDoctors().checkCreateSheadle();
    }



/*KEYS 1.3 задать неприемные дни
1. Выбрать врача
2. Выбать причину
3. Указать начало и окончание периода
4. Нажать ""Сохранить""
5. Подтвердить удаление расписания, если оно есть.
*/

/*KEYS 1.4 удаление расписания для врача
1. Выбрать врача, чье расписание требуется удалить
2. Нажать кнопку «Удалить расписание»
3. Задать период в сетке расписания для удаления в окне «Удаление расписания»
4. Задать начальную дату
5. Задать конечную дату
6. Нажать кнопку «Удалить»
7. При наличии в удаляемом расписании записей на прием перенести их
*/

/*KEYS 1.5 Перенос записей
1. Осуществляем поиск врача
    - Выбрать критерий поиска врача, например, ФИО
    - Ввести в поле поиска данные, по которым будет производиться поиск врача (для поиска ввести не менее трех символов)
    - Нажать кнопку «Найти»
2. Нажимаем ""Перенос записей""
3. Указываем начала и конец интервала
4. Выбираем врача
5. Нажима ПКМ на запись которую будем переносить и выюираем ""Перенести запись""
6. Указываем период расписания на которое будет переноситься запись
7. Выбираем врача и ячейку на которую будем переносить запись
8. Нажимаем ""Перенести""
*/

    @Test//
    public void testSearchCallDoctor() throws InterruptedException {
        logger.info("KEYS 1: Search call calldoctor page");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().waitForSearchResults();
        logger.info("KEYS 1: Done");
    }

    @Test//
    public void testSearchCallDoctorWithFilter() throws InterruptedException {
        logger.info("KEYS 2: Search call calldoctor page with filter");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().filterCallDoctor();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().verificationTableGridNull();
        logger.info("KEYS 2: Done");
    }

    @Test//
    public void testCreateNewCall_ExistingMkab() throws InterruptedException {
        logger.info("KEYS 4: Enter CallDoctor");
        website.emiasPage().clickCallDoctorButton();
        website.moduleCallDoctor_CreateCall().createNewCall_ExistingMkab();
        logger.error("KEYS 4: Done");
    }
/*    @Test// 5
    public void  testCreateNewMkab() throws InterruptedException {
        logger.info("KEYS 5: Enter in CallDoctor");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().createNewCall();
        logger.error("KEYS 5: Done");
    }
*/

    @After
    public void tearDown() {
        Logs logs = webDriver.manage().logs();
        LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
        if (webDriver != null)
            webDriver.quit();

        logger.info("After: Done\n");
    }
}