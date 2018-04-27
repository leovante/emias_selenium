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
        website.loginPage().enterLoginText("admin");
        website.loginPage().enterPasswordText("11");
        //seleniumDoctor 1
        //seleniumAdmin 1212
        website.loginPage().clickLoginButton();
    }

    @Test// KEYS 1.1
    public void testCreateShedule() throws InterruptedException {
        logger.info("KEYS 1.1: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        website.scheduleDoctors().checkCreateShedule();
        logger.error("KEYS 1.1: Done");
    }

    @Test//KEYS 1.2
    public void testCopyShedule() throws InterruptedException {
        logger.info("KEYS 1.2: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        String docNameTwo = website.scheduleDoctors().getUnicalDoctor(docName);
        website.scheduleDoctors().selectDoctor(docNameTwo);
        website.scheduleDoctors().copyShedule(docName);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().checkCreateShedule();
        website.scheduleDoctors().deleteShedule();
        logger.error("KEYS 1.2: Done");
    }

    @Test//KEYS 1.3
    public void testSetDoNotReceiveDays() throws InterruptedException {
        logger.info("KEYS 1.3: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        website.scheduleDoctors().setDoNotReceiveDays();
        website.scheduleDoctors().checkDoNotReceiveDays();
        logger.error("KEYS 1.3: Done");
    }

    @Test// KEYS 1.4
    public void testDeleteShedule() throws InterruptedException {
        logger.info("KEYS 1.4: Enter doctor's timetable");
        website.emiasPage().clickTimeTable();
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        website.scheduleDoctors().checkCreateShedule();
        website.scheduleDoctors().deleteShedule();
        website.scheduleDoctors().checkDeletedShedle();
        website.scheduleDoctors().deleteShedule();
        logger.error("KEYS 1.4: Done");
    }

    @Test// KEYS 1.5
    public void testSurviveShedule() throws InterruptedException {
        String doctorNull = null;
        logger.info("KEYS 1.5: Enter doctor's timetable");

        //нужно зайти в распсиание приема
        //провертиь что у врача нет записей красного и бледно красного цвета
        //если записи есть, то удаляем все, кроме последней
        //выбираем второго врача
        //проверяем наличие красных и бледных записей
        //если записи есть, то отменяем все
        //проверяем налицие зеленых записей
        //если их нет, выходим на главную, заходим в создать расписание и создаем записи
        //выходим на главную страницу
        //нажимаем перенос записей
        //выбираем первого врача
        //находим красную или бледно красную запись
        //нажимаем на нее
        //нажимаем на перенос записей
        //нажимаем перенести во всплывающем окне
        //нажимаем на врача
        //нажимаем правой кнопкой на запись
        //нажимаем перенести во всплывающем окне
        //выбираем второго врача
        //нажимаем на ячейку в его расписании
        //снимаем галочку с первого врача
        //выбираем второго врача
        //проверяем наличие записи

        website.emiasPage().clickTimeTable();
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        website.scheduleDoctors().selectDoctor(docName);
        String docNameTwo = website.scheduleDoctors().getUnicalDoctor(docName);
        website.scheduleDoctors().selectDoctor(docNameTwo);
        website.scheduleDoctors().deleteShedule();

        website.emiasPage().clickLogoHome();
        website.emiasPage().clickAdmissionSchedule();//расписание приема
        website.scheduleDoctors().selectDoctor(docName);
        website.moduleAdmissionSchedule().createTask();
        website.moduleAdmissionSchedule().checkCreateTask();

        website.emiasPage().clickLogoHome();
        website.moduleTransferRecords().clickDoctor();
        /*
        зайти в создание записей
        найти два уникальных врача и запомнить их имена
        у первого врача удалить всё расписание
          создать новую запись - прием по очереди
          убрать выделение с врача
          выбрать второго врача
          создать новую запись - прием по очереди
        выйти на главную
        зайти в расписание приема, выбрать первого врача
        найти новую запись - прием по очереди и создать запись пациента
        выйти на главную

        зайти в перенос записей
        нажать на первого врача
        нажать на кнопку перенос записей
        выбрать дату и нажать перенести
        нажать на врача
        надать правой кнопкой на запись и выбрать - перенести
        выбрать второго врача
        выбрать первую строку времени для запси
        нажать перенести
        подтвердить всплывающееьокно enter
        снять выделение с первого врача и нажать на второго
        найти перенесенную запись
         */
    }

/*KEYS 1.5 Перенос записей
2. Перешли на вкалдку ""Перенос записей"" :http://emias.mosreg.ru/mis/test_emias/ScheduleWriting/Transfer
3. Выбираем врача у которого есть записи пациентов в расписании(или предварительно записываем пациента на данного врача)"


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

/*
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
*/
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

    private class getUnicalDoctor {


    }
}