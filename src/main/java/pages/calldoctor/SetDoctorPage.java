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
    SelenideElement writeDown = $(By.xpath("//span[contains(text(),'Записать')]"));

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

    @Step("записать")
    public SetDoctorPage megaClickDoctor(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenOnThisDay.click();
        int i = 2;
        writeDown.click();
        while (writeDown.isDisplayed()) {
            writeDown.click();
            System.out.println("Я нажал на эту кнопку " + i + " раз");
            i++;
        }
        return this;
    }
}