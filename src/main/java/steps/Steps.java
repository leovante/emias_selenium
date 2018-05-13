package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Steps extends BasePage {

    public Steps(WebDriver driver) {
        super(driver);
    }

    public ManageShedule manageShedule() {
        ManageShedule manageShedule = PageFactory.initElements(driver, ManageShedule.class);
        return manageShedule;
    }

    public AdmissionSchedule admissionSchedule() {
        AdmissionSchedule admissionSchedule = PageFactory.initElements(driver, AdmissionSchedule.class);
        return admissionSchedule;
    }

    public TransferRecords transferRecords() {
        TransferRecords transferRecords = PageFactory.initElements(driver, TransferRecords.class);
        return transferRecords;
    }

    public LoginPage loginPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public CallDoctor callDoctor() {
        CallDoctor callDoctor = PageFactory.initElements(driver, CallDoctor.class);

        return callDoctor;
    }


}
