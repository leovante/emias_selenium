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

import org.junit.Test;

public class RegressShedule extends TestBase {

    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().copyShedule();
        step.manageShedule().verifyCreatedShedule();
    }

   @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        step.manageShedule().setNotReciveDays();
        step.manageShedule().verifyNotReciveDays();
    }

    @Test//KEYS 1.4
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
        step.manageShedule().deleteShedule();
        step.manageShedule().verifyDeletedShedule();
    }

    @Test//KEYS 1.5
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createTwoShedule();
        step.admissionSchedule().createRecord();
        step.transferRecords().trancRecord();
        step.transferRecords().verifyTransferShedule();
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