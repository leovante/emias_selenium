package steps;

import org.openqa.selenium.WebDriver;

public class Steps {
    WebDriver webDriver;

    public Steps(WebDriver driver) {
        webDriver = driver;
    }

    public ManageShedule manageShedule() {return new ManageShedule(webDriver);}

    public LoginPage login() {return new LoginPage(webDriver);}








}
