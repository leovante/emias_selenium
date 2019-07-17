package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.*;

public class PerehodyServisovTest extends TestBase {

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacientImpl, testName())
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacientImpl, testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка изменения врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() throws IOException {
        Doctor operator = new Doctor("Operator");
        page.misHomePage().calldoctor();
        $x("//header")
                .$x(".//*[contains(.,'" + operator.getFamily() + " " + operator.getName() + "')]")
                .shouldBe(Condition.visible);
        switchTo().window(0);
        page.misHomePage().calldoctorFromMis();
        $x("//header")
                .$x(".//*[contains(.,'Вызов врача на дом')]")
                .shouldBe(Condition.visible);
        $x("//header")
                .$x(".//*[contains(.,'" + operator.getFamily() + " " + operator.getName() + "')]")
                .shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "выход из диспетчера в МИС")
    @Epic("Переходы")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        page.misHomePage().calldoctor();
        page.dashboardPage().exitToMis();
        page.misHomePage().validateLoginPage();
    }

    @Test(groups = "CD", description = "проверка перехода на сайт с инструкцией")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testInstruction() {
        page.misHomePage().calldoctor();
        page.dashboardPage().instructionTab();
        page.misHomePage().validateForumInstruction();
    }
}