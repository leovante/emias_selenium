import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RCD02 extends TestBase {
    @BeforeMethod
    public void beforeMethod() {
        //тут напиши всякие ожидалки загрузки страницы
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

/*
    @Test(groups = "regress")
    public void testEditCallRegistrNew() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallMkabNew();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallRegistrActivity() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallRegistrMkab2Activity();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallRegistrMkabNew() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallMkabNew();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallRegistrMkabActivity() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallRegistrMkab2Activity();
        page.editCardPage().saveCallBtn();
    }


    @Test(groups = "regress")
    public void testEditCallSMPNew() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallMkabNew();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallSMPActivity() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallRegistrMkab2Activity();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallSMPMkabNew() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallMkabNew();
        page.editCardPage().saveCallBtn();
    }

    @Test(groups = "regress")
    public void testEditCallSMPMkabActivity() throws Exception {
        //есть косяк, когда нажимаем изменить вызов
        //подгружаемые данные в поля не отображаются в верстке
        page.editCardPage().editCallBtn();
        page.editCardPage().verifyCallRegistrMkab2Activity();
        page.editCardPage().saveCallBtn();
    }
*/

}
