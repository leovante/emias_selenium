package emias.calldoctor2.regress;

import emias.TestBase;

public class CancelCallTest extends TestBase {

//    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
//    @Epic("Отмена вызова")
//    @RetryCountIfFailed(2)
//    public void testCancelCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile1");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).cancelOnFullCardBtn("отмена автотестом");
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .verifyCallIsCancelFromDashboard(pacient);
//    }
//
//    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
//    @Epic("Отмена вызова")
//    @RetryCountIfFailed(2)
//    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile1");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName())
//                .editCallBtn()
//                .cancelOnChangePageBtn();
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .verifyCallIsCancelFromDashboard(pacient);
//    }
//
//    @Test(groups = "CD", description = "отмена вызова на дашборде")
//    @Epic("Отмена вызова")
//    @RetryCountIfFailed(2)
//    public void testCancelCallFrom_DashBoard() throws InterruptedException, IOException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile1");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).closeCardBtn();
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .deleteNewCallProgressFrame(pacient)
//                .verifyCallIsCancelFromDashboard(pacient);
//    }
}