/**
 * тут проверяем всякую мелочь
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class PerehodyServisovTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException, ParseException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneCall(pacient, doctor)
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException, ParseException {
        Pacient pacient = new Pacient("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneCall(pacient, doctor)
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        enterSite.enterCalldoctor();
        switchTo().window(0);
        page.homePage().exitBtn();
        page.loginPage().login("Admin", "RChS2014");
        page.homePage().callDoctorBtn();
        switchTo().window(2);
        $(By.xpath("//*[contains(.,'Узкий Врач')]")).shouldBe(Condition.visible);
    }
}