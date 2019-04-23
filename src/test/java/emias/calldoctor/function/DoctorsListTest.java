package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class DoctorsListTest extends TestBase {

    @Test(groups = "CD", description = "пустой вызов ребенка М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_male() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile7");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isVisibleText(mokov.getUchastocs());
        as.isVisibleText(nemcova.getUchastocs());
        as.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов ребенка Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_female() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile8");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isVisibleText(mokov.getUchastocs());
        as.isVisibleText(nemcova.getUchastocs());
        as.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов ребенка без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile9");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isVisibleText(mokov.getUchastocs());
        as.isVisibleText(nemcova.getUchastocs());
        as.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_male() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile10");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isNotVisibleText(mokov.getUchastocs());
        as.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        as.isVisibleText(nemcova.getUchastocs());
        as.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_female() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile11");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isNotVisibleText(mokov.getUchastocs());
        as.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        as.isVisibleText(nemcova.getUchastocs());
        as.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile12");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isNotVisibleText(mokov.getUchastocs());
        as.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        as.isVisibleText(nemcova.getUchastocs());
        as.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "создаю пустой вызов Без Возр Кат, Без Пола, СМП")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void call_noAge_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile13");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        as.isVisibleText(operator.getDepartment());
        page.fullCardPage(testName()).chooseDoctorBtn();
        as.isVisibleText(mokov.getUchastocs());
        as.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        as.isVisibleText(nemcova.getUchastocs());
        as.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "создаю вызов в ВД что бы проверить что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladr() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("ProfileDetkina");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .openNewCallDash(pacient);
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .chooseDoctorBtn()
                .saveAdressAsKladr();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, проверка что неформализованному адрессу нельзя назначить врача")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile19");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).chooseDoctorBtn();
        $(By.xpath("//*[contains(text(),'Выберите врача')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Поиск врача')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверяю что оператор из подразделения видит только своих врачей")
    @Epic("Создание вызова")
    @Issue("EMIAS-659")
    @RetryCountIfFailed(2)
    public void testViewDoctorsListFromDepart() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile13");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        $(By.xpath("//*[contains(text(),'Юдина')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Темников')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Моков')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Серова')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Немцова')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Зайцева')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверяю что после редактирования карты на профиль без возрастной категории отобразятся все врачи")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testViewDoctorsListAfterEditChildCard() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile2");
        Pacient pacient2 = new Pacient("Profile0_2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(testName()).editCallBtn();
        page.createCallPage(pacient)
                .setDeafult()
                .editCallPage(pacient2)
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Без возрастной категории')]")).shouldBe(Condition.visible);
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().saveAddress();
        $(By.xpath("//*[contains(text(),'Юдина')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Темников')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Зайцева')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверяю что после редактирования карты и изменения адреса пропадает привязка к старому участку")
    @Epic("Создание вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testUchastokAfterEditMkabCard() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile2");
        Pacient pacient2 = new Pacient("Profile0_2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(testName()).editCallBtn();
        page.createCallPage(pacient)
                .setDeafult()
                .editCallPage_Mkab(pacient2)
                .saveBtn();
        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
    }
}