/**
 * проверяем что список врачей корректно отображается
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DoctorsListTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "создаю пустой вызов ребенка М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile7");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов ребенка Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall2() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile8");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов ребенка Без Пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall3() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile9");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall4() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile10");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall5() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile11");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого Без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall6() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile12");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов Без Возр Кат, Без Пола, СМП")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testChildCall7() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile13");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов в ВД что бы проверить что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladr() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("ProfileDetkina");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Api(pacient);
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .openNewCallDash(pacient);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .chooseDoctorBtn()
                .saveAdressAsKladr();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, проверка что неформализованному адресу нельзя назначить врача")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile19");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Api(pacient);
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(text(),'Выберите врача')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Поиск врача')]")).shouldNotBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "проверяю что оператор из подразделения видит только своих врачей")
    @Epic("Создание вызова")
    @Issue("EMIAS-659")
    @RetryCountIfFailed(2)
    public void testViewDoctorsListFromDepart() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile13");
        page.loginPage().loginAdmin();
        page.homePageMis().callDoctorBtn();
        switchTo().window(1);
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(text(),'Юдина')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Темников')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Моков')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Серова')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Немцова')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Зайцева')]")).shouldNotBe(Condition.visible);
    }
}