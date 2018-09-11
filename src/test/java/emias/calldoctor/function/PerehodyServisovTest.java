/**
 * тут проверяем всякую мелочь
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class PerehodyServisovTest extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
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
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile2");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile2")
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "test", description = "проверка учетки врача при перезаходе под другим логином и паролем")
    @Epic("Переходы")
    @RetryCountIfFailed(2)
    public void testRelogingAnotherOperator() {
        open(curUrlCalldoctor);
        driver.close();
        switchTo().window(0);
        page.homePage().exitBtn();
        page.loginPage().login("Admin", "RChS2014");
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        $(By.xpath("//*[contains(.,'Узкий Врач')]")).shouldBe(Condition.visible);
    }

}