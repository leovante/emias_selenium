package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RCD06Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferLpu-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
        page.fullCardPage().verifyDepart("detskayaPol");
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferDep-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
        page.fullCardPage()
                .verifyDepart("detskayaPol")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Dep", "vzroslayaPol");
        page.fullCardPage().verifyDepart("vzroslayaPol");
    }

    @Test(groups = "CD", description = "передача вызова в другоей ЛПУ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallLPU_LPU() {
//        open(curUrlCalldoctor);
//        page.createCallPage()
//                .createNewCall("ProfileTransferDep-Dep", nameGen, "n");
//        page.fullCardPage()
//                .verifyDepart("firstDepart")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
//        page.fullCardPage()
//                .verifyDepart("detskayaPol")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferDep-Dep", "vzroslayaPol");
//        page.fullCardPage().verifyDepart("vzroslayaPol");
    }

    // TODO: 13.08.2018 передать вызов из подразделения в юр. Лицо
    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ
}