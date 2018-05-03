package steps;

        import org.openqa.selenium.WebDriver;
        import steps.shedule.AdmissionSchedule;
        import steps.shedule.ManageShedule;
        import steps.shedule.TransferRecords;

public class Steps {
    WebDriver webDriver;

    public Steps(WebDriver driver) {
        webDriver = driver;
    }

    public ManageShedule manageShedule() {
        return new ManageShedule(webDriver);
    }

    public AdmissionSchedule admissionSchedule() {
        return new AdmissionSchedule(webDriver);
    }

    public TransferRecords transferRecords() {
        return new TransferRecords(webDriver);
    }

    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public LoginPage loginPage() {
        return new LoginPage(webDriver);
    }
}
