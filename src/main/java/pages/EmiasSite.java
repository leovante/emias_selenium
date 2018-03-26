package pages;

import org.openqa.selenium.WebDriver;
import pages.moduls.CallDoctorPage;

public class EmiasSite {
    WebDriver webDriver;

    public EmiasSite(WebDriver driver) {
        webDriver = driver;
    }

    public EmiasMainPage emiasPage() {return new EmiasMainPage(webDriver);}

    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }

    public CallDoctorPage callDoctorPage() {
        return new CallDoctorPage(webDriver);
    }
}