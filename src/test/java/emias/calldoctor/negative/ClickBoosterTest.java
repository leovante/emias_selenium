package emias.calldoctor.negative;

import emias.AbstractTestGrid;

public class ClickBoosterTest extends AbstractTestGrid {

//    @Test(groups = "CD", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты")
//    @Epic("Негативные тесты")
//    @RetryCountIfFailed(2)
//    public void testAppendTomorrowClickBooster() throws Exception {
//        Pacient pacient = new Pacient("Profile3_Kladr");
//        Doctor doctor = new Doctor("MokovStendTestovoe");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient).createCall_Api();
//        page.dashboardPage().openNewCallDash(pacient);
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage().chooseDoctorTodayBooster(doctor);
//        // TODO: 12/6/2018 тут нужно как-то прикрутить прокси и запускать тест при слабом интернете
//    }
//
//    @Test(groups = "CD", description = "закликивание кнопки 'записать' что бы проверить что не создаются дубликаты", enabled = false)
//    @Epic("Негативные тесты")
//    @RetryCountIfFailed(2)
//    public void testZapisatClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile0_1");
//        Doctor doctor = new Doctor("SerovaStendTestovoe");
//        enter.enterCalldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage().zapisatClickBooster(doctor);
//        page.fullCardPage(testName())
//                .verifyNewCall(pacient)
//                .closeCardBtn();
//    }
//
//    @Test(groups = "test", description = "закликивание кнопки 'записать и добавить' что бы проверить что не создаются дубликаты")
//    @Epic("Негативные тесты")
//    @RetryCountIfFailed(2)
//    public void testZapisatDobavitClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile0_1");
//        Doctor doctor = new Doctor("SerovaStendTestovoe");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//
//        enter.enterCalldoctorFromMis();
////        page.createCallPage().createCall(pacient);
//        page.createCallPage(pacient).createCall_Api();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage().zapisatDobavitClickBooster(doctor);
//        page.fullCardPage(testName())
//                .verifyNewCall(pacient)
//                .closeCardBtn();
//    }
}