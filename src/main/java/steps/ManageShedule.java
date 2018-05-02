package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;
import pages.WaitLoader;

public class ManageShedule{
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    public ManageShedule(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createShedule() throws InterruptedException, ClassNotFoundException {
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        sql.deleteShedule(docName); //Нужно найти таблицу где полностью ФИО или из стринга вытаскивать фамилию
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
    }

    public void verifyCreatedShedule()  throws InterruptedException{
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//*[contains(text(),'07:00 ')]"));
    }

    public void setNotReciveDays(){
        website.scheduleDoctors().setNotReceiveDays();
    }

    public void verifyNotReciveDays(){
        website.scheduleDoctors().checkNotReceiveDays();
    }

    public void copyShedule() throws InterruptedException {
        String docName = website.scheduleDoctors().getUnicalDoctor(null);
        website.scheduleDoctors().selectDoctor(docName);
        website.scheduleDoctors().createShedule();
        String docNameTwo = website.scheduleDoctors().getUnicalDoctor(docName);
        website.scheduleDoctors().selectDoctor(docNameTwo);
        website.scheduleDoctors().copyShedule(docName);
        website.scheduleDoctors().selectDoctor(docName);
        verifyCreatedShedule();
    }

    public void deleteShedule() throws InterruptedException {
        website.scheduleDoctors().deleteShedule();
    }

    public void verifyDeletedShedule(){
        website.scheduleDoctors().checkDeletedShedle();
    }
}
