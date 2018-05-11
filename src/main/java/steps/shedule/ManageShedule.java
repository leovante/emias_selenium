package steps.shedule;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;

import java.io.IOException;
import java.net.URL;

public class ManageShedule {
    private WebDriver webDriver;
    Pages website;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();


    public ManageShedule(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void createShedule() throws InterruptedException, ClassNotFoundException {
        website.mainPage().manageSheduleBtn();
        String docFullName = website.doctorOperators().getUnicalDoctor(null);
        String secondName = website.manageShedule().getSecondName(docFullName);
        sql.deleteShedule(secondName);
        website.doctorOperators().selectDoctor(docFullName);
        website.manageShedule().createShedule();
    }

    public void createTwoShedule() throws ClassNotFoundException, InterruptedException {
        website.mainPage().manageSheduleBtn();
        String first_doctor_fullname = website.doctorOperators().getUnicalDoctor(null);
        String first_doctor_fam = website.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = website.doctorOperators().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = website.manageShedule().getSecondName(second_doctor_fullname);
        sql.deleteShedule(first_doctor_fam);
        sql.deleteShedule(second_doctor_fam);

        website.doctorOperators().selectDoctor(first_doctor_fullname);
        website.manageShedule().createShedule();
        website.doctorOperators().selectDoctor(first_doctor_fullname);
        website.doctorOperators().selectDoctor(second_doctor_fullname);
        website.manageShedule().createShedule();
    }

    public void setNotReciveDays() {
        website.mainPage().manageSheduleBtn();
        website.manageShedule().setNotReceiveDays();
    }

    public void copyShedule() throws InterruptedException, ClassNotFoundException {
        String firstDoctor = website.doctorOperators().getUnicalDoctor(null);
        String secondDoctor = website.doctorOperators().getUnicalDoctor(firstDoctor);
        String second_doctor_fam = website.manageShedule().getSecondName(secondDoctor);
        sql.deleteShedule(second_doctor_fam);

        website.mainPage().manageSheduleBtn();
        website.doctorOperators().selectDoctor(firstDoctor);
        website.manageShedule().createShedule();
        website.doctorOperators().selectDoctor(secondDoctor);
        website.manageShedule().copyShedule(firstDoctor);
        website.doctorOperators().selectDoctor(firstDoctor);
    }

    public void deleteShedule() throws InterruptedException {
        website.manageShedule().deleteShedule();
    }

    public void verifyDeletedShedule() {
        website.manageShedule().verifyDeletedShedle();
    }

    public void verifyNotReciveDays() {
        website.manageShedule().verifyNotReceiveDays();
    }

    public void verifyCreatedShedule() throws InterruptedException {
        website.manageShedule().verifyCreatedShedule();
    }
}
