package pages.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SwitchToPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void switchToPage() {
        String mainWindowHandle = driver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
    }


}
