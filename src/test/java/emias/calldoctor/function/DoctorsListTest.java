package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.commons.assistance.Assistance.notVisible;
import static com.commons.assistance.Assistance.visible;

public class DoctorsListTest extends TestCallDoctorBase {
    @Test(groups = "CD", description = "пустой вызов ребенка М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void childCall_male() {
        Pacient pacient = new PacientImpl("Profile7");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
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
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
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
        Pacient pacient = new PacientImpl("Profile9");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        visible(mokov.getUchastocs());
        visible(nemcova.getUchastocs());
        notVisible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого М")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_male() {
        Pacient pacient = new PacientImpl("Profile10");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();

        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого Ж")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_female() {
        Pacient pacient = new PacientImpl("Profile11");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов взрослого без пола")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void adultCall_noGender() {
        Pacient pacient = new PacientImpl("Profile12");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        notVisible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "пустой вызов Без Возр Кат, Без Пола, СМП")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void call_noAge_noGender() {
        Pacient pacient = new PacientImpl("Profile13");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        Doctor serova = new Doctor("SerovaStendTestovoe");
        Doctor ginekolog = new Doctor("GinekologTestovayaGinekologi");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        visible(mokov.getUchastocs());
        notVisible(ginekolog.getUchastocs());//не отобразится, потому что oms_kl_TypeU.isMain = 0
        visible(nemcova.getUchastocs());
        visible(serova.getUchastocs());
    }

    @Test(groups = "CD", description = "проверка что отобразился участковый")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() {
        Pacient pacient = new PacientImpl("Profile2");
        Doctor operator = new Doctor("Operator");
        Doctor nemcova = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        visible(operator.getDepartment());
        visible(nemcova.getUchastocs());
        page.fullCard(pacient, testName()).chooseDoctorBtn();
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
        Pacient pacient = new PacientImpl("ProfileDetkina");
        Doctor operator = new Doctor("Operator");
        Doctor mokov = new Doctor("MokovStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard()
                .dashFilter_fio(pacient)
                .openNewCallDash(pacient);
        visible(operator.getDepartment());
        page.fullCard(pacient, testName())
                .verifyNewCall()
                .chooseDoctorBtn()
                .saveAdressAsKladr();
        page.createCall(pacient)
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
        Pacient pacient = new PacientImpl("Profile13");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorUdina();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        SelenideElement doctorsBlock = $(By.id("otherDoctors")).$x("../.");
        doctorsBlock.$x(".//*[contains(text(),'Юдина')]").shouldBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Темников')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Моков')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Серова')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Немцова')]").shouldNotBe(Condition.visible);
        doctorsBlock.$x(".//*[contains(text(),'Зайцева')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "оператор с ролью (диспетчер администратор) видит всех врачей")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void viewFullDoctorList_OperatorAdmin() {
        Pacient pacient = new PacientImpl("Profile13");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorUdina();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
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
        Pacient pacient = new PacientImpl("Profile2");
        Pacient pacient2 = new PacientImpl("Profile0_2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage_Mkab()
                .saveBtn();
        $x("//*[contains(text(),'#1 Гинекологический')]").shouldNotBe(Condition.visible);
    }
}