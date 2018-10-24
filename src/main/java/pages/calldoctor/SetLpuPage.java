package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.doctors_interfaces.Doctor;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class SetLpuPage extends AbstractPage {

    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public void transfer(Doctor doctor) throws IOException {
        $(By.xpath("//*[contains(text(),'" + doctor.getDepartment() + "')]")).click();
        $(By.xpath("//*[contains(text(),'Передать')]")).click();
        $(By.xpath("/html/body/app-root/app-call-doctor/main/app-call-doctor-other/app-call-doctor-other-lpu/div[2]/div[4]/div[2]/div[2]/a[2]/mat-icon")).click();
    }
}
