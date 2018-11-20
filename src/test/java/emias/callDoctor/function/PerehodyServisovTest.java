/**
 * тут проверяем всякую мелочь
 */

package emias.callDoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PerehodyServisovTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage()
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Mkab(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage()
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        enterSite.enterCalldoctorFromMis();
        switchTo().window(0);
        enterSite.enterCalldoctorFromMisGenerator("generator", "1212");
        switchTo().window(2);
        $(By.xpath("//*[contains(.,'Генератор Маршрутного')]")).shouldBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "проверка кнопки выход")
    @Epic("Переходы")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        enterSite.enterCalldoctorFromMis();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка перехода на сайт с инструкцией")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testInstruction() {
        enterSite.enterCalldoctorFromMis();
        page.dashboardPage().instruction();
        switchTo().window(2);
        $(By.xpath("//span[contains(text(),'Инструкция диспетчера по вызову врача на дом.pdf')]")).shouldBe(Condition.visible);
    }
}