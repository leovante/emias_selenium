import org.junit.Ignore;
import org.junit.Test;

//
public class RegressCallDoctor extends TestBase {

    @Ignore
    @Test// KEYS 0.0
    public void testProject() throws InterruptedException, ClassNotFoundException {
        //кейс для быстрых проверочек
    }

    @Test// KEYS 1.1
    public void testCreateRecord() throws InterruptedException, ClassNotFoundException {
    step.callDoctor().createCall();

    }

//    @Before
//    public void setUp() throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//        webDriver = new ChromeDriver(options);
//        //webDriver.manage().window().maximize();
//        step = new Steps(webDriver);
//        step.loginPage().loginEmias();
//    }
//
//    @After
//    public void tearDown() {
////        if (webDriver != null)
////            webDriver.quit();
//    }
}
