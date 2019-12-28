package emias.calldoctor.backlog;

public class backLogTests {
    /*
    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile4");
        select.enterPortal();
        page.portalDashboard().createCall(pacient);
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard()
                .clearFilterDepart()
                .openNewCallDash(pacient);
        page.fullCard(testName()).verifyNewCall(pacient);
    }

        @Test(groups = "CD", description = "вызов из КЦ по api, ребенок по МКАБ без КЛАДР.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab2() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile20");
        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall(pacient);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

        @Test(groups = "CD", description = "вызов из КЦ по api, ребенок по МКАБ без КЛАДР. 2 участка. Проставиться не должен ни один")
    @Epic("Создание вызова")
    @Issue("EMIAS-657")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile14");
        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall(pacient);//почему-то 2 педиатрический сразу. С Таким адресом два участка
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

*/

    // противоречит тестам выше childCall_female
//    @Test(groups = "CD", description = "после редактирования карты на профиль без возрастной категории отобразятся все врачи")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testViewDoctorsListAfterEditChildCard() {
//        PacientImpl pacient = new PacientImpl("Profile2");
//        PacientImpl pacient2 = new PacientImpl("Profile0_2");
//        page.misHome()
//                .calldoctorAdminTemnikov();
//        page.createCall(pacient)
//                .createCall_Mkab();
//        page.fullCard(pacient, testName())
//                .editCallBtn();
//        page.createCall(pacient2)
//                .setDeafult()
//                .editCallPage()
//                .saveBtn()
//                .allertBtn();
//        $x("//*[contains(text(),'Без возрастной категории')]").shouldBe(Condition.visible);
//        page.fullCard(pacient, testName()).chooseDoctorBtn();
//        page.setDoctor().saveAddress();
//        SelenideElement doctorsBlock = $(By.id("otherDoctors")).$x("../.");
//        doctorsBlock.$x("//*[contains(text(),'Юдина')]").shouldBe(Condition.visible);
//        doctorsBlock.$x("//*[contains(text(),'Темников')]").shouldBe(Condition.visible);
//        doctorsBlock.$x("//*[contains(text(),'Моков')]").shouldBe(Condition.visible);
//        doctorsBlock.$x("//*[contains(text(),'Серова')]").shouldBe(Condition.visible);
//        doctorsBlock.$x("//*[contains(text(),'Немцова')]").shouldBe(Condition.visible);
//        doctorsBlock.$x("//*[contains(text(),'Зайцева')]").shouldBe(Condition.visible);
//    }

    //    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
//    @Epic("Назначить врача")
//    @RetryCountIfFailed(2)
//    public void testAppendDoctorToCall_Portal() throws Exception {
//        Pacient pacient = new Pacient("Profile4");
//        Doctor doctor = new Doctor("MokovStendTestovoe");
//        select.enterPortal();
//        page.portalDashboard().createCall(pacient);
//        page.misHome().calldoctorAdminTemnikov();
//        page.dashboard()
//                .clearFilterDepart()
//                .openNewCallDash(pacient);
//        page.fullCard(testName()).verifyNewCall(pacient);
//        page.fullCard(testName()).chooseDoctorBtn();
//        page.setDoctor()
//                .saveAddress()
//                .chooseDoctorToday(doctor);
//        page.fullCard(testName())
//                .verifyActivCall(pacient)
//                .closeCardBtn();
//        page.dashboard()
//                .clearFilterDepart()
//                .verifyActiveDocGroup(pacient, doctor);
//    }
}