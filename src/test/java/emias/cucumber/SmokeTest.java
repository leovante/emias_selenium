package emias.cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/ru/riskmarket/features",
        glue = "ru/riskmarket/steps",
        tags = "@smoketest")

public class SmokeTest
{

    @BeforeClass
    static public void setupTimeout()
    {
        Configuration.timeout = 10000;
        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";*/
    }
}
