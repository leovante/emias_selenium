import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RegressCallDoctor extends TestBase {

    @Test(groups = "CallDoctorBase")
    public void testCallRegistratura() throws Exception {
        page.callDoctorPage().createCallRegistratura();
        page.callDoctorPage().verifyCallRegistr();
        page.callDoctorPage().closeRecordPage();
    }

    @Ignore
    @Test(invocationCount = 20)
    public void testCallSMP() throws Exception {
        page.callDoctorPage().createCallSMP();
        page.callDoctorPage().verifyCallSMP();
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