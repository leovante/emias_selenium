package calldoctor.regress;

import calldoctor.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD02 extends TestBase {
    String nameGen;

    @BeforeMethod
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "regress")
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallRegistrProfile1(nameGen);
        page.fullCardPage().verifyCallRegistrProfile1New(nameGen);
    }

    @Test(groups = "regress", dependsOnMethods = {"testCallRegistr"})
    public void testEditCallRegistrNew() throws Exception {
        page.editCardPage().editCallBtn();
        page.editCardPage().editCallRegistrProfile2(nameGen);
        page.fullCardPage().verifyCallRegistrProfile2New(nameGen);
    }
/*
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