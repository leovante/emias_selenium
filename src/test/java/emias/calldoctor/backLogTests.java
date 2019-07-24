package emias.calldoctor;

public class backLogTests {
    /*
    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile4");
        select.enterPortal();
        page.portalDashboard().createCall(pacient);
        page.misHome().calldoctor();
        page.dashboard()
                .clearAllFilters()
                .openNewCallDash(pacient);
        page.fullCard(testName()).verifyNewCall(pacient);
    }

        @Test(groups = "CD", description = "вызов из КЦ по api, ребенок по МКАБ без КЛАДР.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab2() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile20");
        page.misHome().calldoctor();
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
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall(pacient);//почему-то 2 педиатрический сразу. С Таким адресом два участка
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

*/
}