package test.arm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuleAdmissionSchedule {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public ModuleAdmissionSchedule(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

//    зайти в расписание приема, выбрать первого врача
//    найти новую запись - прием по очереди и создать запись пациента

    public void selectDoctor(){

    }

    public void createTask(){

    }

}
