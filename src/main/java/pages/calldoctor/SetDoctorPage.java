package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.doctors_interfaces.Doctor;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class SetDoctorPage extends AbstractPage {
    SelenideElement appenOnThisDay = $(By.xpath("//span[contains(.,'Назначить на сегодня')]"));

    public SetDoctorPage() {
    }

    @Step("назначиь врача")
    public SetDoctorPage chooseDoctor(Doctor doctor) throws IOException {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenOnThisDay.click();
        System.out.println("Врач выбран!");
        return this;
    }

    @Step("назначиь врача")
    public SetDoctorPage saveAddress() {
        $(By.xpath("//*[contains(text(),'Адрес успешно распознан')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
        return this;
    }
}