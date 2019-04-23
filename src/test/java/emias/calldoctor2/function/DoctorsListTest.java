/**
 * проверяем что список врачей корректно отображается
 */

package emias.calldoctor2.function;

import emias.TestBase;

public class DoctorsListTest extends TestBase {

//    @Test(groups = "CD", description = "создаю пустой вызов ребенка М")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void childCall_male() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile7");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов ребенка Ж")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void childCall_female() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile8");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов ребенка Без Пола")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void childCall_noGender() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile9");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов взрослого М")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void adultCall_male() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile10");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов взрослого Ж")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void adultCall_female() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile11");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов взрослого Без пола")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void adultCall_noGender() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile12");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю пустой вызов Без Возр Кат, Без Пола, СМП")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void call_noAge_noGender() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile13");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю вызов в ВД что бы проверить что отобразился участковый")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testPreviewUchDoctorWithKladr() throws Exception {
//        Pacient pacient = new Pacient("Profile2");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить что отобразился участковый")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testPreviewUchDoctorWithoutKladr() throws IOException, InterruptedException, JSONException {
//        Pacient pacient = new Pacient("ProfileDetkina");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall_Api();
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .openNewCallDash(pacient);
//        page.fullCardPage(testName())
//                .verifyNewCall(pacient)
//                .chooseDoctorBtn()
//                .saveAdressAsKladr();
//        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "вызов от СМП по api, проверка что неформализованному адрессу нельзя назначить врача")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
//        Pacient pacient = new Pacient("Profile19");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall_Api();
//        page.dashboardPage().openNewCallDash(pacient);
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(text(),'Выберите врача')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Поиск врача')]")).shouldNotBe(Condition.visible);
//    }
//
//    @Flaky
//    @Test(groups = "CD", description = "проверяю что оператор из подразделения видит только своих врачей")
//    @Epic("Создание вызова")
//    @Issue("EMIAS-659")
//    @RetryCountIfFailed(2)
//    public void testViewDoctorsListFromDepart() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile13");
//        enter.calldoctorFromMis_Admin();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        $(By.xpath("//*[contains(text(),'Юдина')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Темников')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Моков')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Серова')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Немцова')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Зайцева')]")).shouldNotBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "проверяю что после редактирования карты на профиль без возрастной категории отобразятся все врачи")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testViewDoctorsListAfterEditChildCard() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile2");
//        Pacient pacient2 = new Pacient("Profile0_2");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall_Mkab();
//        page.fullCardPage(testName()).editCallBtn();
//        page.createCallPage(pacient)
//                .setDeafult()
//                .editCallPage(pacient2)
//                .saveBtn();
//        $(By.xpath("//*[contains(text(),'Без возрастной категории')]")).shouldBe(Condition.visible);
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage().saveAddress();
//        $(By.xpath("//*[contains(text(),'Юдина')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Темников')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Моков')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Серова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Немцова')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'Зайцева')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "проверяю что после редактирования карты и изменения адреса пропадает привязка к старому участку")
//    @Epic("Создание вызова")
//    @Issue("EMIAS-956")
//    @RetryCountIfFailed(2)
//    public void testUchastokAfterEditMkabCard() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile2");
//        Pacient pacient2 = new Pacient("Profile0_2");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall_Mkab();
//        page.fullCardPage(testName()).editCallBtn();
//        page.createCallPage(pacient)
//                .setDeafult()
//                .editCallPage_Mkab(pacient2)
//                .saveBtn();
//        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
//    }
}