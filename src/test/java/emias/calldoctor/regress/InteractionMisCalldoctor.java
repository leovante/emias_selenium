package emias.calldoctor.regress;

import emias.TestBase;

public class InteractionMisCalldoctor extends TestBase {

//    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня", enabled = false)
//    @Epic("Назначить врача")
//    @RetryCountIfFailed(2)
//    public void testAppendDoctorToCall_Registr() throws Exception {
//        Pacient pacient = new Pacient("Profile1");
//        Doctor doctor = new Doctor("SerovaStendTestovoe");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage().chooseDoctorToday(doctor);
//        page.fullCardPage(testName()).verifyActivCall(pacient);
//
//        page.loginPage().loginMis(site, loginMis, pass);
//        page.homePageMis().raspisaniPriemaBtn();
//        page.doctorMethods().selectDoctor(doctor);
//
//    }
//
//    @Test(groups = "CD", description = "проверка заполнения формализованного адреса при выборе мкаб на странице создания вызова")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testFormalizeAddress() throws Exception {
//        Pacient pacient = new Pacient("Profile2");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient)
//                .addNewCall()
//                .searchField();
//        $(By.xpath("//*[@placeholder='Адрес']")).getText().equals(pacient.getAddress3adv());
//    }
//
//    @Test(groups = "CD", description = "проверка заполнения неформализованного адреса при выборе мкаб на странице создания вызова")
//    @Epic("Создание вызова")
//    @RetryCountIfFailed(2)
//    public void testNotformalizeAddress() throws Exception {
//        Pacient pacient = new Pacient("Temnikov94");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient)
//                .addNewCall()
//                .searchField();
//        $(By.xpath("//*[contains(text(),'Московская обл., Рузский р-н., дп. Учитель СНТ, д.1')]")).shouldBe(Condition.visible);
//    }
}
