package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.utils.assistance.Assistance.notVisible;
import static com.utils.assistance.Assistance.visible;

public class DoctorsListTest extends TestBase {
    @Test(groups = "CD", description = "пустой вызов ребенка М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_male() {
        PacientImpl pacientImpl = new PacientImpl("Profile7");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        visible(mokov.getUchastocs());
        visible(nemcova.getUchastocs());
        notVisible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "вызов ребенка Ж. Не отображать участки терапевтов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_female() {
        Pacient pacient = new PacientImpl("Profile8");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome()
                .calldoctor();
        page.createCall(pacient)
                .createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName())
                .chooseDoctorBtn();
        visible(mokov.getUchastocs());
        visible(nemcova.getUchastocs());
        notVisible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов ребенка без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_noGender() {
        PacientImpl pacientImpl = new PacientImpl("Profile9");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        visible(mokov.getUchastocs());
        visible(nemcova.getUchastocs());
        notVisible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_male() {
        PacientImpl pacientImpl = new PacientImpl("Profile10");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();

        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_female() {
        PacientImpl pacientImpl = new PacientImpl("Profile11");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_noGender() {
        PacientImpl pacientImpl = new PacientImpl("Profile12");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов Без Возр Кат, Без Пола, СМП")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void call_noAge_noGender() {
        PacientImpl pacientImpl = new PacientImpl("Profile13");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        visible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "проверка что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor operator = new Doctor("Operator");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        visible(operator.getDepartment());
        visible(nemcova.getUchastocs());
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        visible("УЧАСТКОВЫЙ ВРАЧ");
        visible(nemcova.getUchastocs());
    }

    /**
     * сломан формализатор на стенде. Тест пока не работает
     */
    @Test(groups = "CD", description = "вызов по api СМП без авторизации. Проверка отображения участкового")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladrApi() {
        PacientImpl pacientImpl = new PacientImpl("ProfileDetkina");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard()
                .dashFilter_fio(pacientImpl)
                .openNewCallDash(pacientImpl);
        visible(operator.getDepartment());
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .chooseDoctorBtn()
                .saveAdressAsKladr();
        page.createCall(pacientImpl)
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'" + mokov.getUchastocs() + "')]").click();
        $x("//*[contains(text(),'Сохранить')]").click();
        $x("//*[contains(text(),'Выберите врача')]").click();
        visible(mokov.getUchastocs());
    }

    @Test(groups = "CD", description = "оператор из подразделения видит только своих врачей")
    @Epic("Создание вызова")
    @Issue("EMIAS-659")
    @RetryCountIfFailed(2)
    public void viewDoctorList_OnlyFromCurrentDepart() {
        PacientImpl pacientImpl = new PacientImpl("Profile13");
        page.misHome().calldoctorUdina();
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

    @Test(groups = "CD", description = "после редактирования карты и изменения адреса пропадает привязка к старому участку")
    @Epic("Создание вызова")
    @Issue("EMIAS-956")
    @RetryCountIfFailed(2)
    public void testUchastokAfterEditMkabCard() {
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