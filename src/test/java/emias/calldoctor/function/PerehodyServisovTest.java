/**
 * тут проверяем всякую мелочь
 */

package emias.calldoctor.function;

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
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(testName())
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
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall_Mkab();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        enter.enterCalldoctorFromMis();
        switchTo().window(0);
        enter.enterCalldoctorFromMisGenerator("generator", "1212");
        switchTo().window("Центр управления");
        $(By.xpath("//*[contains(.,'Генератор Маршрутного')]")).shouldBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "выход из диспетчера в МИС")
    @Epic("Переходы")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        enter.enterCalldoctorFromMis();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка перехода на сайт с инструкцией")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testInstruction() {
        enter.enterCalldoctorFromMis();
        page.dashboardPage().instructionTab();
        $(By.xpath("//span[contains(text(),'Инструкция диспетчера по вызову врача на дом.pdf')]")).shouldBe(Condition.visible);
    }
}