package test;

import org.openqa.selenium.WebDriver;
import test.moduls.ModuleCallDoctor;
import test.moduls.ModuleCallDoctor_CreateCall;
import test.moduls.ModuleMedicalCard;
import test.moduls.ModuleTimeTable;

public class EmiasSite {
    WebDriver webDriver;

    public EmiasSite(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage emiasPage() {return new MainPage(webDriver);}

    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }

    public ModuleCallDoctor callDoctorPage() {
        return new ModuleCallDoctor(webDriver);
    }

    public ModuleTimeTable scheduleDoctors() {
        return new ModuleTimeTable(webDriver);
    }

    public ModuleMedicalCard moduleMedicalCard() {
        return new ModuleMedicalCard(webDriver);
    }

    public ModuleCallDoctor_CreateCall moduleCallDoctor_CreateCall() {
        return new ModuleCallDoctor_CreateCall(webDriver);
    }


}