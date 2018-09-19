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

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class PerehodyServisovTest extends AbstractTestGrid {

    @Test(groups = "test", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile1", nameGen)
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "test", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile1")
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "test", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        beforecdCD.loginMis_Calldoctor();
//        driver.close();
        switchTo().window(0);
        page.homePage().exitBtn();
        page.loginPage().login("Admin", "RChS2014");
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        $(By.xpath("//*[contains(.,'Узкий Врач')]")).shouldBe(Condition.visible);
    }
}