package pages.calldoctor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class SetLpuPage {

    @Step("Передаю в другое подразделение на страинце поиска ЛПУ")
    public void transfer(String profile, String toDepart) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        $(By.xpath("//*[contains(text(),'" + proData.get(toDepart) + "')]")).click();
        $(By.xpath("//*[contains(text(),'Передать')]")).click();
        $(By.xpath("/html/body/app-root/app-call-doctor/main/app-call-doctor-other/app-call-doctor-other-lpu/div[2]/div[4]/div[2]/div[2]/a[2]/mat-icon")).click();
    }
}
