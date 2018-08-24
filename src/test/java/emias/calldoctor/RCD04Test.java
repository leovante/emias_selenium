package emias.calldoctor;

import emias.AbstractTest;

public class RCD04Test extends AbstractTest {
    String nameGen;


//    @Test(groups = "CD", description = "передать вызов другому врачу")
//    @Issue("EMIAS-90")
////    @RetryCountIfFailed(2)
//    public void testSendCallToSecondDoctor_Registr() throws Exception {
//        open(curUrlCalldoctor);
//        page.createCallPage().createNewCall("Profile1", nameGen, "n");
//        page.fullCardPage().chooseDoctorBtn();
//        page.setDoctorPage().chooseDoctor("Profile1");
//        page.fullCardPage().changeDoctorBtn();
//        page.setDoctorPage().chooseDoctor("Profile2");
//        page.fullCardPage()
//                .verifyCallActivityGroup(nameGen, "Profile1", "Profile2")
//                .closeCardBtn();
//        page.dashboardPage()
//                .clearFilterDepart()
//                .searchFilterFio(nameGen)
//                .verifyActiveDocGroup(nameGen, "Profile2", "Profile1");
//    }
}