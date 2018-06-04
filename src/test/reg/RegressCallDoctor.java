import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RegressCallDoctor extends TestBase {
    String doctorName;
    String doctorFam;

    @Test(groups = "CallDoctorBase")
    public void testCallRegistratura() throws Exception {
        page.callDoctorPage().createCallRegistratura();
        page.fullCardPage().verifyCallRegistr();
    }

    @Test(groups = "CallDoctorBase")
    public void testCallMkab() throws Exception {
        page.callDoctorPage().createCallMkab();
        page.fullCardPage().verifyCallMkab();
    }

    @Test(groups = "CallDoctorBase", dependsOnMethods = {"testCallMkab"})
    public void testAppoindDoctor() throws Exception {
        page.fullCardPage().appoindDoctor();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);

        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyAppoindPoctor(doctorFam);
    }

    @Test(groups = "CallDoctorBase", dependsOnMethods = {"testCallMkab"})
    public void testCompleteService() throws Exception {
        page.fullCardPage().completeService();
        page.fullCardPage().verifyCompleteCall(doctorFam);


/**
 * попросил ваню дать уникальный id на кнопку завершить обслуживание и кнопку отмены
 * */

//        String doctorName = page.setDoctorPage().getDoctorName(1);
//        page.setDoctorPage().appendDoctor(doctorName);
//        String doctorFam = page.manageShedule().getSecondName(doctorName);
//        page.callDoctorPage().verifyAppoindPoctor(doctorFam);
    }

    @Ignore
    @Test(invocationCount = 20)
    public void testCallSMP() throws Exception {
        page.callDoctorPage().createCallSMP();
        page.fullCardPage().verifyCallSMP();
        page.callDoctorPage().closeRecordPage();
    }

    @Ignore
    @Test
    public void testCallCC() throws Exception {
    }

    @Ignore
    @Test
    public void testCallPortal() throws Exception {
    }

    @Ignore
    @Test
    public void testSetDoctor() throws Exception {
        //проверять имя врача на полной странице вызова и на дашборде через фильтр ФИО
    }

    @Ignore
    @Test
    public void testVerifyDashboard() throws Exception {
        //нужно создавать вызов с уникальным именем и искать его через фильтр
    }

    @Ignore
    @Test(dependsOnMethods = {"testCallRegistratura"})
    public void testСancelRecord() {
        page.callDoctorPage().cancelRecord();
        page.callDoctorPage().verifyCancelOnDashbord();
    }

    @Ignore
    @Test(dependsOnMethods = {"testCallRegistratura"})
    public void closeBtn() {
        page.callDoctorPage().closeRecordPage();
    }
}