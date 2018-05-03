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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.CleanDoctorTimeTableSQL;
import steps.Steps;

public class RegressShedule {
    private WebDriver webDriver;
    Steps step;
    WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, 60, 500);
        step = new Steps(webDriver);
        step.login().loginEmias();
    }

/*
    @Test// KEYS 0.0
    public void testProject() throws InterruptedException, ClassNotFoundException {
        CleanDoctorTimeTableSQL sqlMethod = new CleanDoctorTimeTableSQL();
        String name = "Аблова";
        sqlMethod.deleteShedule(name);
    }
*/

    @Test// KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        step.mainPage().clickManageShedule();
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException {
        step.mainPage().clickManageShedule();
        step.manageShedule().copyShedule();
    }

/*    @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        website.mainPage().clickManageShedule();
        step.manageShedule().setNotReciveDays();
        step.manageShedule().verifyNotReciveDays();
    }

    @Test// KEYS 1.4
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        website.mainPage().clickManageShedule();
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
        step.manageShedule().deleteShedule();
        step.manageShedule().verifyDeletedShedule();
    }*/

    @Test// KEYS 1.5
    public void surviveShedule() throws InterruptedException {
        String doctorNull = null;

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

/*        website.mainPage().clickManageShedule();
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        website.scheduleDoctors().selectDoctor(docName);
        String docNameTwo = website.scheduleDoctors().getUnicalDoctor(docName);
        website.scheduleDoctors().selectDoctor(docNameTwo);
        website.scheduleDoctors().deleteShedule();

        website.mainPage().clickLogoHome();
        website.mainPage().clickAdmissionSchedule();//расписание приема
        website.scheduleDoctors().selectDoctor(docName);
        website.moduleAdmissionSchedule().createRecord();
        website.moduleAdmissionSchedule().verifyCreatedRecord();

        website.mainPage().clickLogoHome();
        website.moduleTransferRecords().clickDoctor();*/
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

    @After
    public void tearDown() {
        Logs logs = webDriver.manage().logs();
        LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
        if (webDriver != null)
            webDriver.quit();
    }
}