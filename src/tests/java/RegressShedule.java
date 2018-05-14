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

import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTimeTableSQL;
import pages.utilities.Waiter;

public class RegressShedule extends TestBase {
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        page.mainPage().manageSheduleBtn();
        String docFullName = page.doctorOperators().getUnicalDoctor2(null);
        String secondName = page.manageShedule().getSecondName(docFullName);
        sql.deleteShedule(secondName);
        page.doctorOperators().selectDoctor(docFullName);
        page.manageShedule().createShedule();

        page.manageShedule().verifyDeletedShedle();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException, ClassNotFoundException {
        String firstDoctor = page.doctorOperators().getUnicalDoctor2(null);
        String secondDoctor = page.doctorOperators().getUnicalDoctor2(firstDoctor);
        String second_doctor_fam = page.manageShedule().getSecondName(secondDoctor);
        sql.deleteShedule(second_doctor_fam);

        page.mainPage().manageSheduleBtn();
        page.doctorOperators().selectDoctor(firstDoctor);
        page.manageShedule().createShedule();
        page.doctorOperators().selectDoctor(secondDoctor);
        page.manageShedule().copyShedule(firstDoctor);
        page.doctorOperators().selectDoctor(firstDoctor);

        page.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        page.mainPage().manageSheduleBtn();
        page.manageShedule().setNotReceiveDays();

        page.manageShedule().verifyDeletedShedle();
    }

    @Test//KEYS 1.4
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        page.mainPage().manageSheduleBtn();
        String first_doctor_fullname = page.doctorOperators().getUnicalDoctor2(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorOperators().getUnicalDoctor2(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        sql.deleteShedule(first_doctor_fam);
        sql.deleteShedule(second_doctor_fam);

        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.doctorOperators().selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule();
        page.manageShedule().deleteShedule();
        page.manageShedule().verifyDeletedShedle();
    }

    @Test//KEYS 1.5
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
        page.mainPage().manageSheduleBtn();
        String first_doctor_fullname = page.doctorOperators().getUnicalDoctor2(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorOperators().getUnicalDoctor2(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        sql.deleteShedule(first_doctor_fam);
        sql.deleteShedule(second_doctor_fam);

        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.doctorOperators().selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.mainPage().logoHomeBtn();
        page.mainPage().admissionScheduleBtn();
        page.admissionSchedule().createRecord();

        driver.get("http://emias.mosreg.ru/mis/test_emias/ScheduleWriting/Transfer");
        Waiter.waitAllEmias();
        first_doctor_fullname = page.doctorOperators().getUnicalDoctor2(null);
        second_doctor_fullname = page.doctorOperators().getUnicalDoctor2(first_doctor_fullname);
        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.transferRecords().trancRecord(second_doctor_fullname);
        page.doctorOperators().selectDoctor(first_doctor_fullname);
        page.doctorOperators().selectDoctor(second_doctor_fullname);

        page.transferRecords().verifyTransferShedule();
    }

//    private static void addJQuery (JavascriptExecutor js) {
//        String script = "";
//        boolean needInjection = (Boolean)(js.executeScript("return this.$ === undefined;"));
//        if(needInjection) {
//            URL u = Resources.getResource("jquery.js");
//            try {
//                script = Resources.toString(u, Charsets.UTF_8);
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//            js.executeScript(script);
//        }
//    }

//    @Before
//    public void setUp() throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//        webDriver = new ChromeDriver(options);
//        step = new Steps(webDriver);
//        step.loginPage().loginEmias();
//    }
//
//    @After
//    public void tearDown() {
//        if (webDriver != null)
//            webDriver.quit();
//    }
}