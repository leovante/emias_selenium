/**
 * тут проверяем всякую мелочь
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.*;

public class PerehodyServisovTest extends TestBase {

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() throws IOException {
        Doctor operator = new Doctor("Operator");
        page.loginPage().calldoctor();
        $x("//header[@class='header']").$x(".//*[contains(.,'" + operator.getFamily() + " " + operator.getName() + "')]").shouldBe(Condition.visible);
        switchTo().window(0);
        page.loginPage().calldoctorFromMis();
        $x("//*[contains(text(),'Вызов врача на дом')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'" + operator.getFamily() + " " + operator.getName() + "')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "выход из диспетчера в МИС")
    @Epic("Переходы")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        page.loginPage().calldoctor();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка перехода на сайт с инструкцией")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testInstruction() {
        page.loginPage().calldoctor();
        page.dashboardPage().instructionTab();
        $(By.xpath("//span[contains(text(),'Инструкция диспетчера по вызову врача на дом.pdf')]")).shouldBe(Condition.visible);
    }
}