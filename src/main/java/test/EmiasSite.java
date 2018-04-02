package test;

import org.openqa.selenium.WebDriver;
import test.moduls.ModuleCallDoctor;
import test.moduls.ModuleMedicalCard;
import test.moduls.ModuleVedenieRaspisaniya;

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

    public ModuleMedicalCard moduleMedicalCard() {
        return new ModuleMedicalCard(webDriver);
    }


}