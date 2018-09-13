package pages.calldoctor;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class SetDoctorPage extends AbstractPage {
    SelenideElement appenOnThisDay = $(By.xpath("//span[contains(.,'Назначить на сегодня')]"));

    public SetDoctorPage() {
    }

    @Step("назначиь врача")
    public void chooseDoctor(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        $(By.xpath("//div[contains(text(),'" + proData.get("doctorFam") + "')]")).click();
        appenOnThisDay.click();
        System.out.println("Врач выбран!");
    }
}