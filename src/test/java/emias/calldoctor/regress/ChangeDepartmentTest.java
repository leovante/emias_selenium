package emias.calldoctor.regress;

import emias.AbstractTest;
import emias.testngRetryCount2.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ChangeDepartmentTest extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferLpu-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferLpu-Dep", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
        page.fullCardPage().verifyDepart("ProfileTransferLpu-Dep", "detskayaPol");
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferDep-Dep", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Dep", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Dep", "detskayaPol");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Dep", "detskayaPol")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Dep", "vzroslayaPol");
        page.fullCardPage().verifyDepart("ProfileTransferDep-Dep", "vzroslayaPol");
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("ProfileTransferDep-Lpu", nameGen, "n");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Lpu", "firstDepart")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Lpu", "detskayaPol");
        page.fullCardPage()
                .verifyDepart("ProfileTransferDep-Lpu", "detskayaPol")
                .transferToDepartBtn();
        page.setLpuPage().transfer("ProfileTransferDep-Lpu", "firstDepart");
        page.fullCardPage().verifyDepart("ProfileTransferDep-Lpu", "firstDepart");
    }

    @Test(groups = "CD", description = "передача вызова из ЛПУ в ЛПУ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Lpu() {
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
//        page.setLpuPage().transfer("ProfileTransferDep-Dep", "firstDepart");
//        page.fullCardPage().verifyDepart("firstDepart");
    }

    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ
    // TODO: 11.09.2018 проверить что на странице передачи в другое лпу у взрослого вызова не отображается детская поликлиника и наоборот
}