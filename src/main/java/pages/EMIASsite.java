package pages;

import org.openqa.selenium.WebDriver;

public class EMIASsite {
    WebDriver webDriver;

    public EMIASsite(WebDriver driver) {
        webDriver = driver;
    }

    public EMIASpage emiasPage() {return new EMIASpage();}

    public LoginPage loginPage(){
        return new LoginPage();
    }

    public CallDoctorPage callDoctorPage() {
        return new CallDoctorPage();
    }
}