package pages.portal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;
import pages.sql.SQL;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class PortalDashboard extends AbstractPage {

    SelenideElement pereytiVElectrRegistr = $(By.xpath("//a[@class='b-btn b-btn--red b-registry-form__btn c-registry-form__btn']"));
    SelenideElement nPolField = $(By.xpath("//input[@name='nPol']"));
    SelenideElement birthdayField = $(By.xpath("//input[@name='birthday']"));
    SelenideElement uspeshnoVizvaliVracha = $(By.xpath("//*[contains(.,'Вы успешно вызвали врача на адрес:')]"));
    SelenideElement closeWindow = $(By.id("create-home-visit-popup-success")).$(By.xpath(".//*[contains(.,'Закрыть окно')]"));
    SelenideElement entrance = $(By.id("call_entrance"));
    SelenideElement doorphone = $(By.id("call_doorphone"));
    SelenideElement phone = $(By.id("call_phone"));
    SelenideElement description = $(By.id("call_description"));
    SelenideElement address = $(By.id("call_address"));
    SelenideElement stage = $(By.id("call_stage"));
    SelenideElement vizvatVrachaNaDom = $(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"));
    SelenideElement podtvVizovVracha = $(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"));
    SelenideElement adresVizova = $(By.xpath("//*[contains(text(),'Адрес вызова')]"));
    SelenideElement standEMIAS = $(By.xpath("//*[contains(text(),'Стенд ЕМИАС МО')]"));

    public PortalDashboard() {
    }

    @Step("создаю вызов через портал")
    public void createCall(Pacient pacient) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map <String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        SQL.finalizeCall_NPol(pacient.getNumberpol());

        nPolField.sendKeys(String.valueOf(pacient.getNumberpol()));
        birthdayField.sendKeys(pacient.getBirthdate());
        pereytiVElectrRegistr.click();
        standEMIAS.shouldBe(Condition.visible);
        vizvatVrachaNaDom.click();
        adresVizova.shouldBe(Condition.visible);

        address.setValue(pacient.getAddress());
        entrance.setValue(pacient.getEntrance());
        stage.setValue(pacient.getFloor());
        doorphone.setValue(pacient.getCodedomophone());
        phone.setValue(pacient.getPhone());
        description.setValue(pacient.getComplaint());

        podtvVizovVracha.click();

        closeWindow.shouldBe(Condition.visible);
        closeWindow.click();
    }
}