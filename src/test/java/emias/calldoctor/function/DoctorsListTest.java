package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DoctorsListTest extends TestBase {
    @Test(groups = "CD", description = "пустой вызов ребенка М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_male() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile7");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isVisibleText(mokov.getUchastocs());
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов ребенка Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_female() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile8");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isVisibleText(mokov.getUchastocs());
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов ребенка без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile9");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isVisibleText(mokov.getUchastocs());
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isNotVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_male() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile10");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();

        assistance.isNotVisibleText(mokov.getUchastocs());
        assistance.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_female() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile11");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isNotVisibleText(mokov.getUchastocs());
        assistance.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile12");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isNotVisibleText(mokov.getUchastocs());
        assistance.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов Без Возр Кат, Без Пола, СМП")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void call_noAge_noGender() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile13");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isVisibleText(mokov.getUchastocs());
        assistance.isNotVisibleText(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        assistance.isVisibleText(nemcova.getUchastocs());
        assistance.isVisibleText(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "проверка что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor operator = new Doctor("Operator");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        assistance.isVisibleText(operator.getDepartment());
        assistance.isVisibleText(nemcova.getUchastocs());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        assistance.isVisibleText("УЧАСТКОВЫЙ ВРАЧ");
        assistance.isVisibleText(nemcova.getUchastocs());
    }

    /**
     * сломан формализатор на стенде. Тест пока не работает
     */
    @Test(groups = "CD", description = "вызов по api СМП без авторизации. Проверка отображения участкового")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladrApi() throws IOException, InterruptedException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("ProfileDetkina");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .openNewCallDash(pacientImpl);
        assistance.isVisibleText(operator.getDepartment());
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .chooseDoctorBtn()
                .saveAdressAsKladr();
        assistance.isVisibleText(mokov.getUchastocs());
    }

    @Test(groups = "CD", description = "оператор из подразделения видит только своих врачей")
    @Epic("Создание вызова")
    @Issue("EMIAS-659")
    @RetryCountIfFailed(2)
    public void viewDoctorList_OnlyFromCurrentDepart() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile13");
        page.misHome().calldoctorVzroslaya();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        SelenideElement doctorsBlock = $(By.id("otherDoctors")).$x("../.");
        doctorsBlock.$x(".//*[contains(text(),'Юдина')]").shouldBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Темников')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Моков')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Серова')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Немцова')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Зайцева')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "после редактирования карты на профиль без возрастной категории отобразятся все врачи")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testViewDoctorsListAfterEditChildCard() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacient = new PacientImpl("Profile2");
        PacientImpl pacient2 = new PacientImpl("Profile0_2");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage()
                .saveBtn()
                .allertBtn();
        $x("//*[contains(text(),'Без возрастной категории')]").shouldBe(Condition.visible);
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().saveAddress();
        SelenideElement doctorsBlock = $(By.id("otherDoctors")).$x("../.");
        doctorsBlock.$x("//*[contains(text(),'Юдина')]").shouldBe(Condition.visible);
        doctorsBlock.$x("//*[contains(text(),'Темников')]").shouldBe(Condition.visible);
        doctorsBlock.$x("//*[contains(text(),'Моков')]").shouldBe(Condition.visible);
        doctorsBlock.$x("//*[contains(text(),'Серова')]").shouldBe(Condition.visible);
        doctorsBlock.$x("//*[contains(text(),'Немцова')]").shouldBe(Condition.visible);
        doctorsBlock.$x("//*[contains(text(),'Зайцева')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "после редактирования карты и изменения адреса пропадает привязка к старому участку")
    @Epic("Создание вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testUchastokAfterEditMkabCard() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacient = new PacientImpl("Profile2");
        PacientImpl pacient2 = new PacientImpl("Profile0_2");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage_Mkab()
                .saveBtn();
        $x("//*[contains(text(),'#1 Гинекологический')]").shouldNotBe(Condition.visible);
    }
}