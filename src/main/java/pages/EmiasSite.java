package pages;

import org.openqa.selenium.WebDriver;
import pages.moduls.ModuleCallDoctor;
import pages.moduls.ModuleVedenieRaspisaniya;

public class EmiasSite {
    WebDriver webDriver;

    public EmiasSite(WebDriver driver) {
        webDriver = driver;
    }

    public EmiasMainPage emiasPage() {return new EmiasMainPage(webDriver);}

    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }

    public ModuleCallDoctor callDoctorPage() {
        return new ModuleCallDoctor(webDriver);
    }

    public ModuleVedenieRaspisaniya scheduleDoctors() {
        return new ModuleVedenieRaspisaniya(webDriver);
    }
}