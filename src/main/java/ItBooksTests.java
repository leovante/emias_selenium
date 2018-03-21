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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;
//1
public class ItBooksTests {
    WebDriver webDriver;
    BooksSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);
        website = new BooksSite(webDriver);

        webDriver.get("http://it-ebooks.info/");

        System.out.println("Step 1: Switch to search by title");
        website.mainPage().switchSearchToTitle();

        System.out.println("Step 2: Enter search phrase");
        website.mainPage().enterSearchableText("automation");

        System.out.println("Step 3: Click Search Button");
        website.mainPage().clickSearchButton();

        System.out.println("Step 4: Wait For search Results");
        website.searchResultsPage().waitForSearchResults();
    }

    @Test
    public void testSearshBookUrl() {
        System.out.println("Check url");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=automation&type=title"));
    }

    @Test
    public void testBooksSearch() {
        System.out.println("Check search results");
        Assert.assertTrue(
                webDriver.findElement(By.className("top"))
                        //.findElement(By.tagName("table")) //� �������� ��� ����� ���������
                        .findElements(By.tagName("tr"))
                        .size() == 10);
    }

    @Test
    public void testOpenBookInfoFromSearch(){
        System.out.println("Step 5: Open Book Info");
        website.searchResultsPage().openBookFromResultsBy("Home Automation with Intel Galileo");

        System.out.println("Step 6: Wait for page load");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[itemprop='name']")));
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}