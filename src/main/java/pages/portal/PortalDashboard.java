package pages.portal;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Profile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class PortalDashboard extends AbstractPage implements Profile {

    SelenideElement pereytiVElectrRegistr = $(By.xpath("//a[@class='b-btn b-btn--red b-registry-form__btn c-registry-form__btn']"));
    SelenideElement nPolField = $(By.xpath("//input[@name='nPol']"));
    SelenideElement birthdayField = $(By.xpath("//input[@name='birthday']"));
    SelenideElement uspeshnoVizvaliVracha = $(By.xpath("//div/div/div[2]/h2[contains(.,'Вы успешно вызвали врача на адрес:')]"));
    SelenideElement entrance = $(By.id("call_entrance"));
    SelenideElement doorphone = $(By.id("call_doorphone"));
    SelenideElement phone = $(By.id("call_phone"));
    SelenideElement description = $(By.id("call_description"));
    SelenideElement address = $(By.id("call_address"));
    SelenideElement stage = $(By.id("call_stage"));

    public PortalDashboard() {
//        super(driver);
    }

    @Step("создаю вызов через портал")
    public void createCall(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        nPolField.setValue((String) proData.get(nomerPol));
        birthdayField.setValue((String) proData.get(birthDay));

        pereytiVElectrRegistr.click();
        $(By.xpath("//a[contains(text(),'Вызвать врача на дом')]")).click();

        address.setValue((String) proData.get(address));
        entrance.setValue((String) proData.get(pd));
        entrance.setValue((String) proData.get(stage));
        doorphone.setValue((String) proData.get(dfon));
        phone.setValue((String) proData.get(telephone));
        description.setValue((String) proData.get(zhaloba));

        $(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]")).click();
        assertTrue(uspeshnoVizvaliVracha.isDisplayed());
    }
}