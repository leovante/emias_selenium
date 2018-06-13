import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Created by DTemnikov on 07.06.2018.
 */
public class RegressCallDoctorTwo extends TestBase {

    @Test(groups = "CallDoctorRegress", invocationCount = 100)
    public void testCallRegistratura() throws Exception {
//        page.createCallPage().createCallRegistrProfile1(nameGen);
//        page.fullCardPage().verifyCallRegistrProfile1New(nameGen);
        page.fullCardPage().closeCallPageBtn();
    }


    @Ignore
    @Test(invocationCount = 20)
    public void testCallSMP() throws Exception {
        page.createCallPage().createCallSMP();
        page.fullCardPage().verifyCallSMPNew();
        page.fullCardPage().closeCallPageBtn();
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
        page.createCallPage().cancelRecord();
        page.createCallPage().verifyCancelOnDashbord();
    }

    @Ignore
    @Test(dependsOnMethods = {"testCallRegistratura"})
    public void closeBtn() {
        page.fullCardPage().closeCallPageBtn();
    }

}
