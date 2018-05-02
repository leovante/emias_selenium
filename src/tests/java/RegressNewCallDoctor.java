import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Leovante on 5/2/2018.
 */
public class RegressNewCallDoctor {


    private void waitForAngular() {

/*
        final String script =
                "var callback = arguments[arguments.length - 1];\n" +
                "var rootSelector = \'body\';\n" +
                "var el = document.querySelector(rootSelector);\n" +
                "\n" +
                "try {\n" +
                "    if (angular) {\n" +
                "        window.angular.getTestability(el).whenStable(callback);\n" +
                "    }\n" +
                "    else {\n" +
                "        callback();\n" +
                "    }\n" +
                "} catch (err) {\n" +
                "    callback(err.message);\n" +
                "}";

        ((JavascriptExecutor) driver).executeAsyncScript(script, new Object[0]);



        Yes; protractor is nothing more than a syntax wrapper for Selenium with a few methods that hook into the JavaScript callbacks like angular.getTestability.
        By copying the JavaScript code out of protractor, or ngWebDriver, etc. and into your project's executeScript or executeAsyncScript,
        you can modify your Selenium framework to implement watiForAngular and other Protractor methods, eliminating the need for Protractor.

        https://github.com/caarlos0-graveyard/jProtractor
        https://github.com/paul-hammant/ngWebDriver



*/
    }

}
