package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Doctor;
import com.utils.assistance.DuringTestHelper;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class PerehodyServisovTest extends TestBase {

    @Test(groups = "CD", description = "проверка изменения врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        Doctor operator = new Doctor("Operator");

        page.misHome().calldoctorAdminTemnikov();
        $x("//header")
                .$x(".//*[contains(.,'" + operator.getFamily() + " " + operator.getName() + "')]")
                .shouldBe(Condition.visible);
        switchTo().window(0);
        page.misHome().calldoctorFromMis();
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
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard().exitToMis();
        page.misHome().validateLoginPage();
    }

    @Test(groups = "CD", description = "проверка перехода на сайт с инструкцией")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testInstruction() {
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard().instructionTab();
        page.misHome()
                .nextPage()
                .validateForumInstruction();
    }
}