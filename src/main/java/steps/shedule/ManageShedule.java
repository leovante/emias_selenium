package steps.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;
import pages.WaitAll;

public class ManageShedule{
    private WebDriver webDriver;
    Pages website;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    public ManageShedule(WebDriver driver){
        webDriver = driver;
        website = new Pages(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void createShedule() throws InterruptedException, ClassNotFoundException {
        String docFullName = website.manageShedule().getUnicalDoctor(null);
        String secondName = website.manageShedule().getSecondName(docFullName);
        sql.deleteShedule(secondName);
        website.manageShedule().selectDoctor(docFullName);
        website.manageShedule().createShedule();
    }

    public void verifyCreatedShedule()  throws InterruptedException{
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div"))//поле с заявками
                .findElement(By.xpath("//*[contains(text(),'07:00 ')]"));
    }

    public void createTwoShedule() throws ClassNotFoundException, InterruptedException {
        String first_doctor_fullname = website.manageShedule().getUnicalDoctor(null);
        String first_doctor_fam = website.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = website.manageShedule().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = website.manageShedule().getSecondName(first_doctor_fullname);
        //sql.deleteShedule(first_doctor_fam);
        //sql.deleteShedule(second_doctor_fam);
        website.manageShedule().selectDoctor(first_doctor_fullname);
        website.manageShedule().createShedule();
        website.manageShedule().selectDoctor(first_doctor_fullname);
        website.manageShedule().selectDoctor(second_doctor_fullname);
        website.manageShedule().createShedule();
    }


    public void setNotReciveDays(){
        website.manageShedule().setNotReceiveDays();
    }

    public void verifyNotReciveDays(){
        website.manageShedule().checkNotReceiveDays();
    }

    public void copyShedule() throws InterruptedException {
        String docName = website.manageShedule().getUnicalDoctor(null);
        website.manageShedule().selectDoctor(docName);
        website.manageShedule().createShedule();
        String docNameTwo = website.manageShedule().getUnicalDoctor(docName);
        website.manageShedule().selectDoctor(docNameTwo);
        website.manageShedule().copyShedule(docName);
        website.manageShedule().selectDoctor(docName);
        verifyCreatedShedule();
    }

    public void deleteShedule() throws InterruptedException {
        website.manageShedule().deleteShedule();
    }

    public void verifyDeletedShedule(){
        website.manageShedule().checkDeletedShedle();
    }
}