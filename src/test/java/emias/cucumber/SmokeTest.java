package emias.cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
//        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "emias/calldoctor/features",
        glue = "emias/calldoctor/steps",
        tags = "@AcceptanceTest",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE)

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
